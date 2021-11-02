package Management.HumanResources.Staff.Driver;

import Presentation.Protocol.IOManager;
import Mediator.DepartmentMediator;
import Storage.TransportationCan;

import java.util.Date;

/**
 * 委派模式
 * 水运司机
 *
 * @author 吴英豪
 */
public class Shipmaster extends Driver {
    @Override
    public void transport(TransportationCan transportationCan) {
        IOManager.getInstance().print(
                "司机正在通过水运运输罐头......",
                "司機正在通過水運運輸罐頭......",
                "The driver is transporting cans by ship......"
        );

        IOManager.getInstance().print(
                "正在从水路运往" + transportationCan.getCustomerAddress(),
                "正在從水路運往" + transportationCan.getCustomerAddress(),
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
