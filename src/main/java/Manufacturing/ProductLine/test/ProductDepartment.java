package Manufacturing.ProductLine.test;


import Manufacturing.CanEntity.Can;
import Manufacturing.CanEntity.CanInfoController;
import Manufacturing.ProductLine.*;
import Marketing.OrderEnity.OrderCanInformation;
import Marketing.Wrapping.WrappedCan;
import Mediator.DepartmentMediator;
import Presentation.Protocol.IOManager;
import Storage.StockCan;


import java.util.ArrayList;
import java.util.List;


/**
 * 生产线相关设计模式测试类
 *
 * <p>抽象工厂模式，工厂模式、迭代器模式、享元模式测试</p>
 *
 * @author 孟繁霖
 * @date 2021-10-12 9:19
 */
public class ProductDepartment {


    private final static ProductDepartment productDepartment = new ProductDepartment();

    private ProductDepartment() {
    }

    public static ProductDepartment getInstance() {
        return productDepartment;
    }

    /**
     * 生产罐头
     *
     * @param canKind       : 罐头种类
     * @param canName       : 罐头名
     * @param materialCount : 原料数量
     * @param produceManner :  加工方式
     * @return : java.util.List<Manufacturing.CanEntity.Can>
     * @author 孟繁霖
     * @date 2021-10-30 22:02
     */
    public List<Can> produce(String canKind, String canName, int materialCount, String produceManner) {
        List<Can> productList = new ArrayList<>();

        Factory factory = FactoryProducer.getAbstractFactory(canKind);
        if (factory != null) {
            productList = factory.produceCan(canKind, canName, materialCount, produceManner);
        } else {
            IOManager.getInstance().print(
                    "莫得工厂",
                    "莫得工廠",
                    "No Factory");
        }
        return productList;
    }

    /**
     * 生产、包装、存储罐头
     *
     * @param canKind       : 罐头种类
     * @param canName       : 罐头名
     * @param materialCount : 原料数量
     * @param produceManner :  生产方式
     * @author 孟繁霖
     * @date 2021-10-30 22:03
     */
    public StockCan wrapAndStock(String canKind, String canName, int materialCount, String produceManner) {
        List<Can> canList = produce(canKind, canName, materialCount, produceManner);
        WrappedCan wrappedCan = null;
        if (canList.isEmpty()){
            return null;
        }
        IOManager.getInstance().print(
                "# 使用中介者模式: 调用包装部门对" + canList.get(0).getCanName() + "进行封面包装",
                "# 使用中介者模式: 調用包裝部門對" + canList.get(0).getCanName() + "進行封麵包裝",
                "# Using Intermediary Pattern: Call the packaging department to cover " + canList.get(0).getCanName()
        );
        wrappedCan = DepartmentMediator.getInstance().wrapCan(canList.get(0));
        IOManager.getInstance().print(
                "包装完成",
                "包裝完成",
                "Packaging is complete"
        );
        return new StockCan(wrappedCan, canList.size());
    }

    /**
     * 根据订单生产罐头
     *
     * @param orderCanInformation :  订单
     * @author 孟繁霖
     * @date 2021-10-30 22:04
     */
    public StockCan produceCans(OrderCanInformation orderCanInformation) {
        int count = orderCanInformation.getCount();
        String name = orderCanInformation.getCanName();
        String canKind = CanInfoController.getInstance().getCanType(name);
        StringBuilder canName = new StringBuilder(CanInfoController.getInstance().getEnNameOfCan(name));
        String[] canNames = canName.toString().split(" ");
        canName = new StringBuilder();
        for (int i = 0; i < canNames.length - 1; i++) {
            canName.append(canNames[i]);
        }
        return wrapAndStock(canKind, canName.toString().toLowerCase(), count, "fine");
    }

    /**
     * 根据订单列表生产罐头
     *
     * @param orderCanInformationList :  订单列表
     * @author 孟繁霖
     * @date 2021-10-30 22:36
     */
    public void produceCansByOrderList(List<OrderCanInformation> orderCanInformationList) {
        ArrayList<StockCan> stockCans = new ArrayList<>();
        for (OrderCanInformation orderCanInformation : orderCanInformationList) {
            StockCan stockCan = produceCans(orderCanInformation);
            if(stockCan != null){
                stockCans.add(stockCan);
            }
        }
        DepartmentMediator.getInstance().addCanInventory(stockCans);
    }

    /**
    * 抽象工厂、工厂、模板方法、迭代器、享元模式测试方法
    * @param args 1
    * @author 孟繁霖
    * @date 2021-11-01 22:50
    */
    public static void main(String[] args) {

        List<List<Can>> productList = new ArrayList<>();

        IOManager.getInstance().print(
                "# 使用抽象工厂模式、工厂模式：创建生产工厂、生产线并按照模板方法进行生产",
                "# 使用抽象工廠模式、工廠模式：創建生產工廠、生產線並按照模板方法進行生產",
                "# Using abstract factory pattern and factory pattern: create production factories and production lines and perform production in accordance with the template method");
        Factory factory = FactoryProducer.getAbstractFactory("fresh");
        if (factory != null) {
            productList.add(factory.produceCan("fresh", "salmon", 6, "fine"));
            productList.add(factory.produceCan("fresh", "herring", 6, "fine"));
            productList.add(factory.produceCan("fresh", "salmon", 6, "fine"));
        } else {
            IOManager.getInstance().print(
                    "莫得工厂",
                    "莫得工廠",
                    "No Factory");
        }

        IOManager.getInstance().print(
                "# 迭代器模式和享元模式",
                "# 叠代器模式和享元模式",
                "# Iterator Pattern and Flyweight Pattern");
        //迭代器模式、享元模式测试，打印已有生产线，虽然生产两次salmon罐头，生产线只用一条
        Iterator i = factory.iterator();
        while (i.hasNext()) {
         IOManager.getInstance().printLanguageIrrelevantContent(((ProductLine) i.next()).getConcreteName());
        }
    }
}
