package Marketing.Order;

import Manufacturing.CanEntity.Can;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 订单类，泛型标识对应的罐头种类
 * @author 梁乔 2021/10/10
 **/
public class Order<T extends Can> {

    private T  TypedCan;
    private Integer OrderNum;
    private Date OrderComTime;
    private Date OrderGenerationTime;

    /**
     *
     * @param orderNum 订单所需数量
     * @param orderComTime 订单的最晚完成时间
     * @param orderGenerationTime 订单的生成时间
     */
    public Order(T typedCan,Integer orderNum, Date orderComTime , Date orderGenerationTime){
        TypedCan = typedCan;
        OrderNum=orderNum;
        OrderComTime=orderComTime;
        OrderGenerationTime=orderGenerationTime;
    }

    /**
     *
     * @return 订单中罐头类型的名称
     */
    public String getCanTypeName(){
        return TypedCan.getCanName();
    }

    public Integer getOrderNum(){
        return OrderNum;
    }

    public Date getOrderComTime(){
        return OrderComTime;
    }

    public Date getOrderGenerationTime(){
        return OrderGenerationTime;
    }



}
