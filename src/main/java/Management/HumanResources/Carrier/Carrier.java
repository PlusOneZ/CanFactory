package Management.HumanResources.Carrier;

import Management.HumanResources.Staff.Staff.Driver.Driver;
import Management.HumanResources.Staff.Staff.Driver.EngineMan;
import Management.HumanResources.Staff.Staff.Driver.Shipmaster;
import Marketing.Transportation.TransportationPlan;

import java.util.HashMap;
import java.util.Map;


/**
 * 委派模式
 * 承运人
 *
 * @author 吴英豪
 */
public class Carrier {
    /**
     * 承运人根据运输方案安排运输人手
     *
     * @param plan 运输方案
     */
    public void dispatch(TransportationPlan plan) {
        drivers.get("EngineMa").transport(plan.getLandQuantity());
        drivers.get("Shipmaster").transport(plan.getShippingQuantity());
    }

    /**
     * 承运人分配运输工作
     */
    public Carrier() {
        drivers = new HashMap<String, Driver>();
        drivers.put("EngineMa", new EngineMan());
        drivers.put("Shipmaster", new Shipmaster());
    }

    private final Map<String, Driver> drivers;
}
