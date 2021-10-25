package Marketing.OrderCenterEntity;

import Marketing.Container;
import Marketing.Iterator;
import Marketing.OrderEnity.*;
import Marketing.Promotion.Coupon;
import Presentation.Protocol.OutputManager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 订单中心，负责订单的CURD
 * 使用到了迭代器模式、单例模式
 * @author 梁乔
 * @date 2021/10/15 15:07 
 */
public class OrderCenter implements Container {

    //////////////////////////////////////////
    /**
     * 整个工厂的订单列表，需要实时维护
     */
    public ArrayList<Order> factoryOrderList;

    /**
     * 订单中心单例
     */
    private static OrderCenter orderCenterInstance = new OrderCenter();
    ///////////////////////////////////////////


    private OrderCenter(){
        factoryOrderList = new ArrayList<Order>();
    }

    /**
    * 核心功能：创建一个新的订单
     * @param orderCanInformations : 订单的信息列表
     * @param latestDeliveryTime :最晚交付时间
     * @return : void
    * @author 梁乔
    * @date 22:10 2021-10-15
    */
    public void createOneOrder(ArrayList<OrderCanInformation> orderCanInformations, Coupon coupon, Date latestDeliveryTime, String customerAddress){
        Order order = new Order(orderCanInformations,coupon, latestDeliveryTime, customerAddress);
        factoryOrderList.add(order);
    }

    /**
    *  获取订单中心单例
     * @return : Marketing.OrderCenterEntity.OrderCenter
    * @author 梁乔
    * @date 20:50 2021-10-15
    */
    public static OrderCenter getInstance(){
        return orderCenterInstance;
    }

    /**
    * 展示打印当前订单中心的订单数据
     * @return : void
    * @author 梁乔
    * @date 15:30 2021-10-15
    */
    public void displayOrderData(){
        System.out.println("-----------------------------------------");
        OutputManager.getInstance().print(
                "订单中心的订单数据：" ,
                "訂單中心的訂單數據:",
                "Order data in the order center:"
        );
        System.out.println("-----------------------------------------");
        OutputManager.getInstance().print(
                "订单中心使用到了单例模式，订单迭代使用了迭代器模式." ,
                "訂單中心使用到了單例模式，訂單迭代使用了迭代器模式.",
                "The order center uses the singleton mode, and the order iteration uses the iterator mode."
        );
        System.out.println("-----------------------------------------");
        OutputManager.getInstance().print(
                "订单数目："+factoryOrderList.size() ,
                "訂單數目："+factoryOrderList.size(),
                "Number of orders:"+factoryOrderList.size()
        );
        System.out.println("-----------------------------------------");
        //逐个订单迭代
        for(Iterator iter = this.getIterator(); iter.hasNext();){
            Order od = (Order)iter.next();//获取当前的订单
            OutputManager.getInstance().print(
                    "订单ID："+od.getOrderId(),
                    "訂單ID:"+od.getOrderId(),
                    "Order ID:"+od.getOrderId()
            );
            OutputManager.getInstance().print(
                    "订单状态："+od.getOrderState().getCNStateName(),
                    "訂單狀態:"+od.getOrderState().getTWStateName(),
                    "Order State:"+od.getOrderState().getENStateName()
            );
            OutputManager.getInstance().print(
                    "订单地址："+od.getCustomerAddress(),
                    "訂單地址"+od.getCustomerAddress(),
                    "Order Address:"+od.getCustomerAddress()
            );
            String placingTimeFormat = new String("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat sft = new SimpleDateFormat(placingTimeFormat);
            String placingTime = sft.format(od.getPlacingTime());
            OutputManager.getInstance().print(
                    "订单下单时间"+placingTime,
                    "訂單下單時間"+placingTime,
                    "The placing time of the order:"+placingTime
            );
            if(od.getOrderState().getCNStateName() == "运输中"){
                String sendingTime = sft.format(od.getSendingTime());
                OutputManager.getInstance().print(
                        "订单发货时间:"+sendingTime,
                        "訂單發貨時間:。"+sendingTime,
                        "The delivery time of the order:"+sendingTime
                );
            }
            else if(od.getOrderState().getCNStateName() == "已交付"){
                String deliverTime = sft.format(od.getCompletionTime());
                String sendingTime = sft.format(od.getSendingTime());
                OutputManager.getInstance().print(
                        "订单发货时间:"+sendingTime,
                        "訂單發貨時間:。"+sendingTime,
                        "The delivery time of the order:"+sendingTime
                );
                OutputManager.getInstance().print(
                        "订单交付时间:"+deliverTime,
                        "訂單交付時間:。"+deliverTime,
                        "The Completion time of the order:"+deliverTime
                );
            }
            System.out.println("--------------------------------------");
            OutputManager.getInstance().print(
                    "订单明细:",
                    "訂單明細:",
                    "Order Details:"
            );
            //对于每个订单，分罐头类型的数量逐个迭代
            for(Iterator it = od.getIterator(); it.hasNext();){
                System.out.println("--------------------------------------");
                //获取当前迭代订单的当前迭代的订单罐头信息
                OrderCanInformation oci = (OrderCanInformation)it.next();
                OutputManager.getInstance().print(
                        "罐头类型:"+oci.getCanName(),
                        "罐頭類型:"+oci.getCanName(),
                        "Type of Can:"+oci.getCanName()
                );
                OutputManager.getInstance().print(
                        "罐头数量："+oci.getCount(),
                        "罐頭數量:"+oci.getCount(),
                        "Can Amount:"+oci.getCount()
                );
                System.out.println("--------------------------------------");
            }

            OutputManager.getInstance().print(
                    "订单原始金额："+od.getOrderAmount().getOriginalAmount(),
                    "訂單原始金額："+od.getOrderAmount().getOriginalAmount(),
                    "The Original price of the order:"+od.getOrderAmount().getOriginalAmount()
            );
            OutputManager.getInstance().print(
                    "订单的促销金额："+od.getOrderAmount().getPromotionAmount(),
                    "訂單的促銷金額："+od.getOrderAmount().getPromotionAmount(),
                    "The promotion price of the order:"+od.getOrderAmount().getPromotionAmount()
            );

            OutputManager.getInstance().print(
                    "订单的运输费用："+od.getOrderAmount().getTransportationAmount(),
                    "訂單的運輸費用"+od.getOrderAmount().getTransportationAmount(),
                    "The Transportation price of the order:"+od.getOrderAmount().getTransportationAmount()
            );
        }
    }


    public  ArrayList<Order> getPendingOrders(){
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
    public  Order orderExists(Long orderId){
        for (Iterator it = getIterator(); it.hasNext();) {
            Order itOrder = (Order) it.next();
            if (itOrder.getOrderId() == orderId) {
                return itOrder;
            }
        }
        return null;
    }

    public boolean completeProductionOfOneOrder(Long orderId){
        //获取当前订单Id的订单对象
        Order order = orderExists(orderId);
        //如果当前订单ID的订单存在
        if(order != null) {
            if (order.getOrderState().getCNStateName() == "已下单") {
                //修改订单的状态为已生产状态
                order.changeOrderState(new ProducedOrderState());
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




    public boolean startToTransportOneOrder(Long orderId){
        //获取当前订单Id的订单对象
        Order order = orderExists(orderId);


        //如果当前订单ID的订单存在
        if(order != null) {
            if (order.getOrderState().getCNStateName() == "已生产") {
                //设置运输时间
                order.setSendingTime(new Date());
                //修改订单的状态为运输中状态
                order.changeOrderState(new TransportingOrderState());
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

    public boolean deliverOneOrder(Long orderId){
        //获取当前订单Id的订单对象
        Order order = orderExists(orderId);
        //如果当前订单ID的订单存在
        if(order != null) {
            if (order.getOrderState().getCNStateName() == "已交付") {
                //设置交付的时间
                order.setCompletionTime(new Date());
                //修改订单的状态为交付状态
                order.changeOrderState(new DeliveredOrderState());
                OutputManager.getInstance().print(
                        "订单ID为" + orderId + "的订单已成功交付！",
                        "訂單ID為" + orderId + "的訂單已成功開始交付！",
                        "The order with order ID" + orderId + "has been delivered!"
                );
                return true;
            } else {
                OutputManager.getInstance().errorMassage(
                        "该状态下无法进行交付！",
                        "該狀態下無法進行交付  ！",
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
    * 获取订单中心的迭代器，实例化一个订单迭代器
     * @return : Marketing.Iterator
    * @author 梁乔
    * @date 15:17 2021-10-15
    */
    @Override
    public Iterator getIterator() {
        return new OrderIterator();
        //此时新的迭代器index默认初始化为0
    }

    /**
    * Nested class 订单迭代器，用于订单的遍历和查找
    * @author 梁乔
    * @date 2021-10-15 15:17
    */
    private class OrderIterator implements Iterator{

        int index;

        /**
        * 当前index是否有下一个元素
         * @return : boolean
        * @author 梁乔
        * @date 15:18 2021-10-15
        */
        @Override
        public boolean hasNext() {
            if(index < factoryOrderList.size())
                return true;
            return false;
        }

        /**
        * 获取迭代器的下一个元素
         * @return : java.lang.Object
        * @author 梁乔
        * @date 15:26 2021-10-15
        */
        @Override
        public Object next() {
            if(this.hasNext()){
                return factoryOrderList.get(index++);
            }
            return null;
        }
    }
}