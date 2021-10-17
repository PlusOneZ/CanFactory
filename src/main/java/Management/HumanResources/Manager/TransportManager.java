package Management.HumanResources.Manager;

import Management.HumanResources.TeamLeader.Carrier.Carrier;
import Marketing.Transportation.TransportationPlan;

/**
 * 委派模式
 * 运输部门经理 -- 负责制定罐头的运输方案
 *
 * @author 吴英豪
 * @since 2021-10-17 22:18
 */
public class TransportManager extends Manager {
    /**
     * 默认构造函数
     */
    public TransportManager() {
    }

    /**
     * 经理制定方案
     *
     * @param plan 运输方案
     */
    public void setTransportPlan(TransportationPlan plan) {
        transportationPlan = plan;
    }

    /**
     * ToDo: 需要的参数为订单列表，和wly对接
     * 运输部经历根据需求制定运输计划
     */
    public void designTransportPlan(){

    }

    /**
     * 发货时，经理委托承运商运货
     *
     * @param carrier 承运商
     */
    public void delegateTransport(Carrier carrier) {
        carrier.dispatchTransport(transportationPlan);
    }

    private TransportationPlan transportationPlan;
}
