package Manufacturing.ProductLine;

import Manufacturing.ProductLine.Line.AppleLine;
import Manufacturing.ProductLine.Line.PeachLine;
import Manufacturing.ProductLine.Line.PearLine;

import java.util.HashMap;


/**
 * TODO:水果罐头生产线工厂类，获取具体水果罐头生产线.<br>
 * <b>应用了工厂模式、享元模式</b>
 *
 * @author 孟繁霖
 * @date 2021-10-11 23:48
 */
public class FruitLineFactory extends AbstractFactory {
    /**
     * TODO:水果罐头生产线map
     * <b>应用享元模式，存储已有生产线对象，防止重复创建</b>
     */
    private static final HashMap<String, FruitLine> fruitLineMap = new HashMap<>();


    /**
     * TODO:获取指定类型的水果罐头生产线方法.<br>
     * <i>已有的生产线从map中获取，没有的新建并存储在map中</i>
     *
     * @param fruitLineType :  需要使用的水果罐头生产线类型（apple,peach,pear）
     * @return : Manufacturing.ProductLine.FruitLine
     * @author 孟繁霖
     * @date 2021-10-11 23:50
     */
    @Override
    public FruitLine getFruitLine(String fruitLineType) {

        if ("apple".equals(fruitLineType)) {
            //享元模式应用，没有再创建、有则不创建
            if (!fruitLineMap.containsKey("appleLine")) {
                AppleLine appleLine = new AppleLine();
                fruitLineMap.put("appleLine", appleLine);
                return appleLine;
            } else {
                return fruitLineMap.get("appleLine");
            }
        } else if ("peach".equals(fruitLineType)) {
            if (!fruitLineMap.containsKey("peachLine")) {
                PeachLine peachLine = new PeachLine();
                fruitLineMap.put("peachLine", peachLine);
                return peachLine;
            } else {
                return fruitLineMap.get("peachLine");
            }
        } else if ("pear".equals(fruitLineType)) {
            if (!fruitLineMap.containsKey("pear")) {
                PearLine pearLine = new PearLine();
                fruitLineMap.put("pearLine", pearLine);
                return pearLine;
            } else {
                return fruitLineMap.get("pearLine");
            }
        } else return null;
    }

    @Override
    public FreshLine getFreshLine(String freshLineType) {
        return null;
    }
}
