package Management.HumanResources.Staff.Driver;

import Presentation.Protocol.OutputManager;

/**
 * 委派模式
 * 陆运司机
 *
 * @author 吴英豪
 */

public class EngineMan implements Driver {
    @Override
    public void transport(Double quantity) {
        if (quantity <= 0) {
            OutputManager.getInstance().print(
                    "不需要陆运。",
                    "不需要陸運。",
                    "No need for land transportation.");
        } else {
            OutputManager.getInstance().print(
                    "陆运量:" + quantity,
                    "陸運量:" + quantity,
                    "Land quantity:" + quantity);
        }
    }
}
