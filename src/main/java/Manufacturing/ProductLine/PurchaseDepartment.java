package Manufacturing.ProductLine;


/**
 * 上游原材料的接口，
 * <b>作为 Observer模式 的 Observer</b>
 *
 * @author 香宁雨
 */
public interface PurchaseDepartment {
    void getInfo(Object upstreamFactory);
}
