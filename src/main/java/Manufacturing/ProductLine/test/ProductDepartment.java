package Manufacturing.ProductLine.test;


import Manufacturing.CanEntity.Can;
import Manufacturing.CanEntity.CanInfoController;
import Manufacturing.ProductLine.*;
import Marketing.OrderEnity.OrderCanInformation;
import Marketing.Wrapping.WrappedCan;
import Mediator.DepartmentMediator;
import Presentation.Protocol.OutputManager;
import Storage.StockCan;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


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
            OutputManager.getInstance().print(
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
        OutputManager.getInstance().print(
                "实现中介者模式: 调用包装部门对" + canList.get(0).getCanName() + "进行封面包装",
                "實現中介者模式: 調用包裝部門對" + canList.get(0).getCanName() + "進行封麵包裝",
                "Implement the intermediary pattern: Call the packaging department to cover " + canList.get(0).getCanName()
        );
        wrappedCan = DepartmentMediator.getInstance().wrapCan(canList.get(0));
        OutputManager.getInstance().print(
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

    public static void main(String[] args) {
        OutputManager.getInstance().setLanguage(OutputManager.Lang.zh_CN);

        List<List<Can>> productList = new ArrayList<>();

        DepartmentMediator departmentMediator = DepartmentMediator.getInstance();

        Factory factory = FactoryProducer.getAbstractFactory("fresh");
        if (factory != null) {
            productList.add(factory.produceCan("fresh", "salmon", 7, "fine"));
        } else {
            OutputManager.getInstance().print(
                    "莫得工厂",
                    "莫得工廠",
                    "No Factory");
        }
        //包装罐头、加入库存
        ArrayList<StockCan> stockCanArrayList = new ArrayList<>();
        ArrayList<WrappedCan> wrappedCanArrayList = new ArrayList<>();
        for (List<Can> canList : productList) {
            wrappedCanArrayList.add(departmentMediator.wrapCan(canList.get(0)));
            System.out.println(canList);

        }
        stockCanArrayList.add(new StockCan(wrappedCanArrayList.get(0), wrappedCanArrayList.size()));
        departmentMediator.addCanInventory(stockCanArrayList);


        //迭代器测试
        Iterator i = factory.iterator();
        while (i.hasNext()) {
            System.out.println(((ProductLine) i.next()).getConcreteName());
        }
    }
}
