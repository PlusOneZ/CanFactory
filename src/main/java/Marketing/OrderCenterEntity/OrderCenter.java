package Marketing.OrderCenterEntity;

import Manufacturing.CanEntity.CanInfoController;
import Marketing.Container;
import Marketing.Iterator;
import Marketing.OrderEnity.*;
import Marketing.Promotion.Coupon;
import Presentation.Protocol.IOManager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

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
        IOManager.getInstance().printLanguageIrrelevantContent("-----------------------------------------");
        IOManager.getInstance().print(
                "订单中心的订单数据：" ,
                "訂單中心的訂單數據:",
                "Order data in the order center:"
        );
        IOManager.getInstance().print(
                "订单中心使用到了单例模式，订单迭代使用了迭代器模式." ,
                "訂單中心使用到了單例模式，訂單迭代使用了迭代器模式.",
                "The order center uses the singleton mode, and the order iteration uses the iterator mode."
        );
        IOManager.getInstance().print(
                "订单数目："+factoryOrderList.size() ,
                "訂單數目："+factoryOrderList.size(),
                "Number of orders:"+factoryOrderList.size()
        );
        IOManager.getInstance().printLanguageIrrelevantContent("-----------------------------------------");
        //逐个订单迭代
        for(Iterator iter = this.getIterator(); iter.hasNext();){
            Order od = (Order)iter.next();//获取当前的订单
            IOManager.getInstance().print(
                    "订单ID："+od.getOrderId(),
                    "訂單ID:"+od.getOrderId(),
                    "Order ID:"+od.getOrderId()
            );
            IOManager.getInstance().print(
                    "订单状态："+od.getOrderState().getCNStateName(),
                    "訂單狀態:"+od.getOrderState().getTWStateName(),
                    "Order State:"+od.getOrderState().getENStateName()
            );
            IOManager.getInstance().print(
                    "订单地址："+od.getCustomerAddress(),
                    "訂單地址"+od.getCustomerAddress(),
                    "Order Address:"+od.getCustomerAddress()
            );
            String placingTimeFormat = new String("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat sft = new SimpleDateFormat(placingTimeFormat);
            String placingTime = sft.format(od.getPlacingTime());
            IOManager.getInstance().print(
                    "订单下单时间"+placingTime,
                    "訂單下單時間"+placingTime,
                    "The placing time of the order:"+placingTime
            );
            String latestDeliveryTimeFormat = new String("yyyy-MM-dd");
            SimpleDateFormat ldtf = new SimpleDateFormat(latestDeliveryTimeFormat);
            String latestDeliveryTime = ldtf.format(od.getLatestDeliveryTime());
            IOManager.getInstance().print(
                    "订单的最晚交付时间为："+latestDeliveryTime,
                    "訂單的最晚交付時間為："+latestDeliveryTime,
                    "The latest delivery time of the order is:"+latestDeliveryTime
            );
            if(Objects.equals(od.getOrderState().getCNStateName(), "运输中")){
                String sendingTime = sft.format(od.getSendingTime());
                IOManager.getInstance().print(
                        "订单发货时间:"+sendingTime,
                        "訂單發貨時間:。"+sendingTime,
                        "The delivery time of the order:"+sendingTime
                );
            }
            else if(Objects.equals(od.getOrderState().getCNStateName(), "已交付")){
                String deliverTime = sft.format(od.getCompletionTime());
                String sendingTime = sft.format(od.getSendingTime());
                IOManager.getInstance().print(
                        "订单发货时间:"+sendingTime,
                        "訂單發貨時間:。"+sendingTime,
                        "The delivery time of the order:"+sendingTime
                );
                IOManager.getInstance().print(
                        "订单交付时间:"+deliverTime,
                        "訂單交付時間:。"+deliverTime,
                        "The Completion time of the order:"+deliverTime
                );
            }
            IOManager.getInstance().print(
                    "订单明细:",
                    "訂單明細:",
                    "Order Details:"
            );
            //对于每个订单，分罐头类型的数量逐个迭代
            for(Iterator it = od.getIterator(); it.hasNext();){
                //获取当前迭代订单的当前迭代的订单罐头信息
                OrderCanInformation oci = (OrderCanInformation)it.next();
                IOManager.getInstance().print(
                        "罐头类型:"+oci.getCanName(),
                        "罐頭類型:"+oci.getCanName(),
                        "Type of Can:"+oci.getCanName()
                );
                IOManager.getInstance().print(
                        "罐头数量："+oci.getCount(),
                        "罐頭數量:"+oci.getCount(),
                        "Can Amount:"+oci.getCount()
                );
            }

            IOManager.getInstance().print(
                    "订单原始金额："+od.getOrderAmount().getOriginalAmount(),
                    "訂單原始金額："+od.getOrderAmount().getOriginalAmount(),
                    "The Original price of the order:"+od.getOrderAmount().getOriginalAmount()
            );
            IOManager.getInstance().print(
                    "订单的促销金额："+od.getOrderAmount().getPromotionAmount(),
                    "訂單的促銷金額："+od.getOrderAmount().getPromotionAmount(),
                    "The promotion price of the order:"+od.getOrderAmount().getPromotionAmount()
            );

            IOManager.getInstance().print(
                    "订单的运输费用："+od.getOrderAmount().getTransportationAmount(),
                    "訂單的運輸費用"+od.getOrderAmount().getTransportationAmount(),
                    "The Transportation price of the order:"+od.getOrderAmount().getTransportationAmount()
            );
            IOManager.getInstance().printLanguageIrrelevantContent("--------------------------------------");
        }
    }


    public  ArrayList<Order> getPendingOrders(){
        ArrayList<Order> pendingOrder = new ArrayList<Order>();
        //使用迭代器循环迭代待处理的订单
        for(Iterator it = OrderCenter.getInstance().getIterator(); it.hasNext();){
            Order itOrder = (Order)it.next();
            //如果当前迭代的订单的订单状态为已下单待生产的状态，则加入到列表中
            if(Objects.equals(itOrder.getOrderState().getCNStateName(), "已下单")){
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
            if (Objects.equals(itOrder.getOrderId(), orderId)) {
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
            if (Objects.equals(order.getOrderState().getCNStateName(), "已下单")) {
                //修改订单的状态为已生产状态
                order.changeOrderState(new ProducedOrderState());
                IOManager.getInstance().print(
                        "订单ID为" + orderId + "的订单已成功生产！",
                        "訂單ID為" + orderId + "的訂單已成功生產！",
                        "The order with order ID" + orderId + "has been produced!"
                );
                return true;
            } else {
                IOManager.getInstance().errorMassage(
                        "该状态下无法进行生产！",
                        "該狀態下無法進行生产！",
                        "Production is not possible in this state!"
                );
            }
        }
        else {
            IOManager.getInstance().errorMassage(
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
            if (Objects.equals(order.getOrderState().getCNStateName(), "已生产")) {
                //设置运输时间
                order.setSendingTime(new Date());
                //修改订单的状态为运输中状态
                order.changeOrderState(new TransportingOrderState());
                IOManager.getInstance().print(
                        "订单ID为" + orderId + "的订单已成功开始运输！",
                        "訂單ID為" + orderId + "的訂單已成功開始運輸！",
                        "The order with order ID" + orderId + "has been starting to transport!"
                );
                return true;
            } else {
                IOManager.getInstance().errorMassage(
                        "该状态下无法进行运输！",
                        "該狀態下無法進行运输  ！",
                        "Transportation is not possible in this state!"
                );
            }
        }
        else {
            IOManager.getInstance().errorMassage(
                    "订单中心无此订单!",
                    "訂單中心無此訂單!",
                    "There is no such order in the order center!"
            );
        }
        return false;
    }

    public void outputReceipt(){
        for(Iterator iter = this.getIterator(); iter.hasNext();) {
            Order od = (Order)iter.next();
            IOManager.getInstance().print(
                    "您的订单小票",
                    "您的訂單小票",
                    "Your order receipt"
            );
            String header = "**********************************************";
            IOManager.getInstance().printLanguageIrrelevantContent(header);
            IOManager.getInstance().printLanguageIrrelevantContent("*                                            *");
            IOManager.getInstance().printLanguageIrrelevantContent("*                                            *");
            IOManager.getInstance().print(
                    "*                 订单消费小票                 *",
                    "*                 訂單消費小票                 *",
                    "*           Order consumption receipt        *"
            );
            /**
             * **********************************************
             * *                                            *
             * *                 订单消费小票                 *
             * *                 订单消费小票                 *
             * *--------------------------------------------*
             * *                  罐头加工厂                  *
             * *                 Can factory                    *
             * *                   结账单                    *
             * *                 Check out                      *
             * * 订单号：11010116969                          *
             * * OrderId:11010116969                        *
             * * 订单生成时间：Mon Nov 01 14:47:22 CST 2021    *
             * * Generation Time:Mon Nov 01 14:47:22 CST 2021*
             * *=============================================*
             * * 罐头名称       数量       单价      小计       *
             * *                                            *
             * *=============================================*
             * * 本订单使用八折优惠                             *
             * * This order uses a 20% discount              *
             * * 本订单使用满一百减二十优惠                      *
             * * This order uses 100 minus 20 discounts      *
             * * 本订单没有使用优惠                             *
             * * No discount is used for this order          *
             * * 合计                                        *
             * * Total                                       *
             * *                                             *
             * * 最晚交付时间：2022-02-02                      *
             * * Latest deliver time:2022-02-02              *
             * *                欢迎下次光临                   *
             * *                歡迎下次光臨                   *
             * *             Welcome next time               *
             **/
            IOManager.getInstance().printLanguageIrrelevantContent("*--------------------------------------------*");

            IOManager.getInstance().print(
                    "*                  罐头加工厂                  *",
                    "*                  罐頭加工廠                  *",
                    "*                 Can factory                 *"
            );
            IOManager.getInstance().print(
                    "*                   结账单                    *",
                    "*                   結賬單                    *",
                    "*                 Check out                  *"
            );
            IOManager.getInstance().printLanguageIrrelevantContent("*--------------------------------------------*");
            IOManager.getInstance().print(
                    "* 订单号：" + od.getOrderId()+"                         *",
                    "* 訂單號："+ od.getOrderId()+"                          *",
                    "* OrderId"+od.getOrderId()+"                        *"
            );
            IOManager.getInstance().print(
                    "* 订单生成时间："+od.getPlacingTime()+"   *",
                    "* 訂單生成時間："+od.getPlacingTime()+"   *",
                    "*Generation time:"+od.getPlacingTime()+"*"
            );
            IOManager.getInstance().printLanguageIrrelevantContent("*============================================*");
            IOManager.getInstance().print(
                    "* 罐头名称       数量       单价      小计       *",
                    "* 罐頭名稱       數量       單價      小計       *",
                    "* CanName       Num       Price    Total      *"
            );
            for(Iterator it = od.getIterator(); it.hasNext();){
                OrderCanInformation oci = (OrderCanInformation)it.next();
                String canNameStr = oci.getCanName();
                int lengOne = canNameStr.length();
                String regex = "^[a-zA-Z]+$";
                String numStr = String.valueOf(oci.getCount());
                int lengTwo = numStr.length();
                //获取罐头的单价
                double numPrice = CanInfoController.getInstance().getCanPriceByName(oci.getCanName());
                double totalPrice = numPrice * oci.getCount();//商品总价
                String numTotalOfStr = String.valueOf(totalPrice);
                numTotalOfStr = String.format("%.1f",totalPrice);
                String numPriceOfStr = String.format("%.1f",numPrice);
                int lengThree = numPriceOfStr.length();
                int lengFour = numTotalOfStr.length();
                if(oci.getCanName().matches(regex)){//如果当前名字为英文
                    for(int i = 0; i<(14-lengOne); i++){
                        canNameStr += " ";
                    }
                }
                else {
                    for(int i = 0; i<(int)(14-1.65*lengOne); i++){
                        canNameStr += " ";
                    }
                }
                for(int i = 0;i<(10-lengTwo);i++){
                    numStr += " ";
                }
                for(int i=0;i<(9-lengThree);i++){
                    numPriceOfStr += " ";
                }
                for(int i=0; i<(10-lengFour);i++){
                    numTotalOfStr += " ";
                }
                IOManager.getInstance().print(
                        "* "+canNameStr+numStr+numPriceOfStr+numTotalOfStr+"*",
                        "* "+canNameStr+numStr+numPriceOfStr+numTotalOfStr+"*",
                        "* "+canNameStr+numStr+numPriceOfStr+numTotalOfStr+"*"
                );
            }

            IOManager.getInstance().printLanguageIrrelevantContent("*============================================*");
            if(od.getCouponFlag() == 1) {
                IOManager.getInstance().print(
                        "* 本订单使用八折优惠                            *",
                        "* 本訂單使用八折優惠                            *",
                        "* This order uses a 20% discount              *"
                );
            }
            else if(od.getCouponFlag() == 0){
                IOManager.getInstance().print(
                        "* 本订单使用满一百减二十优惠                      *",
                        "* 本訂單使用滿一百減二十優惠                      *",
                        "* This order uses 100 minus 20 discounts      *"
                );
            }
            else
            {
                IOManager.getInstance().print(
                        "* 本订单没有使用优惠                             *",
                        "* 本訂單沒有使用優惠                             *",
                        "* No discount is used for this order          *"
                );
            }
            IOManager.getInstance().printLanguageIrrelevantContent("*--------------------------------------------*");
            IOManager.getInstance().print(
                    "* 合计                                        *",
                    "* 合計                                        *",
                    "* Total                                       *"
            );
            double TotalCount = od.getOrderAmount().getPromotionAmount();
            String totalCountOfStr = String.format("%.1f",TotalCount);
            int totalNum = totalCountOfStr.length();
            for(int i =0; i<(43-totalNum);i++){
                totalCountOfStr += " ";
            }
            IOManager.getInstance().print(
                    "* "+totalCountOfStr+"*",
                    "* "+totalCountOfStr+"*",
                    "* "+totalCountOfStr+"*"
                    );
            IOManager.getInstance().printLanguageIrrelevantContent("*--------------------------------------------*");
            //订单的最晚交付时间：
            String dateStr = "yyyy-MM-dd";
            SimpleDateFormat sdf = new SimpleDateFormat(dateStr);
            String latestDeliverTime = sdf.format(od.getLatestDeliveryTime());
            IOManager.getInstance().print(
                    "* 订单最晚交付时间："+latestDeliverTime+"                  *",
                    "* 訂單最晚交付時間："+latestDeliverTime+"                  *",
                    "* latest deliver time:"+latestDeliverTime+"             *"
            );
            IOManager.getInstance().print(
                    "*                欢迎下次光临                  *",
                    "*                歡迎下次光臨                  *",
                    "*             Welcome next time              *"
            );
            IOManager.getInstance().printLanguageIrrelevantContent("*                                            *");
            IOManager.getInstance().printLanguageIrrelevantContent("*                                            *");
            IOManager.getInstance().printLanguageIrrelevantContent(header);
        }
    }

    public boolean deliverOneOrder(Long orderId){
        //获取当前订单Id的订单对象                                  
        Order order = orderExists(orderId);
        //如果当前订单ID的订单存在
        if(order != null) {
            if (Objects.equals(order.getOrderState().getCNStateName(), "运输中")) {
                //设置交付的时间
                order.setCompletionTime(new Date());
                //修改订单的状态为交付状态               
                order.changeOrderState(new DeliveredOrderState());
                IOManager.getInstance().print(
                        "订单ID为" + orderId + "的订单已成功交付！",
                        "訂單ID為" + orderId + "的訂單已成功開始交付！",
                        "The order with order ID" + orderId + "has been delivered!"
                );
                return true;
            } else {
                IOManager.getInstance().errorMassage(
                        "该状态下无法进行交付！",
                        "該狀態下無法進行交付  ！",
                        "Delivery is not possible in this state!"
                );
            }
        }
        else {
            IOManager.getInstance().errorMassage(
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