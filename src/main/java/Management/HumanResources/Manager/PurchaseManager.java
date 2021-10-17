package Management.HumanResources.Manager;

import org.json.JSONObject;

/**
 * 委派模式
 * 采购部经理
 * 主要负责采购原材料
 *
 * @author 吴英豪
 * @since 2021-10-17 23:30
 */
public class PurchaseManager {

    public PurchaseManager() {

    }

    /**
     * 设置采购需求
     *
     * @param scheme 采购需求
     */
    public void setPurchaseScheme(JSONObject scheme) {
        purchaseScheme = scheme;
    }

    /**
     * Todo: 这里还需要详细设计，和xny对接
     * 设计采购方案
     */
    public void designPurchaseScheme() {

    }

    /**
     * TODO： 和xny对接，还需要补充
     * 采购部经理委派采购
     *
     * @param purchaseDemand 购买需求
     * @return 实际购买量
     */
    public JSONObject purchase(JSONObject purchaseDemand) {
        JSONObject temp = new JSONObject();
        return temp;
    }

    //采购计划
    private JSONObject purchaseScheme;
}
