package Marketing.OrderCenter;

import Manufacturing.CanEntity.Can;
import Presentation.Protocol.OutputManager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 梁乔 2021/10/10
 **/
public class OrderDisplayCenter implements Observer{

    private Integer OrderNum = 0;
    private List<OrderCenterDataBlock> OrderList;
    private String CenterName;
    private OrderDataSubject OrderData;
    /**
     * 创建一个订单展示中心实体
     * @param orderData 需要绑定的subject目标
     * @param centerName  订单中心的名称
     */
    public <T extends Can>OrderDisplayCenter(OrderDataSubject<T> orderData, String centerName){
        OrderList = new ArrayList<OrderCenterDataBlock>();
        OrderData = orderData;
        CenterName = centerName;
        OrderData.Attach(this);
    }

    /**
     * 设置新的目标
     * @param orderData 订单目标对象
     */
    public void setSubject(OrderDataSubject orderData){
        OrderData = orderData;
        OrderData.Attach(this);//重新绑定
    }

    /**
     * 更新相应的数据
     */
    @Override
    public void update() {
        OrderNum++;
        OrderCenterDataBlock newOrderBlock = new OrderCenterDataBlock(OrderData.getOrder().getOrderGenerationTime(),OrderData.getOrder().getCanTypeName(),
                OrderData.getOrder().getOrderNum(),OrderData.getOrder().getOrderComTime(),OrderNum);
        OrderList.add(newOrderBlock);
        displayData();
    }

    /**
     * 展示相应的数据
     */
    public void displayData() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd/HH");
        OutputManager.getInstance().setLanguage(OutputManager.Lang.zh_CN);
        OutputManager.getInstance().print(
                "订单中心收到更新通知！",
                "訂單中心收到更新通知！:",
                "The order center received an update notification!"
        );
        OutputManager.getInstance().print(
                "订单中心名称：" + this.CenterName,
                "訂單中心名稱:" + this.CenterName,
                "Order center name:" + this.CenterName
        );
        OutputManager.getInstance().print(
                "当前订单数量：" + OrderNum,
                "當前訂單數量" + OrderNum,
                "Current order quantity:" +OrderNum
        );
        for (OrderCenterDataBlock ocd : this.OrderList) {
            String orderGenerationTime = dateFormat.format(ocd.OrderGenerationTime);
            String orderComTime = dateFormat.format(ocd.OrderComtime);

            OutputManager.getInstance().print(
                    "订单：" + ocd.OrderNumber ,
                    "訂單:" + ocd.OrderNumber,
                    "Order:" + ocd.OrderNumber
            );
            OutputManager.getInstance().print(
                    "订单生成的时间：" + orderGenerationTime,
                    "訂單生成的時間" + orderGenerationTime,
                    "Order Generation Time:" + orderGenerationTime
            );
            OutputManager.getInstance().print(
                    "订单所需的罐头类型名称：" + ocd.CanTypeName,
                    "訂單所需的罐頭類型名稱:" + ocd.CanTypeName,
                    "The name of the canned food type required by the order:" + ocd.CanTypeName
            );
            OutputManager.getInstance().print(
                    "订单所需的罐头数量：" + ocd.OrderNum,
                    "訂單所需的罐頭數量:" + ocd.OrderNum,
                    "The number of cans required by the order:" + ocd.OrderNum
            );
            OutputManager.getInstance().print(
                    "订单的最晚完成时间：" + orderComTime,
                    "訂單的最晚完成時間：" + orderComTime,
                    "The latest completion time of the order:" + orderComTime
            );
        }
    }
}
