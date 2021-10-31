package Manufacturing.ProductLine.Pretreatment;

import Manufacturing.Ingredient.Ingredient;
import Manufacturing.Machine.GeneralMachine.CleanMachine;
import Manufacturing.Machine.GeneralMachine.DisinfectMachine;
import Manufacturing.Machine.GeneralMachine.PeelMachine;
import Manufacturing.Machine.IngredientMachine;
import Presentation.Protocol.OutputManager;

import java.util.ArrayList;
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

    private final IngredientMachine disinfectMachine;
    private final IngredientMachine peelMachine;
    private final IngredientMachine filterTreatMachine;
    private final IngredientMachine cleanMachine;

    public PretreatmentApp(IngredientMachine filterMachine) {


        disinfectMachine = new DisinfectMachine();
        peelMachine = new PeelMachine();
        this.filterTreatMachine =filterMachine;
        cleanMachine = new CleanMachine();
    }

    /**
     * TODO:消毒方法
     *
     * @param baseIngredientList :  原材料列表
     * @author 孟繁霖
     * @date 2021-10-12 8:25
     */
    public void disinfect(List<Ingredient> baseIngredientList) {
        OutputManager.getInstance().print(
                "--------开始消毒---------",
                "--------開始消毒---------",
                "-------Disinfect-------");
//        disinfectProcessor.treat(baseIngredientList);
        OutputManager.getInstance().print(
                "正在消毒",
                "正在消毒",
                "Disinfecting..."
        );
        for (int i = 0; i < baseIngredientList.size(); i++) {
            baseIngredientList.set(i, disinfectMachine.treat(baseIngredientList.get(i)));
        }
        OutputManager.getInstance().print(
                "--------消毒完成---------",
                "--------消毒完成---------",
                "---Disinfection completed---");
    }

    /**
     * TODO:剥皮方法
     *
     * @param ingredientList :  原材料列表
     * @author 孟繁霖
     * @date 2021-10-12 8:25
     */
    public void peel(List<Ingredient> ingredientList) {
        OutputManager.getInstance().print(
                "--------开始削皮---------",
                "--------開始削皮---------",
                "------Start peeling------");
//        peelProcessor.treat(baseIngredientList);
        OutputManager.getInstance().print(
                "正在削皮",
                "正在削皮",
                "Peeling..."
        );
        for (int i = 0; i < ingredientList.size(); i++) {
            ingredientList.set(i, peelMachine.treat(ingredientList.get(i)));
        }
        OutputManager.getInstance().print(
                "--------完成削皮---------",
                "--------完成削皮---------",
                "----Complete the peeling-----");
    }

    /**
     * TODO: 过滤筛选方法.
     *
     * @param ingredientList :  原材料列表
     * @return : java.util.List<Manufacturing.ProductLine.Fruit.RawMaterial>
     * @author 孟繁霖
     * @date 2021-10-12 8:26
     */
    public List<Ingredient> filterTreat(List<Ingredient> ingredientList) {
        OutputManager.getInstance().print(
                "#使用过滤器模式",
                "#使用過濾器模式",
                "#Use Filter Pattern");
        OutputManager.getInstance().print(
                "--开始筛选符合要求的原料--",
                "--開始篩選符合要求的原料--",
                "--Start to screen raw materials that meet the requirements--");
        List<Ingredient> temp = new ArrayList<Ingredient>();
        for (Ingredient ingredient: ingredientList) {
            if (filterTreatMachine.treat(ingredient) != null)
                temp.add(ingredient);
        }
        OutputManager.getInstance().print(
                "---筛选完成，结果如下：---",
                "---篩選完成，結果如下：---",
                "---The screening is complete, and the results are as follows: ---");
        for (Ingredient ingredient : temp) {
            System.out.println(ingredient.showContentsWithWeight());
        }
        return temp;

    }

    /**
     * TODO:清理方法
     *
     * @param ingredientList :  原材料列表
     * @author 孟繁霖
     * @date 2021-10-12 8:27
     */
    public void clean(List<Ingredient> ingredientList) {
        OutputManager.getInstance().print(
                "--------开始清理---------",
                "-----------開始清理---------",
                "---------Start to clean up-------");
        OutputManager.getInstance().print(
                "正在清洗",
                "正在清洗",
                "Cleaning..."
        );
        for (int i = 0; i < ingredientList.size(); i++) {
            ingredientList.set(i, cleanMachine.treat(ingredientList.get(i)));
        }
        OutputManager.getInstance().print(
                "--------清理完成---------",
                "--------清理完成---------",
                "--------Cleaning up---------");
    }
}
