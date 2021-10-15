package Marketing.OrderEnity;/**

/**
 * 订单的状态，抽象类
 * 实现了State pattern
 * @author 梁乔
 * @since 2021/10/15 9:21
 */
public abstract class OrderState {

    /**
    * 该订单是否被生产
     * @return : 是否被生产
    * @author 梁乔
    * @date 9:26 2021-10-15
    */
    public abstract boolean isProduced();

    /**
    * 该订单是否开始被运输
     * @return : 是否开始被运输
    * @author  梁乔
    * @date 9:28 2021-10-15
    */
    public abstract boolean isTransporting();

    /**
    * 该订单那是否交付
     * @return : boolean
    * @author 梁乔
    * @date 9:31 2021-10-15
    */
    public abstract boolean isDelivered();

    /**
    * 当订单被生产完毕时，对状态调用此函数，改变相应的状态实例
     * @return : Marketing.OrderEnity.OrderState
    * @author 梁乔
    * @date 9:30 2021-10-15
    */
    public abstract void handleProduction(Order order);

    /**
    * 当订单开始被运输时，对状态调用此函数，改变相应的状态实例
     * @return : Marketing.OrderEnity.OrderState
    * @author 梁乔
    * @date 9:33 2021-10-15
    */
    public abstract void handleTransportation(Order order);

    /**
    * 当订单运输完成时，对状态调用此函数，改变相应的状实例
     * @return : Marketing.OrderEnity.OrderState
    * @author 梁乔
    * @date 9:34 2021-10-15
    */
    public abstract void handleDelivery(Order order);

    /**
    * 修改某个订单的订单状态为指定的状态
     * @param order :要修改状态的订单
     * @param orderState :目标的订单状态
     * @return : void
    * @author 梁乔
    * @date 10:24 2021-10-15
    */
    public void changeOrderState(Order order,OrderState orderState){
        order.changeOrderState(orderState);
    };
}