package Manufacturing.ProductLine;

import Manufacturing.CanEntity.Can;
import Manufacturing.Ingredient.ConcreteIngredient.Mixed.CandiedApple;
import Manufacturing.Ingredient.ConcreteIngredient.Seasoning.Sugar;
import Manufacturing.Ingredient.Ingredient;
import Manufacturing.ProductLine.Line.AutomatedLine.AutomatedLine;
import Manufacturing.ProductLine.Line.CandiedAppleLine;
import Presentation.Protocol.OutputManager;

import java.util.ArrayList;
import java.util.List;


/**
 * TODO:抽象工厂类，获取流水线并生产罐头.<br>
 * <b>应用了抽象工厂模式、工厂模式、模板方法模式</b>
 *
 * @author 孟繁霖
 * @date 2021-10-11 23:31
 */
public abstract class Factory {

    /**
     * TODO:获取水果罐头加工流水线方法.
     *
     * @param fruitLineType : 需要使用的水果罐头生产线类型（apple,peach,pear）
     * @return : Manufacturing.ProductLine.FruitLine
     * @author 孟繁霖
     * @date 2021-10-11 23:33
     */
    public abstract FruitLine getFruitLine(String fruitLineType);


    /**
     * TODO:获取生鲜罐头加工流水线方法.
     *
     * @param freshLineType :  需要使用的生鲜罐头生产线类型(salmon,clove)
     * @return : Manufacturing.ProductLine.FreshLine
     * @author 孟繁霖
     * @date 2021-10-11 23:34
     */
    public abstract FreshLine getFreshLine(String freshLineType);

    private final Supplier supplier = new Supplier();


    /**
     * TODO:生产罐头方法.
     * <b>实现了模板方法模式</b>
     * <i>无论哪种生产线生产罐头都要分采购、预处理、加工生产三个过程</i>
     *
     * @param canKind       : 罐头种类，仅限三种（fruit、fresh、automated）
     * @param canName       : 罐头名，仅限（apple、peach、pear、salmon、clove），需要与canKind对应，没做检验
     * @param materialCount : 采购原材料数量
     * @param produceManner :  加工方式，细加工（fine），粗加工(rough)
     * @author 孟繁霖
     * @date 2021-10-11 23:35
     */
    public final List<Can> produceCan(String canKind, String canName, int materialCount, String produceManner) {


        OutputManager.getInstance().print(
                "**************采购**************",
                "**************采購**************",
                "************Purchase************"
        );

        //购买原材料
        List<Ingredient> ingredientList = supplier.provide(canName, materialCount);
        if (ingredientList != null) {
            OutputManager.getInstance().print(
                    "********购买成功,原料如下********",
                    "********購買成功,原料如下********",
                    "Purchase successfully, the raw materials are as follows"
            );
            for (Ingredient ingredient : ingredientList) {
                System.out.println(ingredient.showContentsWithWeight());
            }
        } else {
            OutputManager.getInstance().print(
                    "*************购买失败************",
                    "*************購買失敗************",
                    "*******Failed purchase*******");
            return null;
        }



        //获得相应种类的生产线并进行预处理和生产加工
        if ("fruit".equals(canKind)) {
            FruitLine fruitLine = getFruitLine(canName);
            int count = (fruitLine.preTreat(ingredientList)).size();
           return fruitLine.produce(count, produceManner);
        } else if ("fresh".equals(canKind)) {
            FreshLine freshLine = getFreshLine(canName);
            int count = (freshLine.preTreat(ingredientList)).size();
            return freshLine.produce(count,produceManner);
        }
        else if("automated".equals(canKind)){
            List<Ingredient>sugarList=new ArrayList<>();
            for(int i=0;i<materialCount;i++){
            sugarList.add(new Sugar());
            }
            CandiedAppleLine candiedAppleLine =new CandiedAppleLine(ingredientList,sugarList);
            int count=(candiedAppleLine.preTreat(ingredientList)).size();
            return candiedAppleLine.produce(count,produceManner);
        }else{
            return null;
        }
    }

    /**
     * 获取下一个生产线
     * 通过迭代器获取
     *
     * @return : Manufacturing.ProductLine.ProductLine
     * @author 孟繁霖
     * @date 2021-10-14 21:51
     */
    public abstract ProductLine getNextLine();

    /**
     * 是否迭代到最后一个元素
     *
     * @return : boolean
     * @author 孟繁霖
     * @date 2021-10-14 21:56
     */
    public abstract boolean hasNextLine();

    /**
     * 获取生产线迭代器
     *
     * @return : Manufacturing.ProductLine.Iterator
     * @author 孟繁霖
     * @date 2021-10-14 22:01
     */
    public abstract Iterator iterator();

}
