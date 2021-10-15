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

    /**
    * 获取订单状态的中文名称
     * @return : java.lang.String
    * @author 梁乔
    * @date 21:10 2021-10-15
    */
    @Override
    public String getCNStateName(){
        return "已交付";
    }

    /**
    *  获取订单状态的繁体名称
     * @return : java.lang.String
    * @author 梁乔
    * @date 21:11 2021-10-15
    */
    @Override
    public String getTWStateName(){
        return "已交付";
    }

    /**
    * 获取订单状态的英文名称
     * @return : java.lang.String
    * @author 梁乔
    * @date 21:37 2021-10-15
    */
    @Override
    public String getENStateName(){
        return "Delivered";
    }

}