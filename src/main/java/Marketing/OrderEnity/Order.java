package Marketing.OrderEnity;

import Manufacturing.CanEntity.Can;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * 订单类，泛型标识对应的罐头种类
 * @author 梁乔 2021/10/10
 **/
public class Order {

    /**
     * 订单ID
     */
    private Long orderId;

    /**
     * 订单的状态
     */
    private OrderState orderState;

    /**
    * 获取订单状态
     * @return : Marketing.OrderEnity.OrderState
    * @author 梁乔
    * @date 11:10 2021-10-15
    */
    public OrderState getOrderState(){
        return orderState;
    }

    //罐头信息列表
    private ArrayList<OrderCanInformation> orderCanInformations;

    //订单金额
    private OrderAmount orderAmount;

    //订单下单时间
    private LocalDateTime placingTime;

    //订单发货时间
    private LocalDateTime sendingTime;

    //订单交付完成时间
    private LocalDateTime completionTime;

    //订单最晚交付时间
    private Date latestDeliveryTime;

    /**
    * 订单构造函数，传入订单罐头信息和订单价格
     * @param orderCanInformations :订单罐头信息
     * @param orderAmount : 订单价格
     * @return : null
    * @author 王立友
    * @date 11:24 2021-10-15
    */
    public Order(ArrayList<OrderCanInformation> orderCanInformations, OrderAmount orderAmount, Date latestDeliveryTime){
        this.orderCanInformations = orderCanInformations;
        this.orderAmount = orderAmount;
        this.placingTime = LocalDateTime.now();
        this.latestDeliveryTime = latestDeliveryTime;
        orderState = new OrderedOrderState();
        orderId = OrderIdGenerator.getGeneratID();
        //生成与订单生成时间相关的随机且唯一ID标识
    }

    /**
    * 设置发货时间
     * @param sendingTime : 发货时间
     * @return : void
    * @author 王立友
    * @date 11:25 2021-10-15
    */
    public void setDeliveryTime(LocalDateTime sendingTime) {
        this.sendingTime = sendingTime;
    }

    /**
    * 设置订单的完成时间
     * @param completionTime :订单完成时间
     * @return : void
    * @author
    * @date 11:26 2021-10-15
    */
    public void setCompletionTime(LocalDateTime completionTime) {
        this.completionTime = completionTime;
    }

    /**
     * 获取当前订单ID
     * @return : java.lang.Long
     * @author 梁乔
     * @date 11:09 2021-10-15
     */
    public Long getOrderId(){
        return orderId;
    }

    /**
     * 修改当前的订单状态，由订单状态类来调用
     * @param orderState : 目标订单状态
     * @return : void
     * @author 梁乔
     * @date 11:09 2021-10-15
     */
    public void changeOrderState(OrderState orderState){
        this.orderState = orderState;
    }

}
