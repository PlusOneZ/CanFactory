package
        Storage;


import Manufacturing.CanEntity.Can;
import Manufacturing.CanEntity.Material.IronMaterial;
import Manufacturing.CanEntity.Size.BigSize;
import Manufacturing.CanEntity.VegetableCan;
import Manufacturing.Ingredient.ConcreteIngredient.LotusRoot;
import Manufacturing.Ingredient.Ingredient;
import Manufacturing.Ingredient.Procedure.Cook;
import Manufacturing.ProductLine.Line.PeachLine;
import Marketing.OrderEnity.Order;
import Marketing.OrderEnity.OrderCanInformation;
import Marketing.Promotion.Coupon;
import Marketing.Promotion.Sale.TwentyPercentOff;
import Marketing.Wrapping.WrappedCan;
import Marketing.Wrapping.WrappingDepartment;
import Presentation.Protocol.OutputManager;

import java.util.ArrayList;
import java.util.Date;

/**
 * 此类为库存管理相关的测试驱动类;
 * 意图为验证库存管理的有效性;
 *
 * @author 王立友
 * @date 2021/10/17 23:32
 */
public class InventoryDriver {
    public static void main(String[] args){

        OutputManager.getInstance().setLanguage(OutputManager.Lang.zh_CN);

        InventoryDepartment inventoryDepartment = InventoryDepartment.getInstance();
        CanWareHouse canWareHouse = CanWareHouse.getInstance();

        //首先准备stub.
        WrappedCan wrappedCan = WrappingDepartment.getInstance().wrapCan(getStubCan());
        ArrayList<StockCan> stockCans = new ArrayList<>();
        StockCan stockCan = new StockCan(wrappedCan, 1);
        stockCans.add(stockCan);

        //测试添加到库存中;还未曾存在的情况;
        inventoryDepartment.addCanInventory(stockCans);

        //测试添加到库存中;已经存在的情况;
        inventoryDepartment.addCanInventory(stockCans);

        //测试增加某一罐头的库存
        inventoryDepartment.increaseCan(stockCan, 2);

        //测试取出某一个罐头
        inventoryDepartment.decreaseCan(stockCan, 2);

        //测试转换器的成功与否
//        ArrayList<OrderCanInformation> inventoryInformation = inventoryDepartment.getInventoryInformation();
//        System.out.println(inventoryInformation);

        //准备第二个stub
        //首先准备一个canInformation,coupon,latestDeliveryTime,customerAddress
        OrderCanInformation orderCanInformation =
                new OrderCanInformation(OutputManager.getInstance().selectStringForCurrentLanguage("黄桃罐头", "黃桃罐頭", "Peach Can"),4,5.0);
        ArrayList<OrderCanInformation> orderCanInformations = new ArrayList<>();
        orderCanInformations.add(orderCanInformation);
        Coupon coupon = new Coupon(new TwentyPercentOff());
        Date lastestDeliveryTime = new Date(2021,11,13);
        String customerAddress = new String("上海市嘉定区同济大学20号楼鼠鼠公寓");

        Order order = new Order(orderCanInformations, coupon, lastestDeliveryTime, customerAddress);


        inventoryDepartment.addOrder(order);
        inventoryDepartment.reviewOrder();
    }

    public static Can getStubCan(){
        return PeachLine.produceSample();
    }
}