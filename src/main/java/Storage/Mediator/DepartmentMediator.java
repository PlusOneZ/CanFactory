package
        Storage.Mediator;

import Management.HumanResources.TransportDepartment;
import Manufacturing.CanEntity.Can;
import Marketing.OrderEnity.Order;
import Marketing.OrderEnity.OrderCanInformation;
import Marketing.Wrapping.WrappedCan;
import Marketing.Wrapping.WrappingDepartment;
import Presentation.Protocol.OutputManager;
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


    private  static DepartmentMediator  departmentMediator = new DepartmentMediator();

    private DepartmentMediator(){

    }

    public static DepartmentMediator getInstance(){
        return departmentMediator;
    }
    /**
     * 库存管理部门
     */
    InventoryDepartment inventoryDepartment = InventoryDepartment.getInstance();
    /**
     * 运输管理部门
     */
    TransportDepartment transportDepartment = TransportDepartment.getInstance();
    /**
     * 包装管理部门
     */
    WrappingDepartment wrappingDepartment = WrappingDepartment.getInstance();


    /**
     * 中介者的运输罐头的实现，通过调用运输管理部门的接口，实现相关操作
     * TODO：待完成
     * @param transportationCan :  运输产品信息
     * @author "王立友" "吴英豪"
     * @date 2021-10-26 0:02
     */
    public void transportCans(TransportationCan transportationCan){
        OutputManager.getInstance().print("将运输包裹分配运输部门,通知运输部门运输货物.",
                "將運輸包裹分配運輸部門,通知運輸部門運輸貨物.",
                "Assign the shipping package to the transportation department and notify the transportation department to transport the goods");
        transportDepartment.transportCans(transportationCan);
    }

    /**
     * 中介者的生产罐头的实现，通过调用生产管理部门的接口，实现相关操作
     * TODO: 待完成
     * @param orderCanInformations :  待生产的罐头列表信息;
     * @author "王立友"
     * @date 2021-10-17 21:05
     */
    public void productCans(ArrayList<OrderCanInformation> orderCanInformations){
        OutputManager.getInstance().print("将待生产的订单罐头信息分配给生产部门,通知生产部门生产罐头",
                "將待生產的訂單罐頭信息分配給生產部門,通知生產部門生產罐頭",
                "Distribute the order canned food information to be produced to the production department, and notify the production department to produce cans");
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
        OutputManager.getInstance().print("已经通知库存管理部门对生产好的罐头进行存储",
                "已經通知庫存管理部門對生產好的罐頭進行存儲",
                "The inventory management department has been notified to store the produced cans.");
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
        OutputManager.getInstance().print("已经通知库存管理部门处理订单",
                "已經通知庫存管理部門處理訂單",
                "The inventory management department has been notified to process the order.");
        inventoryDepartment.addOrder(order);

        /**
         * 再添加新的订单后督促库存管理部门再一次进行订单扫描;
         */
        inventoryDepartment.reviewOrder();
    }

    /********************* WrappingDepartment Interface ***********************/

    /**
     * 供生产部门调用的包装罐头的接口，输入一个罐头可以返回一个包装好的罐头;
     * @param can :
     * @return : Marketing.Wrapping.WrappedCan
     * @author "王立友"
     * @date 2021-10-24 17:05
     */
    public WrappedCan wrapCan(Can can){
        OutputManager.getInstance().print(
                "调用包装部门对"+can.getCanName()+"进行封面包装",
                "調用包裝部門對"+can.getCanName()+"進行封麵包裝",
                "Call the packaging department to cover "+can.getCanName()
        );
        WrappedCan wrappedCan = wrappingDepartment.wrapCan(can);
        OutputManager.getInstance().print(
                "包装完成",
                "包裝完成",
                "Packaging is complete"
        );
        return wrappedCan;
    }

}