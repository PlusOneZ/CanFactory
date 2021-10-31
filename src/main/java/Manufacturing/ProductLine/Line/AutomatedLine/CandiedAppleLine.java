package Manufacturing.ProductLine.Line.AutomatedLine;

import Manufacturing.CanEntity.Can;
import Manufacturing.Ingredient.ConcreteIngredient.Apple;
import Manufacturing.Ingredient.ConcreteIngredient.Seasoning.Sugar;
import Manufacturing.Ingredient.Ingredient;
import Manufacturing.Machine.CanTreatmentMachine.GlassCanProducingMachine;
import Manufacturing.Machine.CombinationPart.CandiedAppleMachine;
import Manufacturing.ProductLine.AbstractCanFactory.GlassCanFactory;
import Presentation.Protocol.OutputManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 糖漬蘋果的生產線
 *
 * @author 卓正一
 * @since 2021/10/28 9:19 AM
 */
public class CandiedAppleLine extends AutomatedLine {

    @Override
    public String getConcreteName() {
        return OutputManager.getInstance().selectStringForCurrentLanguage(
                "糖渍苹果生产线",
                "糖漬蘋果生產線",
                "Candied Apple Product Line"
        );
    }

    private List<Ingredient> apples;
    private List<Ingredient> sugarList;

    private final CandiedAppleMachine candiedAppleMachine = new CandiedAppleMachine();
    private final GlassCanProducingMachine ironCanProducingMachine = GlassCanProducingMachine.getInstance();

    public CandiedAppleLine(List<Ingredient> apples, List<Ingredient> sugarList) {
        if (apples.isEmpty() || sugarList.isEmpty()) {
            OutputManager.getInstance().errorMassage(
                    "原料为空，不能生产！",
                    "原料為空，不能生產！",
                    "Empty ingredient list, cannot produce anything!"
            );
            return;
        }
        if (apples.get(0) instanceof Apple && sugarList.get(0) instanceof Sugar) {
            this.apples = apples;
            this.sugarList = sugarList;
        } else {
            OutputManager.getInstance().errorMassage(
                    "投料错误，不能生产！",
                    "投料錯誤，不能生產！",
                    "Wrong ingredients, cannot produce anything!"
            );
        }
    }

    @Override
    public List<Can> produce(int count,String produceManner) {
        List<Can> product = new ArrayList<>();
        //预处理（打印语句）
        apples = preTreat(apples);
        OutputManager.getInstance().print(
                "*******正在对糖渍苹果进行加工*******",
                "*******正在對糖渍苹果進行加工*******",
                "*******Candied apple is being processed*******");
        for (int i = 0; i < apples.size(); i++) {
            try {
                Ingredient candiedApple = candiedAppleMachine.combine(apples.get(i), sugarList.get(i));
                Can can = GlassCanFactory.getInstance().createSmallCan("CandiedApple");
                ironCanProducingMachine.preTreat(can);
                ironCanProducingMachine.fill(can, candiedApple);
                ironCanProducingMachine.can(can);
                product.add(can);
            } catch (IndexOutOfBoundsException e) {
                OutputManager.getInstance().errorMassage(
                        "原材料不够了！",
                        "原材料不夠了！",
                        "No enough ingredients!"
                );
                break;
            }
        }
        OutputManager.getInstance().print(
                "共生产"+product.size()+"个糖渍苹果罐头",
                 "共生產"+product.size() +"個糖漬蘋果罐頭",
                "A total of "+product.size()+"canned candied Apple was produced");
        return product;
    }


    public static Can produceSample() {
        CandiedAppleMachine candiedAppleMachine = new CandiedAppleMachine();
        GlassCanProducingMachine glassCanProducingMachine = GlassCanProducingMachine.getInstance();
        Can can = GlassCanFactory.getInstance().createSmallCan("CandiedApple");

        glassCanProducingMachine.preTreat(can);
        Ingredient candiedApple = candiedAppleMachine.combine(new Apple(), new Sugar());
        glassCanProducingMachine.fill(can, candiedApple);
        glassCanProducingMachine.can(can);
        return can;
    }
}
