package Marketing.OrderCenterEntity;

import Marketing.Iterator;
import Marketing.OrderEnity.DeliveredOrderState;
import Marketing.OrderEnity.Order;
import Presentation.Protocol.OutputManager;

import java.util.ArrayList;

/**


/**
 * 订单处理中心，作为订单中心和外界库存中心，
 * 运输中心交互的媒介，使用了中介者模式(Mediator)
 * 将对象间调用的网状关系转化为星型关系
 * @author 梁乔
 * @date 2021/10/16 15:48 
 */
public class OrderProcessingCenter {

    /**
    * 获取订单中心待处理（已下单状态）的订单列表，方便运输中心调用
     * @return : java.util.ArrayList<Marketing.OrderEnity.Order>
    * @author 梁乔
    * @date 16:04 2021-10-16
    */
    public static ArrayList<Order> getPendingOrders(){
        ArrayList<Order> pendingOrder = new ArrayList<Order>();
        //使用迭代器循环迭代待处理的订单
        for(Iterator it = OrderCenter.getInstance().getIterator(); it.hasNext();){
            Order itOrder = (Order)it.next();
            //如果当前迭代的订单的订单状态为已下单待生产的状态，则加入到列表中
            if(itOrder.getOrderState().getCNStateName() == "已下单"){
                pendingOrder.add(itOrder);
            }
        }
       return pendingOrder;
    }

    /**
    * 搜索订单中心的某一订单
     * @param orderId : 订单ID
     * @return : Marketing.OrderEnity.Order
    * @author 梁乔
    * @date 20:23 2021-10-16
    */
    public static Order orderExists(Long orderId){
        for (Iterator it = OrderCenter.getInstance().getIterator(); it.hasNext();) {
            Order itOrder = (Order) it.next();
            if (itOrder.getOrderId() == orderId) {
                return itOrder;
            }
        }
        return null;
    }

    /**
    * 交付一个订单，由运输中心调用，当订单运输完成并交付后，才能调用
     * @param orderId : 要交付的订单ID
     * @return : boolean，是否交付成功
    * @author ；梁乔
    * @date 16:05 2021-10-16
    */
    public static boolean deliverOneOrder(Long orderId) {
        //获取当前订单Id的订单对象
        Order order = orderExists(orderId);
        //如果当前订单ID的订单存在
        if(order != null) {
            if (order.getOrderState().getCNStateName() == "运输中") {
                //修改订单的状态为已交付状态
                order.changeOrderState(new DeliveredOrderState());
                OutputManager.getInstance().print(
                        "订单ID为" + orderId + "的订单已成功交付！",
                        "訂單ID為" + orderId + "的訂單已成功交付！",
                        "The order with order ID" + orderId + "has been delivered!"
                );
                return true;
            } else {
                OutputManager.getInstance().errorMassage(
                        "该状态下无法进行交付！",
                        "該狀態下無法進行交付！",
                        "Delivery is not possible in this state!"
                );
            }
        }
        else {
                OutputManager.getInstance().errorMassage(
                        "订单中心无此订单!",
                        "訂單中心無此訂單!",
                        "There is no such order in the order center!"
                );
            }
        return false;
    }

    /**
    * 完成一个订单的生产
     * @param orderId :订单ID
     * @return : boolean
    * @author 梁乔
    * @date 20:27 2021-10-16
    */
    public static boolean completeProductionOfOneOrder(Long orderId){
        //获取当前订单Id的订单对象
        Order order = orderExists(orderId);
        //如果当前订单ID的订单存在
        if(order != null) {
            if (order.getOrderState().getCNStateName() == "已下单") {
                //修改订单的状态为已生产状态
                order.changeOrderState(new DeliveredOrderState());
                OutputManager.getInstance().print(
                        "订单ID为" + orderId + "的订单已成功生产！",
                        "訂單ID為" + orderId + "的訂單已成功生產！",
                        "The order with order ID" + orderId + "has been produced!"
                );
                return true;
            } else {
                OutputManager.getInstance().errorMassage(
                        "该状态下无法进行生产！",
                        "該狀態下無法進行生产！",
                        "Production is not possible in this state!"
                );
            }
        }
        else {
            OutputManager.getInstance().errorMassage(
                    "订单中心无此订单!",
                    "訂單中心無此訂單!",
                    "There is no such order in the order center!"
            );
        }
        return false;
    }

    public static boolean startToTransportOneOrder(Long orderId){
        //获取当前订单Id的订单对象
        Order order = orderExists(orderId);
        //如果当前订单ID的订单存在
        if(order != null) {
            if (order.getOrderState().getCNStateName() == "已生产") {
                //修改订单的状态为运输中状态
                order.changeOrderState(new DeliveredOrderState());
                OutputManager.getInstance().print(
                        "订单ID为" + orderId + "的订单已成功开始运输！",
                        "訂單ID為" + orderId + "的訂單已成功開始運輸！",
                        "The order with order ID" + orderId + "has been starting to transport!"
                );
                return true;
            } else {
                OutputManager.getInstance().errorMassage(
                        "该状态下无法进行运输！",
                        "該狀態下無法進行运输  ！",
                        "Transportation is not possible in this state!"
                );
            }
        }
        else {
            OutputManager.getInstance().errorMassage(
                    "订单中心无此订单!",
                    "訂單中心無此訂單!",
                    "There is no such order in the order center!"
            );
        }
        return false;
    }

    
}