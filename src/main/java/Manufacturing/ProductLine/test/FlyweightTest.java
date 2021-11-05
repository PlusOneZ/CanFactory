package Manufacturing.ProductLine.test;

import Manufacturing.CanEntity.Can;
import Manufacturing.ProductLine.*;
import Presentation.Protocol.IOManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 享元模式测试类
 *
 * @author 孟繁霖
 * @date 2021/10/30 20:07
 */
public class FlyweightTest {
    public static void main(String[] args) {
        List<List<Can>> productList = new ArrayList<>();

        IOManager.getInstance().print(
                "# 分两批次生产三文鱼罐头验证享元模式",
                "# 分兩批次生產三文魚罐頭驗證享元模式",
                "# Validate Flyweight Pattern of producing canned salmon in two batches");
        Factory factory = FactoryProducer.getAbstractFactory("fresh");
        if (factory != null) {
            productList.add(factory.produceCan("fresh", "salmon", 6, "fine"));
            productList.add(factory.produceCan("fresh", "salmon", 6, "fine"));
        } else {
            IOManager.getInstance().print(
                    "莫得工厂",
                    "莫得工廠",
                    "No Factory");
        }

        IOManager.getInstance().print(
                "# 享元模式查看生产线",
                "# 享元模式查看生產線",
                "# View production line of Flyweight Pattern");
        //享元模式测试，打印已有生产线，虽然生产两次salmon罐头，生产线只用一条
        Iterator i = factory.iterator();
        while (i.hasNext()) {
            IOManager.getInstance().printLanguageIrrelevantContent(((ProductLine) i.next()).getConcreteName());
        }
    }
}
