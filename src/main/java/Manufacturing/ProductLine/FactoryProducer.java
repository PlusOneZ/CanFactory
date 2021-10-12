package Manufacturing.ProductLine;


/**
 * TODO:抽象工厂生成类
 *
 * @author 孟繁霖
 * @date 2021-10-11 23:39
 */
public class FactoryProducer {
    public static AbstractFactory getAbstractFactory(String lineName) {
        if ("fruitLine".equals(lineName)) {
            return new FruitLineFactory();
        } else if ("freshLine".equals(lineName)) {
            return new FreshLineFactory();
        } else return null;
    }
}
