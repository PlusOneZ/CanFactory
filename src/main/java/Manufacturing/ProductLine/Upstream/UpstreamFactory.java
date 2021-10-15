package Manufacturing.ProductLine.Upstream;

import Manufacturing.ProductLine.PurchaseDepartment;


/**
 * 上游原材料的接口，
 * 作为 Observer模式的Subject
 *
 * @author 香宁雨
 */
public interface UpstreamFactory {
    public void add(PurchaseDepartment observer);

    public void remove(PurchaseDepartment observer);

    public void notifyObserver();

}
