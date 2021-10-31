package Management.HumanResources.Manager;

import Management.HumanResources.TeamLeader.Carrier;
import Marketing.Scheme.TransportScheme;
import Mediator.DepartmentMediator;
import Presentation.Protocol.OutputManager;
import Storage.TransportationCan;


/**
 * 委派模式
 * 运输部门经理 -- 负责制定罐头的运输方案
 *
 * @author 吴英豪
 * @since 2021-10-24 15:15
 */
public class TransportManager extends Manager {
    /**
     * 默认构造函数
     */
    public TransportManager() {
        transportScheme = new TransportScheme();
    }

    /**
     * 委派模式
     * 运输经理负责运输
     */
    public void transport(TransportationCan transportationCan) {
        OutputManager.getInstance().print(
                "# 使用委派模式，运输部经理安排运输罐头",
                "# 使用委派模式，運輸部經理安排運輸罐頭",
                "# using delegate pattern, transport manager begins to dispatch transporting"
        );
        OutputManager.getInstance().print(
                "运输经理已接收运输罐头信息",
                "運輸經理已接收運輸罐頭信息",
                "The PurchaseManager has received the transportationCan information"
        );
        designTransportScheme(transportationCan);
        delegateTransport(new Carrier());
    }

    /**
     * 经理制定方案
     *
     * @param scheme 运输方案
     */
    public void setTransportScheme(TransportScheme scheme) {
        transportScheme = scheme;
    }

    /**
     * 运输部经历根据需求制定运输计划
     */
    public void designTransportScheme(TransportationCan transportationCan) {
        OutputManager.getInstance().print(
                "运输经理正在制定运输计划",
                "運輸經理正在制定運輸計劃",
                "The TransportManager is making the transport plan"
        );

        transportScheme.setTransportationCan(transportationCan);

        int max = 100, min = 1;
        int random = (int) (Math.random() * (max - min) + min);
        if (random % 2 == 1) {
            transportScheme.setTransportType(TransportScheme.TransportType.Land);
        } else {
            transportScheme.setTransportType(TransportScheme.TransportType.Ship);
        }

        OutputManager.getInstance().print(
                "运输经理制定运输计划完毕",
                "運輸經理制定運輸計劃完畢",
                "The TransportManager has made the transport plan"
        );

    }

    /**
     * 发货时，经理委托承运商运货
     */
    public void delegateTransport(Carrier carrier) {
        OutputManager.getInstance().print(
                "运输经理委派承运商进行运输",
                "運輸經理委派承運商進行運輸",
                "The transport manager delegated the transport to the carrier"
        );

        carrier.dispatchTransport(transportScheme);
    }

    private TransportScheme transportScheme;
}
