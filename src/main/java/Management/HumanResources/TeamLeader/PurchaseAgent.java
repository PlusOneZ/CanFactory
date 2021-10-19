package Management.HumanResources.TeamLeader;

import Marketing.Scheme.PurchaseScheme;
import org.json.JSONArray;

/**
 * 采购代理
 * TeamLeader层，负责安排采购员采购
 *
 * @author 吴英豪
 * @since 2021-10-18 10:51
 */
public class PurchaseAgent extends TeamLeader{

    /**
     * TODO：按照采购经理提供的订购方案，安排采购员采购，并整理实际采购量提供给经理，和xny对接
     * 采购代理安排专门的采购员进行采购
     * @param scheme 采购方案
     * @return  采购结果
     */
    public JSONArray dispatchPurchase(PurchaseScheme scheme) {
        return new JSONArray();
    }
}
