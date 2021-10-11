package Marketing.OrderCenter;

import Manufacturing.CanEntity.Can;
import Marketing.Order.Order;

import java.util.ArrayList;
import java.util.Date;

/**
 * 具体的subject,订单数据类
 * @author 梁乔 2021/10/10
 **/
public class OrderDataSubject<T extends Can> extends Observable{
    private Order<T> RelatedOrder;
    private Integer OrderDataNum ;

    public Order<T> getOrder(){
        return RelatedOrder;
    }
    /**
     * 构造函数，产生一个订单数据实体
     */
    public OrderDataSubject(){
        observers = new ArrayList<Observer>();
        OrderDataNum = 0;
    }

    /**
     * 添加订单
     */
    public void OrderAdded(){
        OrderDataNum++;notifyObservers();
    }

    /**
     * 获取新的订单数据
     * @param newOrder 新的订单对象
     */
    public void getNewOrderData(Order newOrder){
        RelatedOrder = newOrder;
        dataChanged();
        OrderAdded();
    }

    /**
     * 获取当前订单中心的订单数量
     * @return 订单数量
     */
    public Integer getOrderDataNum(){
        return OrderDataNum;
    }
}
