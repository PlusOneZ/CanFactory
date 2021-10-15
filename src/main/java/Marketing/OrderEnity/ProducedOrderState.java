package Marketing.OrderEnity;

import Presentation.Protocol.OutputManager;

/**


import Presentation.Protocol.OutputManager;

/**
 * 订单已经完成生产的状态，称为：已生产
 * @author 梁乔
 * @date 2021/10/15 10:06 
 */
public class ProducedOrderState extends OrderState{
    @Override
    public boolean isProduced() {
        return true;
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
        OutputManager.getInstance().errorMassage(
                "订单号为"+order.getOrderId()+"的订单已经完成生产,无法再次生产！",
                "訂單號為"+order.getOrderId()+"的訂單已經完成生產,無法再次生產！",
                "The order with order ID"+order.getOrderId()+"has completed production,can not be produced again!"
        );
    }

    @Override
    public void handleTransportation(Order order) {
        OutputManager.getInstance().print(
                "订单号为"+order.getOrderId()+"的订单开始运输！",
                "訂單號為"+order.getOrderId()+"的訂單開始運輸！",
                "The order with order ID"+order.getOrderId()+"has began to be transported!"
        );
        changeOrderState(order,new TransportingOrderState());//修改相应的订单状态
    }

    @Override
    public void handleDelivery(Order order) {
        OutputManager.getInstance().print(
                "订单号为"+order.getOrderId()+"的订单还未开始运输，无法交付！",
                "訂單號為"+order.getOrderId()+"的訂單還未開始運輸，無法交付！",
                "The order with order ID"+order.getOrderId()+"has began to transported, can not be delivered!"
        );
    }

}