package Manufacturing.ProductLine.Line.AutomatedLine;

import Manufacturing.Ingredient.Ingredient;
import Manufacturing.Machine.GeneralMachine.CleanMachine;
import Manufacturing.Machine.GeneralMachine.DisinfectMachine;
import Manufacturing.Machine.GeneralMachine.FilterMachine;
import Manufacturing.Machine.GeneralMachine.PeelMachine;
import Manufacturing.ProductLine.ProductLine;
import Presentation.Protocol.IOManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 自动化生产线
 *
 * @author 卓正一
 * @since 2021/10/28 10:05 PM
 */
public abstract class AutomatedLine implements ProductLine {
    @Override
    public List<Ingredient> preTreat(List<Ingredient> baseIngredientList) {
        IOManager.getInstance().print(
                "******正在对苹果进行预处理********",
                "******正在對蘋果進行預處理********",
                "******Pretreating apple********");
        List<Ingredient> filtered = new ArrayList<>();
        FilterMachine filterMachine = new FilterMachine(150);
        IOManager.getInstance().print(
                "#使用过滤器模式筛选符合要求的原料",
                "#使用過濾器模式篩選符合要求的原料",
                "#Use Filter Pattern to screen raw materials that meet the requirements");
        for (Ingredient i : baseIngredientList) {
            if (filterMachine.treat(i) != null) {
                filtered.add(i);
            }
        }
        IOManager.getInstance().print(
                "---筛选完成，结果如下：---",
                "---篩選完成，結果如下：---",
                "---The screening is complete, and the results are as follows: ---");
        for (Ingredient ingredient : filtered) {
            IOManager.getInstance().printLanguageIrrelevantContent(ingredient.showContentsWithWeight());
        }

        CleanMachine cleanMachine = new CleanMachine();
        DisinfectMachine disinfectMachine = new DisinfectMachine();
        PeelMachine peelMachine = new PeelMachine();

        IOManager.getInstance().print(
                "-----对原料清洗、消毒、削皮处理------",
                "-----對原料清洗、消毒、削皮處理------",
                "---Start to clean, disinfect and peel the raw materials---");

        for (int i = 0; i < filtered.size(); i++) {
            filtered.set(i, cleanMachine.treat(
                    disinfectMachine.treat(
                            peelMachine.treat(
                                    filtered.get(i)
                            )
                    )
            ));
        }

        IOManager.getInstance().print(
                "*********苹果预处理完成*********",
                "*********蘋果預處理完成*********",
                "*********Apple pretreatment completed*********");
        return filtered;
    }
}
