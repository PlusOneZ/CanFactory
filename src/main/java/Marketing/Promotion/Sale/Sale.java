package Marketing.Promotion.Sale;

/**
 * 策略模式
 * 营销策略接口
 *
 * @author 吴英豪
 */
public interface Sale {
    /**
     * 通过原价获得优惠价格
     *
     * @param originalPrice 产品原价
     * @return 优惠价格
     */
    Double discount(Double originalPrice);
}
