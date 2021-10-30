package CanFactory;

import ImplementDepartment.OrderImplementDepartment;
import Marketing.OrderCenterEntity.OrderPartTest;
import Marketing.OrderCenterEntity.OrderProcessingMediator;
import Marketing.OrderEnity.Order;
import Mediator.DepartmentMediator;

import java.text.ParseException;
import java.util.ArrayList;

/**
 * 所有类的驱动类
 *
 * @author 卓正一
 * @since  2021/10/29 5:16 PM
 */
public class CanFactory {

    private static CanFactory canFactory;

    static {
        canFactory = new CanFactory();
    }

    public static CanFactory getInstance() {
        return canFactory;
    }

    /**
     * 单例构造器
     * @author 卓正一
     * @since 2021-10-29 5:17 PM
     */
    private CanFactory() {

    }

    public void run() throws ParseException {
        //首先提示客户创建订单
        ArrayList<Order> pendingOrders = OrderImplementDepartment.getInstance().CreateOrder();
        //然后通知库存部门作后续处理
        for(Order order : pendingOrders){
            //对于每一个订单，进行相应的处理
            DepartmentMediator.getInstance().handleOrder(order);
        }
    }
}
