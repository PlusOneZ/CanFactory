package Manufacturing.ProductLine.Pretreatment;

import Manufacturing.Ingredient.BaseIngredient;
import Presentation.Protocol.OutputManager;

import java.util.List;

/**
 * TODO:预处理创造类,提供预处理方法.<br>
 * <p>实现了外观模式</p>
 * <i>提供预处理模块中的筛选、清洗、杀菌等子系统中类的访问接口</i>
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:24
 */
public class PretreatmentApp {
    private final Pretreatment disinfectProcessor;
    private final Pretreatment peelProcessor;
    private final Pretreatment filterTreatProcessor;
    private final Pretreatment cleanProcessor;

    public PretreatmentApp() {
        disinfectProcessor = new Disinfect();
        peelProcessor = new Peel();
        filterTreatProcessor = new FilterTreat();
        cleanProcessor = new Clean();
    }

    /**
     * TODO:消毒方法
     *
     * @param baseIngredientList :  原材料列表
     * @author 孟繁霖
     * @date 2021-10-12 8:25
     */
    public void disinfect(List<BaseIngredient> baseIngredientList) {
        OutputManager.getInstance().print(
                "--------正在杀菌---------",
                "--------正在殺菌---------",
                "-------Sterilizing-------");
        disinfectProcessor.treat(baseIngredientList);
        OutputManager.getInstance().print(
                "--------杀菌完成---------",
                "--------殺菌完成---------",
                "---Sterilization completed---");
    }

    /**
     * TODO:剥皮方法
     *
     * @param baseIngredientList :  原材料列表
     * @author 孟繁霖
     * @date 2021-10-12 8:25
     */
    public void peel(List<BaseIngredient> baseIngredientList) {
        OutputManager.getInstance().print(
                "--------开始剥皮---------",
                "--------開始剝皮---------",
                "------Start peeling------");
        peelProcessor.treat(baseIngredientList);
        OutputManager.getInstance().print(
                "--------完成剥皮---------",
                "--------完成剝皮---------",
                "----Complete the peeling-----");
    }

    /**
     * TODO: 过滤筛选方法.
     *
     * @param baseIngredientList :  原材料列表
     * @return : java.util.List<Manufacturing.ProductLine.Fruit.RawMaterial>
     * @author 孟繁霖
     * @date 2021-10-12 8:26
     */
    public List<BaseIngredient> filterTreat(List<BaseIngredient> baseIngredientList) {
        OutputManager.getInstance().print(
                "--开始筛选符合要求的原料--",
                "--開始篩選符合要求的原料--",
                "--Start to screen raw materials that meet the requirements--");
        baseIngredientList = filterTreatProcessor.treat(baseIngredientList);
        OutputManager.getInstance().print(
                "---筛选完成，结果如下：---",
                "---篩選完成，結果如下：---",
                "---The screening is complete, and the results are as follows: ---");
        for (BaseIngredient baseIngredient : baseIngredientList) {
            OutputManager.getInstance().print(
                    baseIngredient.zhCnDescription(),
                    baseIngredient.zhTwDescription(),
                    baseIngredient.enDescription()
            );
        }
        return baseIngredientList;

    }

    /**
     * TODO:清理方法
     *
     * @param baseIngredientList :  原材料列表
     * @author 孟繁霖
     * @date 2021-10-12 8:27
     */
    public void clean(List<BaseIngredient> baseIngredientList) {
        OutputManager.getInstance().print(
                "--------开始清理---------",
                "-----------開始清理---------",
                "---------Start to clean up-------");
        cleanProcessor.treat(baseIngredientList);
        OutputManager.getInstance().print(
                "--------清理完成---------",
                "--------清理完成---------",
                "--------Cleaning up---------");
    }
}
