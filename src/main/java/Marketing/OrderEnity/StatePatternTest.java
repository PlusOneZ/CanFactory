package Marketing.OrderEnity;

import Manufacturing.CanEntity.CanInfoController;
import Marketing.OrderCenterEntity.OrderCenter;
import Marketing.Promotion.Coupon;
import Marketing.Promotion.Sale.TwentyPercentOff;
import Presentation.Protocol.OutputManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * 有关状态模式的测试类
 * @author 梁乔
 * @date 2021/11/2 11:09 
 */
public class StatePatternTest {
    public static void main(String[] args){
        OutputManager.getInstance().print(
                "状态模式开始：",
                "狀態模式開始：",
                "State pattern starts:"
        );
        OutputManager.getInstance().setLanguage(OutputManager.Lang.zh_CN);
        //首先随机创建一个订单
        OutputManager.getInstance().print(
                "随机创建一个订单。",
                "隨機創建一個訂單。",
                "Create an order randomly."
        );
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
        OrderCenter.getInstance().displayOrderData();
        Order order = OrderCenter.getInstance().getPendingOrders().get(0);
        //显示订单当前状态

        OutputManager.getInstance().print(
                "当前订单的状态为："+ order.getOrderState().getCNStateName(),
                "當前訂單的狀態為："+order.getOrderState().getTWStateName(),
                "The status of the current order is:"+order.getOrderState().getENStateName()
        );
        OutputManager.getInstance().print(
                "修改当前订单的状态为已生产状态。",
                "修改當前訂單的狀態為已生產狀態。",
                "Modify the status of the current order to be produced."
        );
        order.changeOrderState(new ProducedOrderState());
        OutputManager.getInstance().print(
                "当前订单的状态为："+ order.getOrderState().getCNStateName(),
                "當前訂單的狀態為："+order.getOrderState().getTWStateName(),
                "The status of the current order is:"+order.getOrderState().getENStateName()
        );
        OutputManager.getInstance().print(
                "修改当前订单的状态为运输中状态。",
                "修改當前訂單的狀態為運輸中狀態。",
                "Modify the status of the current order to be transporting."
        );
        order.changeOrderState(new TransportingOrderState());
        OutputManager.getInstance().print(
                "当前订单的状态为："+ order.getOrderState().getCNStateName(),
                "當前訂單的狀態為："+order.getOrderState().getTWStateName(),
                "The status of the current order is:"+order.getOrderState().getENStateName()
        );
        OutputManager.getInstance().print(
                "修改当前订单的状态为已交付状态。",
                "修改當前訂單的狀態為已交付狀態。",
                "Modify the status of the current order to be delivered."
        );
        order.changeOrderState(new DeliveredOrderState());
        OutputManager.getInstance().print(
                "当前订单的状态为："+ order.getOrderState().getCNStateName(),
                "當前訂單的狀態為："+order.getOrderState().getTWStateName(),
                "The status of the current order is:"+order.getOrderState().getENStateName()
        );
    }
}