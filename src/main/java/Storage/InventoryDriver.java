package
        Storage;


import Manufacturing.CanEntity.Can;
import Manufacturing.CanEntity.CanInfoController;
import Manufacturing.ProductLine.Line.PeachLine;
import Marketing.OrderEnity.Order;
import Marketing.OrderEnity.OrderCanInformation;
import Marketing.Promotion.Coupon;
import Marketing.Promotion.Sale.TwentyPercentOff;
import Marketing.Wrapping.WrappedCan;
import Marketing.Wrapping.WrappingDepartment;
import Mediator.DepartmentMediator;
import Presentation.Protocol.IOManager;

import java.util.ArrayList;
import java.util.Date;

/**
 * 此类为库存管理相关的测试驱动类;
 * 意图为验证库存管理的有效性;
 *
 * @author 王立友
 * @date 2021/10/17 23:32
 */
public class InventoryDriver {
    public static void main(String[] args){

        IOManager.getInstance().print("*************************************", "*************************************", "*************************************");
        InventoryDepartment inventoryDepartment = InventoryDepartment.getInstance();

        //首先准备stub.
        IOManager.getInstance().print("# 实现中介者模式: 通知包装部门对罐头进行包装","# 實現中介者模式: 通知包裝部門對罐頭進行包裝","# Realize Mediator pattern: notify the packaging department to package the cans");
        WrappedCan wrappedCan = DepartmentMediator.getInstance().wrapCan(getStubCan());
        IOManager.getInstance().print("# 调用包装部门完成","# 調用包裝部門完成","# Call the packaging department to complete");

    }

    public static Can getStubCan(){
        return PeachLine.produceSample();
    }
}