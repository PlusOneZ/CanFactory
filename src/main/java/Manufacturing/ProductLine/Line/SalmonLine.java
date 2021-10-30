package Manufacturing.ProductLine.Line;

import Manufacturing.CanEntity.Can;
import Manufacturing.Ingredient.Ingredient;
import Manufacturing.Machine.IronCanMachine;
import Manufacturing.ProductLine.AbstractCanFactory.IronCanFactory;
import Manufacturing.ProductLine.FreshLine;
import Presentation.Protocol.OutputManager;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO:三文鱼罐头生产线类.
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:30
 */
public class SalmonLine implements FreshLine {

    private  List<Ingredient> ingredients=new ArrayList<>();
    private final IronCanMachine ironCanMachine = new IronCanMachine();

    @Override
    public List<Ingredient> preTreat(List<Ingredient> ingredientList) {

        OutputManager.getInstance().print(
                "*********正在对三文鱼进行预处理*********",
                "*********正在對三文魚進行預處理*********",
                "*********Salmon is being pretreated*********");
        ingredientList = pretreatmentApp.filterTreat(ingredientList);
        pretreatmentApp.disinfect(ingredientList);
        pretreatmentApp.clean(ingredientList);
        OutputManager.getInstance().print(
                "*************三文鱼预处理完成***********",
                "*************三文魚預處理完成***********",
                "*************Salmon pretreatment completed***********");
        ingredients=ingredientList;
        return ingredientList;
    }


    public List<Can> produce(int count,String produceManner) {
        OutputManager.getInstance().print(
                "**********正在对三文鱼进行加工**********",
                "**********正在對三文魚進行加工**********",
                "**********Salmon is being processed**********");

        List<Can> product=new ArrayList<>();

        for(int i=0;i<count;i++){
            Ingredient ingredient = ingredients.get(i);
            Can can= IronCanFactory.getInstance().createBigFruitCan();
            ironCanMachine.preTreat(can);
            ironCanMachine.fill(can,ingredient);
            ironCanMachine.can(can);
            product.add(can);
        }

        OutputManager.getInstance().print(
                "共生产" + count + "个三文鱼罐头",
                "共生產" + count + "個三文魚罐頭",
                "Totally produced" + count + "salmon can!");
        return product;
    }

    @Override
    public String getConcreteName() {
        return "salmonLine";
    }
}
