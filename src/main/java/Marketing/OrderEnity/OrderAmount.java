package Marketing.OrderEnity;

import Marketing.Promotion.Coupon;

/**
 * @Author 王立友
 * 该类为订单中金额相关信息，包含原始信息与促销活动信息等相关
 */

public class OrderAmount {
    //原始金额;
    private double originalAmount;

    //促销金额;
    private double promotionAmount;

    //促销活动
    private Coupon coupon;

    //运输费用
    private double transportationAmount;

    public OrderAmount(double originalAmount, Coupon coupon){

        this.originalAmount = originalAmount;
        this.coupon = coupon;
        this. promotionAmount = coupon.getPreferentialPrice(originalAmount);
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public double getOriginalAmount() {
        return originalAmount;
    }

    public double getPromotionAmount() {
        return promotionAmount;
    }

    public double getTransportationAmount() {
        return transportationAmount;
    }

    public void setTransportationAmount(double transportationAmount) {
        this.transportationAmount = transportationAmount;
    }

}
