package Marketing;

import java.util.Date;

public class Order {
    public Date OrderGenerationTime;
    public String CanTypeName;
    public Integer OrderNum;
    public Date OrderComTime = new Date();

    /**
     *
     * @param _canTypeName:the name of the can's type the order needs
     * @param _orderNum:
     * @param _orderComTime
     */
    public Order(String _canTypeName,Integer _orderNum,Date _orderComTime){
        this.OrderGenerationTime=new Date();
        this.CanTypeName=_canTypeName;
        this.OrderNum=_orderNum;
        this.OrderComTime=_orderComTime;
    }



}
