package Manufacturing.ProductLine.Line;

import Manufacturing.CanEntity.Can;
import Manufacturing.Ingredient.ConcreteIngredient.Herring;
import Manufacturing.Ingredient.Ingredient;
import Manufacturing.Machine.CanTreatmentMachine.IronCanProducingMachine;
import Manufacturing.Machine.GeneralMachine.HerringFilterMachine;
import Manufacturing.ProductLine.AbstractCanFactory.IronCanFactory;
import Manufacturing.ProductLine.FreshLine;
import Manufacturing.ProductLine.Pretreatment.PretreatmentApp;
import Presentation.Protocol.OutputManager;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO:鲱鱼罐头生产线类
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:32
 */
public class HerringLine implements FreshLine {

    private PretreatmentApp pretreatmentApp = new PretreatmentApp(new HerringFilterMachine());

    private List<Ingredient> ingredients=new ArrayList<>();
    private final IronCanProducingMachine ironCanProducingMachine = new IronCanProducingMachine();
    @Override
    public List<Ingredient> preTreat(List<Ingredient> ingredientList) {

        OutputManager.getInstance().print(
                "******正在对鲱鱼进行预处理********",
                "******正在對鯡魚進行預處理********",
                "******Pretreating clove fish********");
        ingredientList = pretreatmentApp.filterTreat(ingredientList);
        pretreatmentApp.disinfect(ingredientList);
        pretreatmentApp.clean(ingredientList);
        OutputManager.getInstance().print(
                "*********鲱鱼预处理完成*********",
                "*********鯡魚預處理完成*********",
                "*********Clove fish pretreatment completed*********");
        ingredients=ingredientList;
        return ingredientList;
    }

    @Override
    public List<Can> produce(int count,String produceManner) {
        OutputManager.getInstance().print(
                "*******正在对鲱鱼进行加工*******",
                "*******正在對鯡魚進行加工*******",
                "*******Clove fish is being processed*******");

        List<Can> product=new ArrayList<>();

        for(int i=0;i<count;i++){
            Ingredient ingredient = ingredients.get(i);
            Can can= IronCanFactory.getInstance().createBigCan("Herring");
            ironCanProducingMachine.preTreat(can);
            ironCanProducingMachine.fill(can,ingredient);
            ironCanProducingMachine.can(can);
            product.add(can);
        }
        OutputManager.getInstance().print(
                "共生产" + count + "个鲱鱼罐头",
                "共生產" + count + "個鯡魚罐頭",
                "Totally produced" + count + "clove can!");
        return product;
    }

    @Override
    public String getConcreteName() {
        return "HerringLine";
    }

    public static Can produceSample() {
        IronCanProducingMachine ironCanProducingMachine = new IronCanProducingMachine();
        Can can = IronCanFactory.getInstance().createBigCan("Herring");
        ironCanProducingMachine.preTreat(can);
        Ingredient herring =new Herring();
        ironCanProducingMachine.fill(can, herring);
        ironCanProducingMachine.can(can);
        return can;
    }
}
