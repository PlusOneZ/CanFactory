package Manufacturing.CanEntity;

import Manufacturing.ProductLine.Line.AutomatedLine.CandiedAppleLine;
import Presentation.Protocol.OutputManager;

import java.util.HashMap;
import java.util.List;

/**
 * 管理罐头信息，主要是为了提供罐头价格等
 *
 * @author 卓正一
 * @since  2021/10/29 10:55 PM
 */
public class CanInfoController {

    private static final CanInfoController infoController;

    public static CanInfoController getInstance() {
        return infoController;
    }

    static {
        infoController = new CanInfoController();
    }

    private CanInfoController() {
        Can candiedAppleCan = CandiedAppleLine.produceSample();

        this.registry = new HashMap<>();
        this.register(candiedAppleCan);
    }

    public void register(Can can) {
        System.out.println(can.getCanName());
        System.out.println(can);
        registry.put(can.getCanName(), can);
        canList.add(can.getCanName());
    }

    public double getCanPriceByName(String name) {
        try {
            return registry.get(name).getCanCost() * 1.2;
        } catch (NullPointerException e) {
            OutputManager.getInstance().errorMassage(
                    "不存在" + name + "这种罐头",
                    "不存在" + name + "這種罐頭",
                    "No can named "  + name
                    );
            return 0.;
        }
    }

    public Class<? extends Can> getClassByName(String name) {
        try {
            return registry.get(name).getClass();
        } catch (NullPointerException e) {
            OutputManager.getInstance().errorMassage(
                    "不存在" + name + "这种罐头",
                    "不存在" + name + "這種罐頭",
                    "No can named "  + name
            );
            return null;
        }
    }

    public List<String> getCanList() {
        return canList;
    }

    private HashMap<String, Can> registry;

    private List<String> canList;

    public static void main(String[] args) {
        OutputManager.getInstance().setLanguage(OutputManager.Lang.zh_CN);
        CanInfoController canInfoController = CanInfoController.getInstance();
        System.out.println(canInfoController.getCanPriceByName("糖渍苹果罐头"));
    }
}
