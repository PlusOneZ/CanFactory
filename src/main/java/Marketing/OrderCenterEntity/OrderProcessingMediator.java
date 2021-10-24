package Marketing.OrderCenterEntity;

import Marketing.Iterator;
import Marketing.OrderEnity.DeliveredOrderState;
import Marketing.OrderEnity.Order;
import Presentation.Protocol.OutputManager;

import java.util.ArrayList;

/**


/**
 * 订单处理中心中介者，作为订单中心和外界库存中心，
 * 运输中心交互的媒介，使用了中介者模式(Mediator)
 * 将对象间调用的网状关系转化为星型关系
 * 订单处理中介者本身是单例
 * @author 梁乔
 * @date 2021/10/16 15:48 
 */
public class OrderProcessingMediator {


    OrderCenter orderCenter = OrderCenter.getInstance();

    private static OrderProcessingMediator orderProcessingMediator = new OrderProcessingMediator();

    private OrderProcessingMediator(){

    }

    public static OrderProcessingMediator getInstance(){
        return orderProcessingMediator;
    }


    /**
    * 委托中介者来获取待处理（已下单状态）的订单列表，方便运输中心调用
     * @return : java.util.ArrayList<Marketing.OrderEnity.Order>
    * @author 梁乔
    * @date 11:17 2021-10-24
    */
    public ArrayList<Order> getPendingOrders(){
        return orderCenter.getPendingOrders();
    }

    /**
    * 按照订单id搜索某一订单
     * @param OrderId : 要搜索的订单id
     * @return : Marketing.OrderEnity.Order
    * @author
    * @date 14:45 2021-10-24
    */
    public Order orderExists(Long OrderId){
        return orderCenter.orderExists(OrderId);
    }


    /**
    * 完成一个订单的生产
     * @param orderId :订单ID
     * @return : boolean
    * @author 梁乔
    * @date 20:27 2021-10-16
    */
    public boolean completeProductionOfOneOrder(Long orderId){
        return orderCenter.completeProductionOfOneOrder(orderId);
    }


    /**
    * 开始运输某一订单
     * @param orderId :订单ID
     * @return : boolean
    * @author 梁乔
    * @date 14:51 2021-10-24
    */
    public boolean startToTransportOneOrder(Long orderId){
        return orderCenter.startToTransportOneOrder(orderId);
    }

    /**
    * 交付一个订单
     * @param orderId : 订单ID
     * @return : boolean
    * @author 梁乔
    * @date 15:02 2021-10-24
    */
    public boolean deliverOneOrder(Long orderId){
        return orderCenter.deliverOneOrder(orderId);
    }



}