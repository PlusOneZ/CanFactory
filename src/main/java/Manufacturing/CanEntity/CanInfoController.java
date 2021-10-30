package Manufacturing.CanEntity;

import Manufacturing.ProductLine.Line.AutomatedLine.CandiedAppleLine;
import Manufacturing.ProductLine.Line.HerringLine;
import Manufacturing.ProductLine.Line.PeachLine;
import Manufacturing.ProductLine.Line.SalmonLine;
import Presentation.Protocol.OutputManager;

import java.util.ArrayList;
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
        this.canList=new ArrayList<>();
        this.registry = new HashMap<>();
        this.canKind = new HashMap<>();
        /*
        * 注册糖渍苹果罐头;
        */
        Can candiedAppleCan = CandiedAppleLine.produceSample();
        this.register(candiedAppleCan);
        this.registerType(candiedAppleCan, "fruit");

        /*
        * 注册黄桃罐头
        */
        Can peachCan = PeachLine.produceSample();
        this.register(peachCan);
        this.registerType(peachCan, "fruit");

        /*
        * 注册鲱鱼罐头
        */
        Can herringCan = HerringLine.produceSample();
        this.register(herringCan);
        this.registerType(herringCan, "fresh");

        /*
        * 注册三文鱼罐头
        */
        Can salmonCan = SalmonLine.produceSample();
        this.register(salmonCan);
        this.registerType(salmonCan, "fresh");

    }

    public void register(Can can) {
        registry.put(can.getCanName(), can);
        canList.add(can.getCanName());

        enNameMap.put(can.zhCnDescription(), can.enDescription());
        enNameMap.put(can.zhTwDescription(), can.enDescription());
        enNameMap.put(can.enDescription(), can.enDescription());
    }

    public void registerType(Can can, String type) {
        canKind.put(can.getCanName(), type);
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

    public String getCanType(String name) {
        try {
            return canKind.get(name);
        } catch (NullPointerException e) {
            OutputManager.getInstance().errorMassage(
                    "不存在" + name + "这种罐头",
                    "不存在" + name + "這種罐頭",
                    "No can named "  + name
            );
            return "";
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

    public String getEnNameOfCan(String arbitraryName) {
        try {
            return enNameMap.get(arbitraryName);
        } catch (NullPointerException e) {
            OutputManager.getInstance().errorMassage(
                    "不存在" + arbitraryName + "这种罐头",
                    "不存在" + arbitraryName + "這種罐頭",
                    "No can named "  + arbitraryName
            );
            return null;
        }
    }

    public List<String> getCanList() {
        return canList;
    }

    private HashMap<String, Can> registry;

    private HashMap<String, String> canKind;

    private List<String> canList;

    private HashMap<String, String> enNameMap;

    public static void main(String[] args) {
        OutputManager.getInstance().setLanguage(OutputManager.Lang.zh_CN);
        CanInfoController canInfoController = CanInfoController.getInstance();
        System.out.println(canInfoController.getCanPriceByName("糖渍苹果罐头"));
    }
}
