package Management.HumanResources.Staff.Driver;

import Presentation.Protocol.IOManager;
import Mediator.DepartmentMediator;
import Storage.TransportationCan;

import java.util.Date;

/**
 * 委派模式
 * 陆运司机
 *
 * @author 吴英豪
 */

public class EngineMan extends Driver {
    @Override
    public void transport(TransportationCan transportationCan) {
        IOManager.getInstance().print(
                "司机正在通过陆运运输罐头......",
                "司機正在通過陸運運輸罐頭......",
                "The driver is transporting cans by road......"
        );

        IOManager.getInstance().print(
                "正在从陆运运往" + transportationCan.getCustomerAddress(),
                "正在從陸運運往" + transportationCan.getCustomerAddress(),
                "Purchasing to " + transportationCan.getCustomerAddress()
        );

        IOManager.getInstance().print(
                "货物交付时间为:" + new Date(),
                "貨物交付時間為:" + new Date(),
                "The DeliveryTime is " + new Date()
        );

        //完成訂單的交付
       DepartmentMediator.getInstance().deliverOneOrder(transportationCan.getOrderId());

        IOManager.getInstance().print(
                "运输成功！",
                "運輸成功！",
                "Transporting Success!"
        );

    }
}
