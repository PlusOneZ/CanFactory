package Management.HumanResources.Manager;

import Management.HumanResources.Carrier.Carrier;
import Marketing.Transportation.TransportationPlan;

/**
 * 委派模式
 * 运输部门经理 -- 负责制定罐头的运输方案
 *
 * @author 吴英豪
 */
public class TransportManager extends Manager {
    /**
     * 运输部经历制定运输方案
     *
     * @param plan 运输方案
     */
    public TransportManager(TransportationPlan plan) {
        transportationPlan = plan;
    }

    /**
     * 经理制定方案
     *
     * @param plan 运输方案
     */
    public void DesignTransportPlan(TransportationPlan plan) {
        transportationPlan = plan;
    }

    /**
     * 经理委托承运商运货
     *
     * @param carrier 承运商
     */
    public void DelegateTransport(Carrier carrier) {
        carrier.dispatch(transportationPlan);
    }

    private TransportationPlan transportationPlan;
}
