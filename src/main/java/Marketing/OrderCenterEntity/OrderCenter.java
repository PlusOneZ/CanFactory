package Marketing.OrderCenterEntity;

import Marketing.Container;
import Marketing.Iterator;
import Marketing.OrderEnity.Order;
import Marketing.OrderEnity.OrderAmount;
import Marketing.OrderEnity.OrderCanInformation;
import Presentation.Protocol.OutputManager;

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

    }

    /**
    * 核心功能：创建一个新的订单
     * @param orderCanInformations : 订单的信息列表
     * @param orderAmount :订单价格
     * @param latestDeliveryTime :最晚交付时间
     * @return : void
    * @author 梁乔
    * @date 22:10 2021-10-15
    */
    public void createOneOrder(ArrayList<OrderCanInformation> orderCanInformations, OrderAmount orderAmount, Date latestDeliveryTime){
        Order order = new Order(orderCanInformations, orderAmount,latestDeliveryTime);
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
        OutputManager.getInstance().print(
                "订单中心的订单数据：" ,
                "訂單中心的訂單數據:",
                "Order data in the order center:"
        );
        OutputManager.getInstance().print(
                "订单数目："+factoryOrderList.size() ,
                "訂單數目："+factoryOrderList.size(),
                "Number of orders:"+factoryOrderList.size()
        );
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
                    "订单明细",
                    "訂單明細",
                    "Order Details"
            );
            //对于每个订单，分罐头类型的数量逐个迭代
            for(Iterator it = od.getIterator(); it.hasNext();){
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