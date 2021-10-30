package Manufacturing.ProductLine.Line;

import Manufacturing.CanEntity.Can;
import Manufacturing.Ingredient.ConcreteIngredient.Apple;
import Manufacturing.Ingredient.ConcreteIngredient.Clove;
import Manufacturing.Ingredient.ConcreteIngredient.Seasoning.Sugar;
import Manufacturing.Ingredient.Ingredient;
import Manufacturing.Machine.CombinationPart.CandiedAppleMachine;
import Manufacturing.Machine.IronCanMachine;
import Manufacturing.ProductLine.AbstractCanFactory.IronCanFactory;
import Manufacturing.ProductLine.FreshLine;
import Presentation.Protocol.OutputManager;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO:丁香鱼罐头生产线类
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:32
 */
public class HerringLine implements FreshLine {

    private List<Ingredient> ingredients=new ArrayList<>();
    private final IronCanMachine ironCanMachine = new IronCanMachine();
    @Override
    public List<Ingredient> preTreat(List<Ingredient> ingredientList) {

        OutputManager.getInstance().print(
                "******正在对丁香鱼进行预处理********",
                "******正在對丁香魚進行預處理********",
                "******Pretreating clove fish********");
        ingredientList = pretreatmentApp.filterTreat(ingredientList);
        pretreatmentApp.disinfect(ingredientList);
        pretreatmentApp.clean(ingredientList);
        OutputManager.getInstance().print(
                "*********丁香鱼预处理完成*********",
                "*********丁香魚預處理完成*********",
                "*********Clove fish pretreatment completed*********");
        ingredients=ingredientList;
        return ingredientList;
    }

    @Override
    public List<Can> produce(int count,String produceManner) {
        OutputManager.getInstance().print(
                "*******正在对丁香鱼进行加工*******",
                "*******正在對丁香魚進行加工*******",
                "*******Clove fish is being processed*******");

        List<Can> product=new ArrayList<>();

        for(int i=0;i<count;i++){
            Ingredient ingredient = ingredients.get(i);
            Can can= IronCanFactory.getInstance().createBigCan("Herring");
            ironCanMachine.preTreat(can);
            ironCanMachine.fill(can,ingredient);
            ironCanMachine.can(can);
            product.add(can);
        }
        OutputManager.getInstance().print(
                "共生产" + count + "个丁香鱼罐头",
                "共生產" + count + "個丁香魚罐頭",
                "Totally produced" + count + "clove can!");
        return product;
    }

    @Override
    public String getConcreteName() {
        return "cloveLine";
    }

    public static Can produceSample() {
        IronCanMachine ironCanMachine = new IronCanMachine();
        Can can = IronCanFactory.getInstance().createBigCan("Herring");
        ironCanMachine.preTreat(can);
        Ingredient clove =new Clove();
        ironCanMachine.fill(can, clove);
        ironCanMachine.can(can);
        return can;
    }
}
