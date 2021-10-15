package Marketing.OrderEntity;


import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * @Author 王立友
 * 订单实体类，包含订单信息
 */

public class Order{

    //罐头信息列表
    private ArrayList<OrderCanInformation> orderCanInformations;

    //订单金额
    private OrderAmount orderAmount;

    //订单状态

    //订单下单时间
    private LocalDateTime placingTime;

    //订单发货时间
    private LocalDateTime deliveryTime;

    //订单交付完成时间
    private LocalDateTime completionTime;

    public Order(ArrayList<OrderCanInformation> orderCanInformations, OrderAmount orderAmount){
        this.orderCanInformations = orderCanInformations;
        this.orderAmount = orderAmount;
        this.placingTime = LocalDateTime.now();
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public void setCompletionTime(LocalDateTime completionTime) {
        this.completionTime = completionTime;
    }
}
