package Manufacturing.ProductLine;


import Manufacturing.ProductLine.Line.PeachLine;


import java.util.HashMap;
import java.util.Map;


/**
 * TODO:水果罐头生产线工厂类，获取具体水果罐头生产线.<br>
 * <b>应用了工厂模式、享元模式</b>
 *
 * @author 孟繁霖
 * @date 2021-10-11 23:48
 */
public class FruitLineFactory extends Factory {
    /**
     * TODO:水果罐头生产线map
     * <b>应用享元模式，存储已有生产线对象，防止重复创建</b>
     */
    private static final HashMap<String, FruitLine> fruitLineMap = new HashMap<>();


    /**
     * Map.EntrySet迭代器
     */
    private static java.util.Iterator<Map.Entry<String, FruitLine>> iterator;

    @Override
    public Manufacturing.ProductLine.Iterator iterator() {
        iterator = fruitLineMap.entrySet().iterator();
        return new LineIterator<FruitLineFactory>(this);
    }

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


         if ("peach".equals(fruitLineType)) {
            if (!fruitLineMap.containsKey("peachLine")) {
                PeachLine peachLine = new PeachLine();
                fruitLineMap.put("peachLine", peachLine);
                return peachLine;
            } else {
                return fruitLineMap.get("peachLine");
            }
        } else{
             return null;
         }
    }

    @Override
    public FreshLine getFreshLine(String freshLineType) {
        return null;
    }

    @Override
    public ProductLine getNextLine() {
        return iterator.next().getValue();
    }

    @Override
    public boolean hasNextLine() {
        return iterator.hasNext();
    }
}
