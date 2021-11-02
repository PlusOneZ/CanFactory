package Marketing.OrderEnity;

import Presentation.Protocol.IOManager;

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
        IOManager.getInstance().print(
                "订单号为"+order.getOrderId()+"的订单已经完成生产！",
                "訂單號為"+order.getOrderId()+"的訂單已經完成生產！",
                "The order with order ID"+order.getOrderId()+"has completed production!"
        );
        changeOrderState(order,new ProducedOrderState());
    }

    @Override
    public void handleTransportation(Order order) {
    IOManager.getInstance().errorMassage(
            "订单号为"+order.getOrderId()+"的订单还未完成生产，无法运输！",
            "訂單號為"+order.getOrderId()+"的訂單還未完成生產，無法運輸！",
            "The order with order ID"+order.getOrderId()+"has not completed production,can not be delivered!"
    );
    }

    @Override
    public void handleDelivery(Order order) {
    IOManager.getInstance().errorMassage(
            "订单号为"+order.getOrderId()+"的订单还未生产，无法完成运输！",
            "訂單號為"+order.getOrderId()+"的訂單還未生產，無法完成運輸！",
            "The order with order ID"+order.getOrderId()+"has not completed production,can not complete delivery!"
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
        return "已下单";
    }

    /**
     *  获取订单状态的繁体名称
     * @return : java.lang.String
     * @author 梁乔
     * @date 21:11 2021-10-15
     */
    @Override
    public String getTWStateName(){
        return "已下單";
    }

    /**
     * 获取订单状态的英文名称
     * @return : java.lang.String
     * @author 梁乔
     * @date 21:37 2021-10-15
     */
    @Override
    public String getENStateName(){
        return "Ordered";
    }


}