package
        Storage;

import Marketing.OrderEnity.Order;
import Marketing.OrderEnity.OrderCanInformation;
import Presentation.Protocol.OutputManager;
import Storage.InventoryConverter.CanToOrderConverter;
import Storage.InventoryConverter.OrderToTransportationCanConverter;
import Storage.Mediator.DepartmentMediator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * InventoryDepartment为对仓库管理的部门,可以通过对仓库数据进行管理与处理
 * 单例模式
 *
 * @author 王立友
 * @date 2021/10/16 20:27
 */
public class InventoryDepartment {

    /**
     * InventoryDepartment实例.
     */
    private static final InventoryDepartment instance = new InventoryDepartment();

    /**
     * 库存管理部门维护的待办订单队列.
     */
    private ArrayList<Order> unHandledOrders;

    /**
     * 中介者
     */
    private DepartmentMediator departmentMediator;

    /**
     * 私有构造函数
     *
     * @return : null
     * @author "王立友"
     * @date 2021-10-16 20:46
     */
    private InventoryDepartment() {
    }

    ;

    /**
     * 获得实例
     *
     * @return : Storage.InventoryDepartment
     * @author "王立友"
     * @date 2021-10-16 20:38
     */
    public static InventoryDepartment getInstance() {
        return instance;
    }

    /**
     * 获得当前库存信息，并将罐头实体转换为书面信息;
     *
     * @return : java.util.ArrayList<Marketing.OrderEntity.OrderCanInformation>
     * @author "王立友"
     * @date 2021-10-16 22:33
     */
    public ArrayList<OrderCanInformation> getInventoryInformation() {

        CanToOrderConverter canToOrderConverter = new CanToOrderConverter();
        CanWareHouse wareHouse = CanWareHouse.getInstance();
        return canToOrderConverter.getFromCanEntityFunction().apply(wareHouse.getStockCans());
    }


    /**
     * 此函数为扫描仓库库存进行比对
     *
     * @param order : 待办队列的订单
     * @return : boolean
     * @author "王立友"
     * @date 2021-10-16 20:55
     */
    public boolean viewInventory(Order order) {

        /**
         * orderCanInformation为截取订单中的罐头实体信息;
         */
        ArrayList<OrderCanInformation> orderCanInformations = order.getOrderCanInformations();

        /**
         * 获得仓库中的订单信息;
         */
        ArrayList<OrderCanInformation> inventoryCanInformations = getInventoryInformation();

        //进行对比;
        for (OrderCanInformation orderCanInformation : orderCanInformations) {

            String canType = orderCanInformation.getCanType();

            //查找是否存在这个canType类型的罐头;
            List<OrderCanInformation> findInventoryCan = inventoryCanInformations.stream().filter(
                    information -> canType.equals(information.getCanType())).collect(Collectors.toList());

            //判断库存是否存在这个罐头或者是否库存达到所需数量;
            if (findInventoryCan.isEmpty()) {
                return false;
            } else if (findInventoryCan.get(0).getCount() < orderCanInformation.getCount()) {
                return false;
            }
        }
        return true;
    }

    private boolean reduceCan(StockCan stockCan, int count) {
        int existingCount = stockCan.getCount();
        if (existingCount - count < 0) {
            OutputManager.getInstance().print(
                    "存货量不够!",
                    "存貨量不够",
                    "The inventory of products is not enough!"
            );
            return false;
        }
        stockCan.setCount(existingCount - count);
        return true;
    }

    /**
     * 通过订单中的orderCanInfo取货;
     *
     * @param orderCanInformations : 订单信息;
     * @return : java.util.ArrayList<Storage.StockCan>
     * @author "王立友"
     * @date 2021-10-17 18:20
     */
    public ArrayList<StockCan> takeCans(ArrayList<OrderCanInformation> orderCanInformations) {
        CanWareHouse canWareHouse = CanWareHouse.getInstance();
        ArrayList<StockCan> stockCans = new ArrayList<>();

        for (OrderCanInformation orderCanInformation : orderCanInformations) {
            String canType = orderCanInformation.getCanType();
            int count = orderCanInformation.getCount();

            //这个过程就是在仓库寻找该罐头，然后再取出的一个过程;
            for (StockCan stockCan : canWareHouse.getStockCans()) {
                if (stockCan.getCan().getClass().getTypeName().equals(canType)) {
                    if (reduceCan(stockCan, orderCanInformation.getCount())) {
                        stockCans.add(new StockCan(stockCan.getCan(), orderCanInformation.getCount()));
                    }
                    break;
                }
            }
        }
        return stockCans;
    }

    /**
     * 库存量够,准备货物与订单，打包;
     *
     * @param order :  订单;
     * @return : Storage.TransportationCan
     * @author "王立友"
     * @date 2021-10-17 18:15
     */

    public TransportationCan prepareCans(Order order) {

        //准备好货物与订单信息;
        OrderToTransportationCanConverter orderToTransportationCanConverter = new OrderToTransportationCanConverter();
        TransportationCan transportationCan = orderToTransportationCanConverter.getFromOrderFunction().apply(order);
        transportationCan.setStockCans(takeCans(order.getOrderCanInformations()));

        return transportationCan;
    }

    /**
     * 整体的发货接口呈现;
     *
     * @param order :  订单;
     * @author "王立友"
     * @date 2021-10-17 19:19
     */
    public void transportCans(Order order) {
        //库存部门不能发货，调用中介者实现发货;
        departmentMediator.transportCans(prepareCans(order));
    }

    /**
     * 整体的不能发货呈现;
     *
     * @param order :
     * @author "王立友"
     * @date 2021-10-17 19:59
     */
    public void productCans(Order order) {
        //库存部门同样不能生产货物,调用中介者实现货物生产;
        departmentMediator.productCans(order.getOrderCanInformations());
    }


    /**
     * 此函数为审查订单队列，即从当前队列头部到下依次审核队列过程
     * 过程为:取出一个order,判断是否能发货,如果能发货就打包出队,如果不能发货就通知生产部门生产货物;
     * 暂定整个订单队列都要处理;
     *
     * @author "王立友"
     * @date 2021-10-17 20:28
     */
    public void reviewOrder() {

        Iterator<Order> iterator = unHandledOrders.iterator();

        while (iterator.hasNext()) {
            Order currentOrder = iterator.next();
            if (viewInventory(currentOrder)) {
                /**
                 * 可以发货，此时需要先取订单,然后提取货物,然后发货;
                 */
                transportCans(currentOrder);
                /**
                 * 发货后需要移除这个订单;
                 */
                iterator.remove();
            } else {
                /**
                 * 不能发货,需要通知生产部门生产货物;
                 */
                prepareCans(currentOrder);
            }
        }
    }


    /**
     * 添加stockCans到库存中
     * @param stockCans :
     * @author "王立友"
     * @date 2021-10-17 21:38
     */
    public void addCanInventory(ArrayList<StockCan> stockCans){
        /**
         * 如果存在这个罐头就添加数量，如果不存在这个罐头就实例化再存入仓库;
         */
        CanWareHouse canWareHouse = CanWareHouse.getInstance();
        ArrayList<StockCan> wareHouseCans = canWareHouse.getStockCans();
        Iterator<StockCan> iterator = stockCans.iterator();
        while(iterator.hasNext()){
            StockCan stockCan = iterator.next();

        }
    }

}