package Marketing;

import Manufacturing.CanEntity.Can;
import Marketing.OrderCenter.Observer;
import Marketing.OrderCenter.OrderDataSubject;
import Presentation.Protocol.OutputManager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 生产规划中心，关联观察者模式
 * @author 梁乔 2021/10/10
 *
 * <b>生产规划中心本身是单例模式</b>
 *
 **/
public class ProductionPlanningCenter implements Observer {

    /**
     * nested class:生产数据类，一个实例代表一个罐头种类的生产数据，为泛型类
     * @param <T>具体的罐头类型
     */
    private class ProductionData<T extends Can>{
        private String Cantype;
        private Integer TotalProductionNum;
        private ArrayList<Date> ProductionComDate;
        private ArrayList<Integer> ProductionNum;
        private ProductionData(T canType){
            Cantype = canType.getCanName();
            TotalProductionNum = 0;
            ProductionComDate = new ArrayList<Date>();
            ProductionNum = new ArrayList<Integer>();
        }

        public String getCantype(){
            return Cantype;
        }
    }



    private OrderDataSubject OrderData;
    private ArrayList<ProductionData>ProductionPlanningList;

    /**
     * 构造函数
     * @param orderData：目标对象：新的订单数据
     */
    private ProductionPlanningCenter(OrderDataSubject orderData){
        ProductionPlanningList = new ArrayList<ProductionData>();
        MeatCan mc = new MeatCan();
        ProductionPlanningList.add(new ProductionData(mc));
        OrderData = orderData;
        OrderData.Attach(this);//进行目标与观察者的绑定
    }

    /**
     * 更新函数
     */
    @Override
    public void update(){
        for(int i = 0;i < ProductionPlanningList.size();i++){
            if(ProductionPlanningList.get(i).getCantype() == OrderData.getOrder().getCanTypeName()){
                ProductionPlanningList.get(i).TotalProductionNum += OrderData.getOrder().getOrderNum();
                ProductionPlanningList.get(i).ProductionNum.add(OrderData.getOrder().getOrderNum());
                ProductionPlanningList.get(i).ProductionComDate.add(OrderData.getOrder().getOrderComTime());
            }
        }
        displayData();
    }

    /**
     * 展示数据函数
     */
    public void displayData(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        OutputManager.getInstance().setLanguage(OutputManager.Lang.zh_CN);
        OutputManager.getInstance().print(
                "生产规划中心收到订单更新通知！",
                "生產規劃中心收到訂單更新通知！",
                "The production planning center received an order update notification!"
        );
        for(ProductionData ppl:ProductionPlanningList) {
            OutputManager.getInstance().print(
                    "罐头种类："+ppl.Cantype,
                    "罐頭種類:"+ppl.Cantype,
                    "Can Type:"+ppl.Cantype
            );
            OutputManager.getInstance().print(
                    "罐头需要生产的时刻列表：",
                    "罐頭需要生產的時刻列表：",
                    "List of moments when canned food needs to be produced:"
            );
            for(int i=0;i<ppl.ProductionComDate.size();i++){
                OutputManager.getInstance().print(
                        "最晚生产完成时间："+ppl.ProductionComDate.get(i),
                        "罐頭需要生產的時刻列表："+ppl.ProductionComDate.get(i),
                        "List of moments when canned food needs to be produced:"+ppl.ProductionComDate.get(i)
                );
                OutputManager.getInstance().print(
                        "需要生产的数量："+ppl.ProductionNum.get(i),
                        "罐頭需要生產的時刻列表："+ppl.ProductionNum.get(i),
                        "List of moments when canned food needs to be produced:"+ppl.ProductionNum.get(i)
                );
            }
        }
    }

    /**
     * 设置新的目标
     * @param orderData: 目标对象：新的订单数据
     */
    public void setSubject(OrderDataSubject orderData){
        OrderData = orderData;
        OrderData.Attach(this);
    }

    /**
     * 单例获取函数
     * @param orderData ：传入需要绑定的目标
     * @return 返回该生产规划中心单例
     */
    public static ProductionPlanningCenter getInstance(OrderDataSubject orderData){
        if(instance == null)
        {
            instance = new ProductionPlanningCenter(orderData);
        }
        return instance;
    }


    static private ProductionPlanningCenter instance;

}
