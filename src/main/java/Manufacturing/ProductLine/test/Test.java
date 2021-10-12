package Manufacturing.ProductLine.test;


import Manufacturing.ProductLine.AbstractFactory;
import Manufacturing.ProductLine.FactoryProducer;
import Presentation.Protocol.OutputManager;

/**
* TODO:生产线相关设计模式测试类
*
* @author 孟繁霖
* @date 2021-10-12 9:19
*/
public class Test {
    public static void main(String[] args) {
        OutputManager.getInstance().setLanguage(OutputManager.Lang.zh_CN);
        AbstractFactory abstractFactory = FactoryProducer.getAbstractFactory("fruitLine");
        if (abstractFactory != null) {
            abstractFactory.produceCan("fruit", "apple", 6, "fine");
        } else {
            OutputManager.getInstance().errorMassage(
                    "莫得工厂",
                    "莫得工廠",
                    "No Factory");
        }
    }
}
