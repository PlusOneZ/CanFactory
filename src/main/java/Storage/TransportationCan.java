package
        Storage;

import java.util.ArrayList;
import java.util.Date;

/**
 * 待运输的罐头订单信息
 *
 * @author 王立友
 * @date 2021/10/17 16:43
 */
public class TransportationCan {
    /**
     * 货物列表;
     */
    private ArrayList<StockCan> stockCans;

    /**
     * 订单最晚交付时间;
     */
    private Date latestDeliveryTime;

    /**
     * 订单中运送货物信息;
     */
    private String customerAddress;

    /**
     * 订单中的订单ID
     */
    private Long orderId;

    /**
     * 构造函数
     * @param latestDeliveryTime : 最晚交付时间
     * @param customerAddress :  顾客地址(暂且代表顾客信息)
     * @return : null
     * @author "王立友"
     * @date 2021-10-17 16:59
     */
    public TransportationCan(Date latestDeliveryTime, String customerAddress){
        this.customerAddress = customerAddress;
        this.latestDeliveryTime = latestDeliveryTime;
    }

    /** setter and getter **/

    public String getCustomerAddress() {
        return customerAddress;
    }

    public ArrayList<StockCan> getStockCans() {
        return stockCans;
    }

    public Date getLatestDeliveryTime() {
        return latestDeliveryTime;
    }

    public Long getOrderId(){
        return orderId;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public void setLatestDeliveryTime(Date latestDeliveryTime) {
        this.latestDeliveryTime = latestDeliveryTime;
    }

    public void setStockCans(ArrayList<StockCan> stockCans) {
        this.stockCans = stockCans;
    }

    public void setOrderId(Long OrderId){
        this.orderId = OrderId;
    }
}