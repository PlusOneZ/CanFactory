package
        Storage.InventoryConverter;

import Marketing.OrderEnity.Order;
import Storage.TransportationCan;

import java.util.function.Function;

/**
 * 此类为order转化为运输罐头的一个转换器
 * 即再库存充足的情况下可以将订单转为订单货物，然后备好后准备发货
 * 转换器模式
 * @author 王立友
 * @date 2021/10/17 16:41
 */
public class OrderToTransportationCanConverter {

    Function<Order, TransportationCan> fromOrderFunction;

    public OrderToTransportationCanConverter(){
        fromOrderFunction = new Function<Order, TransportationCan>() {
            @Override
            /**
             * 信息的转换;
             * @param order :
             * @return : Storage.TransportationCan
             * @author "王立友"
             * @date 2021-10-17 16:50
             */
            public TransportationCan apply(Order order) {
                return new TransportationCan(order.getLatestDeliveryTime(),order.getCustomerAddress(), order.getOrderId());
            }
        };
    }

    public Function<Order, TransportationCan> getFromOrderFunction() {
        return fromOrderFunction;
    }
}