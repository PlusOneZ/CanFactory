package Manufacturing.ProductLine.Line;

import Manufacturing.Ingredient.Ingredient;
import Manufacturing.ProductLine.FruitLine;
import Manufacturing.ProductLine.Producer.PearProducer;
import Presentation.Protocol.OutputManager;

import java.util.List;

/**
 * TODO:梨罐头生产线类
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:32
 */
public class PearLine implements FruitLine {
    @Override
    public List<Ingredient> preTreat(List<Ingredient> baseIngredientList) {
        OutputManager.getInstance().print(
                "******正在对梨进行预处理********",
                "******正在對梨進行預處理********",
                "******Pears are being preprocessed********");
        baseIngredientList = pretreatmentApp.filterTreat(baseIngredientList);
        pretreatmentApp.peel(baseIngredientList);
        pretreatmentApp.disinfect(baseIngredientList);
        OutputManager.getInstance().print(
                "*********梨预处理完成*********",
                "*********梨預處理完成*********",
                "*********Pear preprocessing completed*********");
        return baseIngredientList;
    }

    @Override
    public void produce(int count, String produceManner) {
        OutputManager.getInstance().print(
                "**********正在对梨进行加工*********",
                "**********正在對梨進行加工*********",
                "**********Pears are being processed*********");
        PearProducer pearProducer = new PearProducer(produceManner);
        pearProducer.produce();
        OutputManager.getInstance().print(
                "共生产" + count + "个梨罐头",
                "共生產" + count + "個梨罐頭",
                "Totally produced" + count + "pear can!");
    }

    @Override
    public String getConcreteName() {
        return "pearLine";
    }
}
