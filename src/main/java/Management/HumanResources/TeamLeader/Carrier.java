package Management.HumanResources.TeamLeader;

import Management.HumanResources.Staff.Driver.Driver;
import Management.HumanResources.Staff.Driver.EngineMan;
import Management.HumanResources.Staff.Driver.Shipmaster;
import Management.HumanResources.TeamLeader.TeamLeader;
import Marketing.Scheme.TransportScheme;

import java.util.HashMap;
import java.util.Map;


/**
 * ToDo: 根据购买原材料和运输罐头具体确定实体
 * 委派模式
 * 承运人
 *
 * @author 吴英豪
 * @since 2021-10-17 22:23
 */
public class Carrier extends TeamLeader {
    /**
     * 承运人根据运输方案安排运输人手（运送货物）
     *
     * @param scheme 运输方案
     */
    public void dispatchTransport(TransportScheme scheme) {
        drivers.get("EngineMa").transport(scheme.getLandQuantity());
        drivers.get("Shipmaster").transport(scheme.getShippingQuantity());
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
