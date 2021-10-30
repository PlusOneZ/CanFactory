package Manufacturing.ProductLine;


import Manufacturing.ProductLine.Line.HerringLine;
import Manufacturing.ProductLine.Line.SalmonLine;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO:生鲜罐头生产线工厂类,获取具体生鲜罐头生产线.<br>
 * <b>应用了工厂模式、享元模式</b>
 *
 * @author 孟繁霖
 * @date 2021-10-11 23:43
 */
public class FreshLineFactory extends Factory {

    /**
     * TODO:生产线Map.<br>
     * <b>应用享元模式，存储已有生产线对象，防止重复创建</b>
     */
    private static final HashMap<String, FreshLine> freshLineMap = new HashMap<>();

    /**
     * Map.EntrySet迭代器
     */
    private java.util.Iterator<Map.Entry<String, FreshLine>> iterator;

    @Override
    public Manufacturing.ProductLine.Iterator iterator(){
        iterator=freshLineMap.entrySet().iterator();
        return new LineIterator<FreshLineFactory>(this);
    }

    @Override
    public FruitLine getFruitLine(String fruitLineType) {
        return null;
    }


    /**
     * TODO:获取指定类型的生鲜罐头生产线.<br>
     * <i>已有的生产线从map中获取，没有的新建并存储在map中</i>
     *
     * @param freshLineType :  需要使用的生鲜罐头生产线类型(salmon,clove)
     * @return : Manufacturing.ProductLine.FreshLine
     * @author 孟繁霖
     * @date 2021-10-11 23:45
     */
    @Override
    public FreshLine getFreshLine(String freshLineType) {
        if ("salmon".equals(freshLineType)) {
            //享元模式应用，没有再创建、有则不创建
            if (!freshLineMap.containsKey("salmonLine")) {
                SalmonLine salmonLine = new SalmonLine();
                freshLineMap.put("salmonLine", salmonLine);
                return salmonLine;
            } else {
                return freshLineMap.get("salmonLine");
            }
        } else if ("clove".equals(freshLineType)) {
            if (!freshLineMap.containsKey("cloveLine")) {
                HerringLine herringLine = new HerringLine();
                freshLineMap.put("cloveLine", herringLine);
                return herringLine;
            } else {
                return freshLineMap.get("cloveLine");
            }
        } else return null;
    }

    @Override
    public FreshLine getNextLine(){
        return iterator.next().getValue();
    }

    @Override
    public boolean  hasNextLine(){
        return iterator.hasNext();
    }
}
