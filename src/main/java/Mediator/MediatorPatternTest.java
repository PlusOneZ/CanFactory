package Mediator;

import Manufacturing.CanEntity.CanInfoController;
import Marketing.OrderCenterEntity.OrderCenter;
import Marketing.OrderEnity.OrderCanInformation;
import Marketing.Promotion.Coupon;
import Marketing.Promotion.Sale.TwentyPercentOff;
import Presentation.Protocol.IOManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * 中介者模式的测试类
 * @author 梁乔
 * @date 2021/11/2 15:15 
 */
public class MediatorPatternTest {
    public static void main(String[] args){
        IOManager.getInstance().print(
                "中介者模式开始。",
                "中介者模式開始。",
                "The intermediary model begins."
        );
        //创建一个新的订单
        Random r = new Random();
        int orderCanInfoNum = r.nextInt(5);
        ArrayList<OrderCanInformation> orderCanInformations = new ArrayList<OrderCanInformation>();
        for(int i = 0; i < orderCanInfoNum; i++){
            //随机获取罐头类型
            int canType = r.nextInt(4);
            //随机获取罐头数量
            int count = r.nextInt(100);
            //获取罐头名称
            String canName = CanInfoController.getInstance().getCanList().get(canType);
            //获取罐头价格
            double price = CanInfoController.getInstance().getCanPriceByName(canName);
            //生成一个子订单
            OrderCanInformation orderCanInformation = new OrderCanInformation(canName,count,price);
            orderCanInformations.add(orderCanInformation);
        }
        Coupon coupon = new Coupon(new TwentyPercentOff());
        String customerAddress = "同济大学嘉定校区";
        Date date = new Date();
        OrderCenter.getInstance().createOneOrder(orderCanInformations,coupon,date,customerAddress);
        IOManager.getInstance().print(
                "中介者通知库存部门处理订单。",
                "中介者通知庫存部門處理訂單。",
                "The Mediator informs the inventory department to process the order."
        );
        DepartmentMediator.getInstance().handleOrder(OrderCenter.getInstance().getPendingOrders().get(0));
    }
}