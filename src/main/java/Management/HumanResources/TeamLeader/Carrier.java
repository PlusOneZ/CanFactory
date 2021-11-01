package Management.HumanResources.TeamLeader;

import Management.HumanResources.Staff.Driver.Driver;
import Management.HumanResources.Staff.Driver.EngineMan;
import Management.HumanResources.Staff.Driver.Shipmaster;
import Marketing.Scheme.TransportScheme;
import Mediator.DepartmentMediator;
import Presentation.Protocol.OutputManager;



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
        OutputManager.getInstance().print(
                "承运商收到运输计划，并开始安排司机运输",
                "承運商收到運輸計劃，並開始安排司機運輸",
                "The carrier receives the transport plan and begins to arrange for a driver to transport it"
        );
        /**
         * 修改订单状态变为运输状态;
         */
        DepartmentMediator.getInstance().startToTransportOneOrder(scheme.getTransportationCan().getOrderId());
        Driver driver;
        if (scheme.getTransportType() == TransportScheme.TransportType.Land) {
            driver = new EngineMan();
        } else {
            driver = new Shipmaster();
        }
        driver.transport(scheme.getTransportationCan());
    }


    /**
     * 承运人分配运输工作
     */
    public Carrier() {
    }

}
