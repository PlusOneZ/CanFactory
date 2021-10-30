package Management.HumanResources.Staff;

import Manufacturing.ProductLine.Upstream.ConcreteUpstreamFactory;
import org.json.JSONObject;

import java.util.List;

/**
* TODO:抽象的Subject，提供了基础采购人员的接口
* @author 香宁雨
* @since 2021-10-30 14:55
*/
public interface BasePurchaser {
    public void addFactory(ConcreteUpstreamFactory factory);
    public void clearFactory();
    public boolean purchaseMaterial(JSONObject plan);
}
