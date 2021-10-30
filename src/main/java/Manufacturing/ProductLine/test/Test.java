package Manufacturing.ProductLine.test;


import Manufacturing.ProductLine.*;
import Presentation.Protocol.OutputManager;

/**
* TODO:生产线相关设计模式测试类
*
*<p>抽象工厂模式，工厂模式、迭代器模式、享元模式测试</p>
* @author 孟繁霖
* @date 2021-10-12 9:19
*/
public class Test {
    public static void main(String[] args) {
        OutputManager.getInstance().setLanguage(OutputManager.Lang.zh_CN);

        //生产罐头测试
        Factory factory = FactoryProducer.getAbstractFactory("fruitLine");
        if (factory != null) {
            factory.produceCan("fruit", "apple", 6, "fine");
            factory.produceCan("fruit","peach",7,"fine");
            factory.produceCan("fruit","pear",10,"rough");
            factory.produceCan("fruit","pear",10,"rough");
            factory.produceCan("automated","apple",10,"rough");

        } else {
            OutputManager.getInstance().print(
                    "莫得工厂",
                    "莫得工廠",
                    "No Factory");
        }
        //迭代器测试
        Iterator i= factory.iterator();
        while(i.hasNext()){
            System.out.println(((ProductLine)i.next()).getConcreteName());
        }
    }
}
