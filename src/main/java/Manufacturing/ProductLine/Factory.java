package Manufacturing.ProductLine;


import Management.QualityTesting.QualityAssuranceDepartment;
import Manufacturing.CanEntity.Can;
import Manufacturing.Ingredient.ConcreteIngredient.Seasoning.Sugar;
import Manufacturing.Ingredient.Ingredient;
import Manufacturing.ProductLine.Line.AutomatedLine.CandiedAppleLine;
import Presentation.Protocol.OutputManager;

import java.util.ArrayList;
import java.util.List;


/**
 * 抽象工厂类，获取流水线并生产罐头
 * <b>应用了抽象工厂模式、工厂模式、模板方法模式</b>
 *
 * @author 孟繁霖
 * @date 2021-10-11 23:31
 */
public abstract class Factory {

    /**
     * 获取水果罐头加工流水线方法
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
     * 生产罐头方法.
     * <b>实现了模板方法模式</b>
     * <i>无论哪种生产线生产罐头都要分采购、预处理、加工生产三个过程</i>
     *
     * @param canKind       : 罐头种类，仅限两种（fruit、fresh）
     * @param canName       : 罐头名，仅限（candiedApple、peach、salmon、herring），需要与canKind对应
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
               OutputManager.getInstance().printLanguageIrrelevantContent(ingredient.showContentsWithWeight());
            }
        } else {
            OutputManager.getInstance().print(
                    "*************购买失败************",
                    "*************購買失敗************",
                    "*******Failed purchase*******");
            return new ArrayList<Can>();
        }

        List<Can> canList;
        //获得相应种类的生产线并进行预处理和生产加工
        if ("fruit".equalsIgnoreCase(canKind) && "candiedApple".equalsIgnoreCase(canName)) {
            List<Ingredient> sugarList = new ArrayList<>();
            for (int i = 0; i < materialCount; i++) {
                sugarList.add(new Sugar());
            }
            CandiedAppleLine candiedAppleLine = new CandiedAppleLine(ingredientList, sugarList);
            return candiedAppleLine.produce(1, produceManner);
        } else if ("fruit".equalsIgnoreCase(canKind)) {
            FruitLine fruitLine = getFruitLine(canName);
            int count = (fruitLine.preTreat(ingredientList)).size();
            canList = fruitLine.produce(count, produceManner);
        } else if ("fresh".equalsIgnoreCase(canKind)) {
            FreshLine freshLine = getFreshLine(canName);
            int count = (freshLine.preTreat(ingredientList)).size();
            canList = freshLine.produce(count, produceManner);
        } else {
            OutputManager.getInstance().print(
                    "********没有对应生产线********",
                    "********沒有對應生産線********",
                    "There is no corresponding production line!"
            );
            return new ArrayList<Can>();
        }

        List<Can> passedTestCan = new ArrayList<>();
        // 质检部门介入
        int i = 1;
        for (Can c :canList) {
            // 随机质检
            if (Math.random() > 0.2) continue;
            if (QualityAssuranceDepartment.getInstance().testQuality(c)
                && QualityAssuranceDepartment.getInstance().testSafety(c)) {
                OutputManager.getInstance().print(
                        "质检部门抽样检测了这批罐头的第" + i + "个罐头。",
                        "質檢部門抽樣檢測了這批罐頭的第" + i + "個罐頭。",
                        "The quality assurance department sampled No." + i + " can."
                );
                passedTestCan.add(c);
            }
            i++;
        }
        return passedTestCan;
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
