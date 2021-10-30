package Manufacturing.ProductLine.Line;

import Manufacturing.CanEntity.Can;
import Manufacturing.Ingredient.Ingredient;
import Manufacturing.Machine.IronCanMachine;
import Manufacturing.ProductLine.AbstractCanFactory.IronCanFactory;
import Manufacturing.ProductLine.FruitLine;
import Manufacturing.ProductLine.Producer.PeachProducer;
import Presentation.Protocol.OutputManager;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO:黄桃罐头生产线类
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:32
 */
public class PeachLine implements FruitLine {

    private final IronCanMachine ironCanMachine = new IronCanMachine();

    @Override
    public List<Ingredient> preTreat(List<Ingredient> ingredientList) {

        OutputManager.getInstance().print(
                "******正在对桃子进行预处理********",
                "******正在對桃子進行預處理********",
                "***Treating peaches*****");
        ingredientList = pretreatmentApp.filterTreat(ingredientList);
        pretreatmentApp.peel(ingredientList);
        pretreatmentApp.disinfect(ingredientList);
        OutputManager.getInstance().print(
                "********桃子预处理完成*********",
                "********桃子預處理完成*********",
                "***Peach pretreatment completed***");
        return ingredientList;
    }

    @Override
    public List<Can> produce(int count) {
        return null;
    }

    @Override
    public List<Can> produce(int count,String produceManner) {
        OutputManager.getInstance().print(
                "*******正在对黄桃进行加工*******",
                "*******正在對黃桃進行加工*******",
                "*******Peaches are being processed*******");
        PeachProducer peachProducer = new PeachProducer(produceManner);
        peachProducer.produce();

        List<Can> product=new ArrayList<>();
        for(int i=0;i<count;i++){
            Can can= IronCanFactory.getInstance().createBigFruitCan();
            ironCanMachine.preTreat(can);
            ironCanMachine.fill(can);
            ironCanMachine.can(can);
            product.add(can);
        }
        OutputManager.getInstance().print(
                "共生产" + count + "个黄桃罐头",
                "共生產" + count + "個黃桃罐頭",
                "Totally produced" + count + "peach can!");
        return product;
    }

    @Override
    public String getConcreteName() {
        return "peachLine";
    }
}
