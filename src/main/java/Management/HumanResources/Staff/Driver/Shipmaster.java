package Management.HumanResources.Staff.Driver;

import Presentation.Protocol.OutputManager;

/**
 * 委派模式
 * 水运司机
 *
 * @author 吴英豪
 */
public class Shipmaster extends Driver {
    @Override
    public void transport(Double quantity) {
        if (quantity <= 0) {
            OutputManager.getInstance().print(
                    "不需要水运。",
                    "不需要水運。",
                    "No need for water transportation.");
        } else {
            OutputManager.getInstance().print(
                    "水运量:" + quantity,
                    "水運量:" + quantity,
                    "Shipping quantity:" + quantity);
        }
    }
}
