package Manufacturing.CanEntity;

import Manufacturing.ProductLine.Line.AutomatedLine.CandiedAppleLine;
import Presentation.Protocol.OutputManager;

import java.util.HashMap;

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
        this.registry = new HashMap<>();
        this.register(CandiedAppleLine.produceSample());
    }

    public void register(Can can) {
        System.out.println(can.getCanName());
        System.out.println(can);
        registry.put(can.getCanName(), can);
    }

    public double getCanPriceByName(String name) {
        return registry.get(name).getCanCost() * 1.2;
    }

    private HashMap<String, Can> registry;

    public static void main(String[] args) {
        OutputManager.getInstance().setLanguage(OutputManager.Lang.zh_CN);
        CanInfoController canInfoController = CanInfoController.getInstance();
        System.out.println(canInfoController.getCanPriceByName("糖渍苹果罐头"));
    }
}
