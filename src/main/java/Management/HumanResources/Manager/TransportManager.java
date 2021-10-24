package Management.HumanResources.Manager;

import Management.HumanResources.TeamLeader.Carrier;
import Marketing.Scheme.TransportScheme;
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
    public void transport(TransportationCan transportationCan){
        OutputManager.getInstance().print(
                "运输经理已接收订单信息",
                "運輸經理已接收訂單信息",
                "The PurchaseManager has received the order information"
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
     * ToDo: 需要的参数为订单列表，和wly对接
     * 运输部经历根据需求制定运输计划
     */
    public void designTransportScheme(TransportationCan transportationCan) {
        OutputManager.getInstance().print(
                "运输经理正在制定运输计划",
                "運輸經理正在制定運輸計劃",
                "The TransportManager is making the transport plan"
        );

        //这里需要写一些制定计划
    }

    /**
     * 发货时，经理委托承运商运货
     */
    public void delegateTransport(Carrier carrier) {
        carrier.dispatchTransport(transportScheme);
    }

    private TransportScheme transportScheme;
}
