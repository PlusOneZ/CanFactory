package Marketing.Scheme;

/**
 * 委派模式
 * 运输计划
 *
 * @author 吴英豪
 */

public class TransportScheme extends Scheme {
    /**
     * @param landQuantityParam     陆运量
     * @param shippingQuantityParam 水运量
     */
    public TransportScheme(Double landQuantityParam, Double shippingQuantityParam) {
        landQuantity = landQuantityParam;
        shippingQuantity = shippingQuantityParam;
    }

    /**
     * 设置陆运量
     *
     * @param landQuantityParam 陆运量
     */
    public void setLandQuantity(Double landQuantityParam) {
        landQuantity = landQuantityParam;
    }

    /**
     * 设置水运量
     *
     * @param shippingQuantityParam 水运量
     */
    public void setShippingQuantity(Double shippingQuantityParam) {
        shippingQuantity = shippingQuantityParam;
    }

    /**
     * 获取陆运量
     *
     * @return 陆运量
     */
    public Double getLandQuantity() {
        return landQuantity;
    }

    /**
     * 获取水运量
     *
     * @return 水运量
     */
    public Double getShippingQuantity() {
        return shippingQuantity;
    }

    // 陆运量
    private Double landQuantity;
    // 水运量
    private Double shippingQuantity;
}
