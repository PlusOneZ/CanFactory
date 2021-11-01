package Manufacturing.ProductLine.Line;

import Manufacturing.CanEntity.Can;
import Manufacturing.Ingredient.ConcreteIngredient.Herring;
import Manufacturing.Ingredient.Ingredient;
import Manufacturing.Machine.CanMachine;
import Manufacturing.Machine.CanTreatmentMachine.IronCanProducingMachine;
import Manufacturing.Machine.GeneralMachine.HerringFilterMachine;
import Manufacturing.ProductLine.AbstractCanFactory.IronCanFactory;
import Manufacturing.ProductLine.FreshLine;
import Manufacturing.ProductLine.Pretreatment.PretreatmentApp;
import Presentation.Protocol.OutputManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 鲱鱼罐头生产线类
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:32
 */
public class HerringLine implements FreshLine {

    private PretreatmentApp pretreatmentApp = new PretreatmentApp(new HerringFilterMachine());

    private List<Ingredient> ingredients=new ArrayList<>();
    private final CanMachine ironCanProducingMachine = IronCanProducingMachine.getInstance();
    @Override
    public List<Ingredient> preTreat(List<Ingredient> ingredientList) {

        OutputManager.getInstance().print(
                "******正在对鲱鱼进行预处理********",
                "******正在對鯡魚進行預處理********",
                "******Pretreating herring fish********");
        ingredientList = pretreatmentApp.filterTreat(ingredientList);
        pretreatmentApp.disinfect(ingredientList);
        pretreatmentApp.clean(ingredientList);
        OutputManager.getInstance().print(
                "*********鲱鱼预处理完成*********",
                "*********鯡魚預處理完成*********",
                "*********Herring fish pretreatment completed*********");
        ingredients=ingredientList;
        return ingredientList;
    }

    @Override
    public List<Can> produce(int count,String produceManner) {
        OutputManager.getInstance().print(
                "*******正在对鲱鱼进行加工*******",
                "*******正在對鯡魚進行加工*******",
                "*******Herring fish is being processed*******");

        List<Can> product=new ArrayList<>();

        OutputManager.getInstance().print(
                "# 使用享元模式生产铁制罐头",
                "# 使用享元模式生產鐵製罐頭",
                "# Production of iron cans using Flyweight Pattern"
        );
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
                "Totally produced" + count + "herring can!");
        return product;
    }

    @Override
    public String getConcreteName() {
        return OutputManager.getInstance().selectStringForCurrentLanguage(
                "鲱鱼罐头生产线",
                "鯡魚罐頭生產線",
                "Herring Can Product Line"
        );
    }

    public static Can produceSample() {
        CanMachine ironCanProducingMachine = IronCanProducingMachine.getInstance();
        Can can = IronCanFactory.getInstance().createBigCan("Herring");
        ironCanProducingMachine.preTreat(can);
        Ingredient herring =new Herring();
        ironCanProducingMachine.fill(can, herring);
        ironCanProducingMachine.can(can);
        return can;
    }
}
