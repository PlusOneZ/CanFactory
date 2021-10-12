package Marketing.OrderCenter;

import java.util.Date;

/**
 * @author 梁乔 2021/10/10
 **/
public class OrderCenterDataBlock {
    public Date OrderGenerationTime;
    public String CanTypeName;
    public Integer OrderNum;
    public Date OrderComtime;
    public Integer OrderNumber;
    public OrderCenterDataBlock(Date orderGenerationTime,String canTypeName,Integer orderNum,Date orderComtime,Integer orderNumber){
        OrderGenerationTime = orderGenerationTime;
        CanTypeName = canTypeName;
        OrderNum = orderNum;
        OrderComtime = orderComtime;
        OrderNumber = orderNumber;
    }
}
