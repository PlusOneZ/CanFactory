package Marketing.OrderCenter;


import Marketing.Order.Order;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 梁乔 2021/10/10
 **/
public class Test {
    public static void main(String[] args) {
        //产生一个新的订单，比如肉类罐头订单
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd/HH/mm");
        Date currentDate = new Date();
        String currentTime = dateFormat.format(currentDate);
        Date orderComTime = new Date();
        try {
            orderComTime = dateFormat.parse("2022/12/12/03/23");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        MeatCan mc = new MeatCan();
        System.out.println("出现了新的订单！！！");
        //尝试加入一个订单
        Order<MeatCan> newOrder1 = new Order<MeatCan>(mc,299,orderComTime,currentDate);
        //生成一个订单目标
        OrderDataSubject<MeatCan> newOrderData1 = new OrderDataSubject<MeatCan>();

        //生成订单中心观察者
        OrderDisplayCenter odc1 = new OrderDisplayCenter(newOrderData1,"订单中心1号");



        //生成生产规划中心单例观察者
        ProductionPlanningCenter.getInstance(newOrderData1);

        //表示有了新的订单数据，开始更新
        newOrderData1.getNewOrderData(newOrder1);

        //尝试加入一个订单
        Order<MeatCan> newOrder2 = new Order<MeatCan>(mc,1299,orderComTime,currentDate);
        //生成一个订单目标
        OrderDataSubject<MeatCan> newOrderData2 = new OrderDataSubject<MeatCan>();
        //更改目标
        odc1.setSubject(newOrderData2);
        ProductionPlanningCenter.getInstance(newOrderData2).setSubject(newOrderData2);
        newOrderData2.getNewOrderData(newOrder2);

    }
}
