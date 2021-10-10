package Marketing.Promotion;

import Marketing.Promotion.SellStrategy.SellStrategy;

/**
 * 策略模式
 * 销售策略上下文
 *
 * @author 吴英豪
 */

public class StrategyContext {

    /**
     * @param sellStrategy 某一种促销策略
     */
    public StrategyContext(SellStrategy sellStrategy) {
        strategy = sellStrategy;
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
     * @param sellStrategy 新的促销策略
     */
    public void changeStrategy(SellStrategy sellStrategy) {
        strategy = sellStrategy;
    }

    private SellStrategy strategy;
}
