package
        Storage;

import Marketing.OrderEnity.Order;
import Marketing.OrderEnity.OrderCanInformation;
import Storage.InventoryConverter.CanToOrderConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
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
    private Queue<Order> unHandledOrders;

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


}