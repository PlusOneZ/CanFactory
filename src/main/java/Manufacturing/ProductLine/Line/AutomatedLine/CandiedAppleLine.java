package Manufacturing.ProductLine.Line.AutomatedLine;

import Manufacturing.CanEntity.Can;
import Manufacturing.Ingredient.ConcreteIngredient.Apple;
import Manufacturing.Ingredient.ConcreteIngredient.Seasoning.Sugar;
import Manufacturing.Ingredient.Ingredient;
import Manufacturing.Machine.CombinationPart.CandiedAppleMachine;
import Manufacturing.Machine.IronCanMachine;
import Manufacturing.ProductLine.AbstractCanFactory.IronCanFactory;
import Presentation.Protocol.OutputManager;

import java.util.ArrayList;
import java.util.Arrays;
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
    private final IronCanMachine ironCanMachine = new IronCanMachine();


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
        apples = preTreat(apples);
        for (int i = 0; i < count; i++) {
            try {
                Ingredient candiedApple = candiedAppleMachine.combine(apples.get(i), sugarList.get(i));
                Can can = IronCanFactory.getInstance().createSmallCan("CandiedApple");
                ironCanMachine.preTreat(can);
                ironCanMachine.fill(can, candiedApple);
                ironCanMachine.can(can);
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

        return product;
    }


    public static void main(String[] args) {
        List<Ingredient> apples = Arrays.asList(new Apple(), new Apple(), new Apple(), new Apple(), new Apple());
        List<Ingredient> sugarList = Arrays.asList(new Sugar(), new Sugar(), new Sugar(), new Sugar(), new Sugar());

        CandiedAppleLine candiedAppleLine = new CandiedAppleLine(apples, sugarList);


        List<Can> cans = candiedAppleLine.produce(4,"fine");

        for (Can can :
                cans) {
            System.out.println(can);
        }
    }

    public static Can produceSample() {
        CandiedAppleMachine candiedAppleMachine = new CandiedAppleMachine();
        IronCanMachine ironCanMachine = new IronCanMachine();
        Can can = IronCanFactory.getInstance().createSmallCan("CandiedApple");

        ironCanMachine.preTreat(can);
        Ingredient candiedApple = candiedAppleMachine.combine(new Apple(), new Sugar());
        ironCanMachine.fill(can, candiedApple);
        ironCanMachine.can(can);
        return can;
    }
}
