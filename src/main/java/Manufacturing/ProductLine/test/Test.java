package Manufacturing.ProductLine.test;


import Manufacturing.CanEntity.Can;
import Manufacturing.ProductLine.*;
import Manufacturing.ProductLine.Line.HerringLine;
import Marketing.OrderEnity.OrderCanInformation;
import Marketing.Wrapping.WrappedCan;
import Mediator.DepartmentMediator;
import Presentation.Protocol.OutputManager;
import Storage.StockCan;


import java.util.ArrayList;
import java.util.List;


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

        List<List<Can>> productList=new ArrayList<>();
        //生产罐头测试
//        Factory factory = FactoryProducer.getAbstractFactory("fruitLine");
//        if (factory != null) {
//            productList.add(factory.produceCan("fruit","peach",7,"fine"));
//            productList.add(factory.produceCan("automated","apple",10,"rough"));
//        } else {
//            OutputManager.getInstance().print(
//                    "莫得工厂",
//                    "莫得工廠",
//                    "No Factory");
//        }
//        for(List<Can> canList:productList){
//            for(Can can:canList){
//                System.out.println(can.toString());
//            }
//        }

       DepartmentMediator departmentMediator=DepartmentMediator.getInstance();

        ArrayList<OrderCanInformation> infoList=new ArrayList<>();
        infoList.add(new OrderCanInformation("salmon",7,23.6));
        departmentMediator.productCans(infoList);

        Factory factory = FactoryProducer.getAbstractFactory("freshLine");
        if (factory != null) {
            productList.add(factory.produceCan("fresh","salmon",7,"fine"));
        } else {
            OutputManager.getInstance().print(
                    "莫得工厂",
                    "莫得工廠",
                    "No Factory");
        }
        ArrayList<StockCan> stockCanArrayList=new ArrayList<>();
        ArrayList<WrappedCan> wrappedCanArrayList=new ArrayList<>();
        for(List<Can> canList:productList){
            for(Can can:canList){
                wrappedCanArrayList.add(departmentMediator.wrapCan(can));
                System.out.println(can.toString());
            }
        }
        stockCanArrayList.add(new StockCan(wrappedCanArrayList.get(0),wrappedCanArrayList.size()));
        departmentMediator.addCanInventory(stockCanArrayList);

        System.out.println(HerringLine.produceSample().toString());

        //迭代器测试
        Iterator i= factory.iterator();
        while(i.hasNext()){
            System.out.println(((ProductLine)i.next()).getConcreteName());
        }
    }
}
