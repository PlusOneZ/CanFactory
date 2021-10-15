package Marketing.OrderEnity;

import Presentation.Protocol.OutputManager;

/**
 * 订单状态：已下单，表示刚下单，未生产，未运输，未交付
 * @author 梁乔
 * @date 2021/10/15 9:36 
 */
public class OrderedOrderState extends OrderState{

    @Override
    public boolean isProduced() {
        return false;
    }

    @Override
    public boolean isTransporting() {
        return false;
    }

    @Override
    public boolean isDelivered() {
        return false;
    }

    @Override
    public void handleProduction(Order order) {
        OutputManager.getInstance().print(
                "订单号为"+order.getOrderId()+"的订单已经完成生产！",
                "訂單號為"+order.getOrderId()+"的訂單已經完成生產！",
                "The order with order ID"+order.getOrderId()+"has completed production!"
        );
        changeOrderState(order,new ProducedOrderState());
    }

    @Override
    public void handleTransportation(Order order) {
    OutputManager.getInstance().errorMassage(
            "订单号为"+order.getOrderId()+"的订单还未完成生产，无法运输！",
            "訂單號為"+order.getOrderId()+"的訂單還未完成生產，無法運輸！",
            "The order with order ID"+order.getOrderId()+"has not completed production,can not be delivered!"
    );
    }

    @Override
    public void handleDelivery(Order order) {
    OutputManager.getInstance().errorMassage(
            "订单号为"+order.getOrderId()+"的订单还未生产，无法完成运输！",
            "訂單號為"+order.getOrderId()+"的訂單還未生產，無法完成運輸！",
            "The order with order ID"+order.getOrderId()+"has not completed production,can not complete delivery!"
    );
    }



}