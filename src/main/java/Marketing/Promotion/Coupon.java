package Marketing.Promotion;

import Marketing.Promotion.Sale.Sale;

/**
 * 策略模式
 * 销售策略上下文
 *
 * @author 吴英豪
 */

public class Coupon {

    /**
     * @param sale 某一种促销策略
     */
    public Coupon(Sale sale) {
        strategy = sale;
    }

    /**
     * @param originalPrice 产品原价
     * @return 优惠价格
     */
    public Double getPreferentialPrice(Double originalPrice) {
        return strategy.discount(originalPrice);
    }

    /**
     * 更改促销手段
     *
     * @param sale 新的促销策略
     */
    public void changeStrategy(Sale sale) {
        strategy = sale;
    }

    public Sale getSale(){return strategy;}

    private Sale strategy;
}
