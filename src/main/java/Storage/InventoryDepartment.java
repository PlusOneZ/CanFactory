package
        Storage;

import Marketing.OrderEnity.Order;
import Marketing.OrderEnity.OrderCanInformation;
import Presentation.Protocol.OutputManager;
import Storage.InventoryConverter.CanToOrderConverter;
import Storage.InventoryConverter.OrderToTransportationCanConverter;
import Mediator.DepartmentMediator;

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
    private ArrayList<Order> unHandledOrders = new ArrayList<>();


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
        ArrayList<OrderCanInformation> orderCanInformations = canToOrderConverter.getFromCanEntityFunction().apply(wareHouse.getStockCans());
        OutputManager.getInstance().print("实现转换器模式：完成存储罐头到订单罐头信息的转换.",
                "實現轉換器模式：完成存儲罐頭到訂單罐頭信息的轉換.",
                "Realize the converter mode: complete the conversion of stored canned food to order canned food information.");
        return orderCanInformations;
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
         * 获得仓库中的罐头订单信息;
         */
        ArrayList<OrderCanInformation> inventoryCanInformations = getInventoryInformation();

        //进行对比;
        for (OrderCanInformation orderCanInformation : orderCanInformations) {

            String canName = orderCanInformation.getCanName();

            //查找是否存在这个类型的罐头;
            List<OrderCanInformation> findInventoryCan = inventoryCanInformations.stream().filter(
                    information -> canName.equals(information.getCanName())).collect(Collectors.toList());

            //判断库存是否存在这个罐头或者是否库存达到所需数量;
            if (findInventoryCan.isEmpty()) {
                OutputManager.getInstance().print("罐头仓库中不含有" + canName,
                        "罐頭倉庫中不含有" + canName,
                        canName + "are not contained in the canned warehouse");
                return false;
            } else if (findInventoryCan.get(0).getCount() < orderCanInformation.getCount()) {
                OutputManager.getInstance().print("罐头仓库中" + canName + "数量不足", "罐頭倉庫中" + canName + "數量不足",
                        "The number of " + canName + " in the canning warehouse is insufficient");
                return false;
            }
        }
        OutputManager.getInstance().print("罐头仓库的库存可以满足该订单,订单编号为: " + order.getOrderId(),
                "罐頭倉庫的庫存可以滿足該訂單, 訂單編號為: " + order.getOrderId(),
                "The inventory of the can warehouse can satisfy the order, the order number is " + order.getOrderId());
        return true;
    }

    public boolean decreaseCan(StockCan stockCan, int count) {
        int existingCount = stockCan.getCount();
        String canName = stockCan.getWrappedCan().getCan().getCanName();
        if (existingCount - count < 0) {
            OutputManager.getInstance().print(
                    "无法取货" + canName + ",存货量不够!",
                    "無法取貨" + canName + ",存貨量不够",
                    "Unable to pick up " + canName + ", the inventory of products is not enough!"
            );
            return false;
        }
        stockCan.setCount(existingCount - count);
        int currentCount = stockCan.getCount();
        OutputManager.getInstance().print(
                "已经在仓库中取出:" + canName + ",目前的数量为: " + currentCount,
                "已經在倉庫中取出:" + canName + ",目前的數量為: " + currentCount,
                canName + " have been taken out in the warehouse, the current number is " + currentCount
        );
        return true;
    }

    /**
     * 通过订单中的orderCanInfo取货;
     *
     * @param orderCanInformations : 订单信息;
     * @return : java.util.ArrayList<Storage.StockCan> 取罐头的罐头列表;
     * @author "王立友"
     * @date 2021-10-17 18:20
     */
    public ArrayList<StockCan> takeCans(ArrayList<OrderCanInformation> orderCanInformations) {
        CanWareHouse canWareHouse = CanWareHouse.getInstance();
        ArrayList<StockCan> stockCans = new ArrayList<>();

        for (OrderCanInformation orderCanInformation : orderCanInformations) {
            String canName = orderCanInformation.getCanName();

            //这个过程就是在仓库寻找该罐头，然后再取出的一个过程;
            for (StockCan stockCan : canWareHouse.getStockCans()) {
                if (stockCan.getWrappedCan().getCan().getCanName().equals(canName)) {
                    if (decreaseCan(stockCan, orderCanInformation.getCount())) {
                        stockCans.add(new StockCan(stockCan.getWrappedCan(), orderCanInformation.getCount()));
                    }
                    break;
                }
            }
        }
        OutputManager.getInstance().print("已经取出订单中需要的存储罐头!",
                "已經取出訂單中需要的存儲罐頭!",
                "The storage cans needed in the order have been taken out!");
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
        OutputManager.getInstance().print("实现转换器模式：实现订单信息抽取至运输包裹, 订单编号为: " + order.getOrderId(),
                "實現轉換器模式：實現訂單信息抽取至運輸包裹, 訂單編號為: " + order.getOrderId(),
                "Realize the converter mode: Realize the extraction of order information to the shipping package, the order number is " + order.getOrderId());

        transportationCan.setStockCans(takeCans(order.getOrderCanInformations()));

        OutputManager.getInstance().print("已经准备好订单信息与货物至运输包裹, 订单编号为: " + order.getOrderId(),
                "已經準備好訂單信息與貨物至運輸包裹, 訂單編號為: " + order.getOrderId(),
                "The order information and the goods to the shipping package have been prepared, the order number is " + order.getOrderId());
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
        DepartmentMediator.getInstance().transportCans(prepareCans(order));
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
        DepartmentMediator.getInstance().productCans(order.getOrderCanInformations());
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

//        Iterator<Order> iterator = unHandledOrders.iterator();
        ArrayList<Order> toRemoveOrder = new ArrayList<>();

        for (int i = 0; i < unHandledOrders.size(); i++) {

            Order currentOrder = unHandledOrders.get(i);

            if (viewInventory(currentOrder)) {

                /**
                 * 修改订单状态变为生产中
                 */
                DepartmentMediator.getInstance().completeProductionOfOneOrder(currentOrder.getOrderId());

                /**
                 * 可以发货，此时需要先取订单,然后提取货物,然后发货;
                 */
                transportCans(currentOrder);

                /**
                 * 发货后需要移除这个订单;
                 */
                toRemoveOrder.add(currentOrder);
            } else {

                /**
                 * 不能发货,需要通知生产部门生产货物;
                 */
                productCans(currentOrder);
            }
        }
        unHandledOrders.removeAll(toRemoveOrder);

    }

    /**
     * 增加库存罐头数量
     *
     * @param stockCan : 存储的罐头
     * @param count    :  增加数量
     * @author "王立友"
     * @date 2021-10-17 23:19
     */
    public void increaseCan(StockCan stockCan, int count) {
        String canName = stockCan.getWrappedCan().getCan().getCanName();
        int curCount = stockCan.getCount();
        stockCan.setCount(count + curCount);
        int countNow = stockCan.getCount();
        OutputManager.getInstance().print(canName + "的库存数量已经增加,目前的数量为:" + countNow,
                canName + "的庫存數量已經增加,目前的數量為:" + countNow,
                "The inventory of " + canName + " has increased, the current number is " + countNow);
    }

    /**
     * 添加stockCans到库存中
     *
     * @param stockCans :
     * @author "王立友"
     * @date 2021-10-17 21:38
     */
    public void addCanInventory(ArrayList<StockCan> stockCans) {
        /**
         * 如果存在这个罐头就添加数量，如果不存在这个罐头就实例化再存入仓库;
         */
        CanWareHouse canWareHouse = CanWareHouse.getInstance();
        ArrayList<StockCan> wareHouseCans = canWareHouse.getStockCans();
        Iterator<StockCan> iterator = stockCans.iterator();

        while (iterator.hasNext()) {
            StockCan stockCan = iterator.next();
            String canName = stockCan.getWrappedCan().getCan().getCanName();
            boolean flag = false;
            for (StockCan can : wareHouseCans) {
                if (canName.equals(can.getWrappedCan().getCan().getCanName())) {
                    increaseCan(can, stockCan.getCount());
                    flag = true;
                }
            }
            if (!flag) {
                OutputManager.getInstance().print("仓库中不存在" + canName + ",已新增该类罐头, 目前的数量为: " + stockCan.getCount(),
                        "倉庫中不存在" + canName + ",已新增該類罐頭, 目前的數量為: " + stockCan.getCount(),
                        canName + " do not exist in the warehouse, and this type of canned food has been newly added, the current number is " + stockCan.getCount());
                wareHouseCans.add(stockCan);
            }
        }
    }

    /**
     * 添加一个order到库存管理的代办订单队列;
     *
     * @param order :
     * @author "王立友"
     * @date 2021-10-17 23:28
     */

    public void addOrder(Order order) {
        OutputManager.getInstance().print("将订单编号为:" + order.getOrderId() + "加入库存待办订单队列.",
                "將訂單編號為:" + order.getOrderId() + "加入庫存待辦訂單隊列.",
                "Add the order number: " + order.getOrderId() + " to the inventory pending order queue.");
        unHandledOrders.add(order);
    }


}