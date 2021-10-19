package Management.HumanResources.Manager;


import Management.HumanResources.TeamLeader.PurchaseAgent;
import Marketing.Scheme.PurchaseScheme;
import org.json.JSONArray;

/**
 * 委派模式
 * 采购部经理
 * 主要负责采购原材料
 *
 * @author 吴英豪
 * @since 2021-10-17 23:30
 */
public class PurchaseManager extends Manager{

    public PurchaseManager() {
        purchaseScheme = null;
    }

    /**
     * 设置采购方案
     *
     * @param scheme 采购方案
     */
    public void setPurchaseScheme(PurchaseScheme scheme) {
        purchaseScheme = scheme;
    }

    /**
     * Todo: 这里还需要详细设计，和xny对接
     * 设计采购方案
     */
    private void designPurchaseScheme(JSONArray demand) {

    }

    /**
     * 委派承运商购买
     * @param agent  采购代理
     * @return 实际购买量
     */
    public JSONArray delegatePurchase(PurchaseAgent agent) {
            return agent.dispatchPurchase(purchaseScheme);
    }

    /**
     * TODO： 提供给xny的接口，还需要补充
     * 采购部经理委派采购
     *
     * @param demand 购买需求
     * @return 实际购买量
     */
    public JSONArray purchase(JSONArray demand) {
        designPurchaseScheme(demand);
        return delegatePurchase(new PurchaseAgent());
    }

    //采购需求
    private PurchaseScheme purchaseScheme;
}
