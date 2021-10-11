package Observer;


import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderDisplayCenter implements Observer,DisplayElement{
    private Date CurrentTime;
    private Date OrderGenerationTime = new Date();
    private String CanTypeName;
    private Integer OrderNum;
    private Date OrderComTime = new Date();
    private String CenterName;
    private OrderData OrderData;

    public OrderDisplayCenter(OrderData orderData,String name){
        this.CenterName=name;
        this.OrderData = orderData;
        this.OrderData.registerObserver(this);

    }

    public void update(){
        this.OrderGenerationTime = OrderData.RelatedOrder.OrderGenerationTime;
        this.CanTypeName = OrderData.RelatedOrder.CanTypeName;
        this.OrderNum = OrderData.RelatedOrder.OrderNum;
        this.OrderComTime =OrderData.RelatedOrder.OrderComTime;
        display();
    }

    public void display(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd/HH:mm:ss");
        this.CurrentTime = new Date();
        String currentTime=dateFormat.format(this.CurrentTime);
        System.out.println("订单中心名称："+this.CenterName+"//当前时间："+currentTime);
        String orderGenerationTime = dateFormat.format(this.OrderGenerationTime);
        System.out.println("订单生成的时间:"+orderGenerationTime);
        System.out.println("订单所需的罐头类型："+this.CanTypeName);
        System.out.println("订单所需的罐头数量："+this.OrderNum);
        String orderComTime = dateFormat.format(this.OrderComTime);
        System.out.println("订单的最晚完成时间："+orderComTime);
    }
}
