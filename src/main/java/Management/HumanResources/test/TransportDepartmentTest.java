package Management.HumanResources.test;

import Marketing.OrderCenterEntity.OrderCenter;
import Marketing.OrderEnity.Order;
import Marketing.OrderEnity.OrderCanInformation;
import Marketing.Promotion.Coupon;
import Marketing.Promotion.Sale.TwentyPercentOff;
import Presentation.Protocol.IOManager;
import Mediator.DepartmentMediator;
import Storage.StockCan;
import Storage.TransportationCan;

import java.util.ArrayList;
import java.util.Date;

/**
 * TODO：本类应放在Department包内，由于现在没有此包，暂时放在这里，之后需要修改路径
 * 运输部门单独的测试类
 *
 * @author 吴英豪
 * @since 2021-10-26 12:02
 */
public class TransportDepartmentTest {
    public static void main(String[] args) {
        // init some values
        DepartmentMediator departmentMediator = DepartmentMediator.getInstance();
        String CanName = "黄桃罐头";
        String customerAddress = "同济大学嘉定校区";
        int count = 10;
        int price = 200;
        IOManager.getInstance().print(
                "需要运输" + CanName + "到:"+customerAddress + ",数量为:" + count + ",单价为:" + price,
                "需要運輸" + CanName + "到:"+customerAddress + ",數量为:" + count + ",單價为:" + price,
                "need to transport" + CanName + "to"+customerAddress + "the count is:" + count + ",the price is:" + price
                );

        ArrayList<OrderCanInformation> orderCanInformationArrayList = new ArrayList<OrderCanInformation>();
        orderCanInformationArrayList.add(new OrderCanInformation(CanName,count,price));
        Coupon coupon = new Coupon(new TwentyPercentOff());
        OrderCenter.getInstance().createOneOrder(
                orderCanInformationArrayList, coupon, new Date(), customerAddress);

        // 生成运输罐头
        ArrayList<Order> orderList = departmentMediator.getPendingOrders();
        for(Order order : orderList){
            TransportationCan transportationCan = new TransportationCan(new Date(), customerAddress, order.getOrderId());
            ArrayList<StockCan> stockCans = new ArrayList<StockCan>();
            transportationCan.setStockCans(stockCans);
            //运输罐头
            order.getOrderState().handleProduction(order);
            order.getOrderState().handleTransportation(order);
            order.getOrderState().handleDelivery(order);
            departmentMediator.transportCans(transportationCan);

        }
    }
}
