package
        Storage.Mediator;

import Marketing.OrderEnity.Order;
import Marketing.OrderEnity.OrderCanInformation;
import Storage.InventoryDepartment;
import Storage.StockCan;
import Storage.TransportationCan;

import java.util.ArrayList;

/**
 * 该类为库存管理部门与运输部门沟通的中介者
 * 中介者模式
 * @author 王立友
 * @date 2021/10/17 16:10
 */
public class DepartmentMediator {

    /**
     * 库存管理部门
     */
    InventoryDepartment inventoryDepartment = InventoryDepartment.getInstance();
    /**
     * 运输管理部门
     */
    //TransportationDepartment transportationDepartment = Transportationment.getInstance();


    /**
     * 中介者的运输罐头的实现，通过调用运输管理部门的接口，实现相关操作
     * TODO：待完成
     * @param transportationCan :  运输产品信息
     * @author "王立友"
     * @date 2021-10-17 21:04
     */
    public void transportCans(TransportationCan transportationCan){

    }

    /**
     * 中介者的生产罐头的实现，通过调用生产管理部门的接口，实现相关操作
     * TODO: 待完成
     * @param orderCanInformations :  待生产的罐头列表信息;
     * @author "王立友"
     * @date 2021-10-17 21:05
     */
    public void productCans(ArrayList<OrderCanInformation> orderCanInformations){

    }

    /****************** InventoryDepartment Interface **********************/

    /**
     * 指定由生产部门调用实现对生产好的罐头的入库.
     * @param stockCans : 生产好的罐头列表
     * @author "王立友"
     * @date 2021-10-17 21:10
     */
    public void addCanInventory(ArrayList<StockCan> stockCans){
        /**
         * 利用中介者来告诉库存管理部门补充货物的数量;
         */
        inventoryDepartment.addCanInventory(stockCans);
        /**
         * 补充货源之后督促库存管理部门再一次进行订单扫描;
         */
        inventoryDepartment.reviewOrder();
    }

    /**
     * 提供给订单管理部门的接口，调用实现对订单的处理与添加到待办队列;
     * @param order :
     * @author "王立友"
     * @date 2021-10-17 23:29
     */
    public void handleOrder(Order order){
        /**
         * 利用中介者来告诉库存管理部门这个未处理的订单;
         */
        inventoryDepartment.addOrder(order);

        /**
         * 再添加新的订单后督促库存管理部门再一次进行订单扫描;
         */
        inventoryDepartment.reviewOrder();
    }



}