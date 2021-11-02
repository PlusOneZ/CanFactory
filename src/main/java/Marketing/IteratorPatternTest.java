package Marketing;


import Manufacturing.CanEntity.CanInfoController;
import Marketing.OrderCenterEntity.OrderCenter;
import Marketing.OrderEnity.Order;
import Marketing.OrderEnity.OrderCanInformation;
import Marketing.Promotion.Coupon;
import Marketing.Promotion.Sale.TwentyPercentOff;
import Presentation.Protocol.IOManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * 迭代器模式的测试类
 * @author 梁乔
 * @date 2021/11/2 14:57 
 */
public class IteratorPatternTest {
    public static void main(String[] args){
        //迭代器需要创建一系列订单
        IOManager.getInstance().print(
                "迭代器模式开始。",
                "迭代器模式開始。",
                "Start of iterator mode."
        );
        IOManager.getInstance().print(
                "随机创建一系列订单。",
                "隨機創建一系列訂單。",
                "Create a series of orders randomly."
        );
        Random r = new Random();
        int orderNum = r.nextInt(10);
        for(int i = 0; i < orderNum; i++){
            int orderCanInfoNum = r.nextInt(5);
            ArrayList<OrderCanInformation> orderCanInformations = new ArrayList<OrderCanInformation>();
            for(int j = 0; j < orderCanInfoNum; j++){
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
            Date date = new Date();
            Coupon coupon = new Coupon(new TwentyPercentOff());
            OrderCenter.getInstance().createOneOrder(orderCanInformations,coupon,date,"同济大学");
        }
        IOManager.getInstance().print(
                "使用迭代器获取订单列表。",
                "使用迭代器獲取訂單列表。",
                "Use an iterator to get a list of orders."
        );
        for(Iterator iter = OrderCenter.getInstance().getIterator();iter.hasNext();)
        {
            Order od = (Order)iter.next();
            IOManager.getInstance().print(
                    "订单ID："+ od.getOrderId(),
                    "訂單ID："+ od.getOrderState(),
                    "Order Id:"+ od.getOrderId()
            );
        }
    }
}