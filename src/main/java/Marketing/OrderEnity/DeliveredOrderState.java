package Marketing.OrderEnity;

import Presentation.Protocol.OutputManager;

/**


/**
 * 订单状态：已交付
 * @author 梁乔
 * @date 2021/10/15 10:36 
 */
public class DeliveredOrderState extends OrderState{
    @Override
    public boolean isProduced() {
        return true;
    }

    @Override
    public boolean isTransporting() {
        return true;
    }

    @Override
    public boolean isDelivered() {
        return true;
    }

    @Override
    public void handleProduction(Order order) {
        OutputManager.getInstance().errorMassage(
                "订单号为"+order.getOrderId()+"的订单已经交付,无法再次生产！",
                "訂單號為"+order.getOrderId()+"的訂單已經交付,無法再次生產！",
                "The order with order ID"+order.getOrderId()+"has been delivered,can not be produced again!"
        );
    }

    @Override
    public void handleTransportation(Order order) {
        OutputManager.getInstance().errorMassage(
                "订单号为"+order.getOrderId()+"的订单已经交付,无法再次运输！",
                "訂單號為"+order.getOrderId()+"的訂單已經交付,無法再次運輸！",
                "The order with order ID"+order.getOrderId()+"has been delivered,can not be transported again!"
        );
    }

    @Override
    public void handleDelivery(Order order) {
        OutputManager.getInstance().errorMassage(
                "订单号为"+order.getOrderId()+"的订单已经交付,无法再次交付！",
                "訂單號為"+order.getOrderId()+"的訂單已經交付,無法再次交付！",
                "The order with order ID"+order.getOrderId()+"has been delivered,can not be delivered again!"
        );
    }
}