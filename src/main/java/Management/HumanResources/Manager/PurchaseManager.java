package Management.HumanResources.Manager;


import Management.HumanResources.TeamLeader.PurchaseAgent;
import Marketing.Scheme.PurchaseScheme;
import Presentation.Protocol.OutputManager;
import org.json.JSONArray;

/**
 * 委派模式
 * 采购部经理
 * 主要负责采购原材料
 *
 * @author 吴英豪
 * @since 2021-10-17 23:30
 */
public class PurchaseManager extends Manager {

    public PurchaseManager() {
        purchaseScheme = new PurchaseScheme();
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
     * 设计采购方案
     */
    public void designPurchaseScheme(JSONArray demand) {
        OutputManager.getInstance().print(
                "采购部经理制定采购计划。",
                "採購部經理制定採購計劃。",
                "Purchasing Manager designs the purchase scheme."
        );
        //首先清空方案
        purchaseScheme.clearPurchaseScheme();
        for (int i = 0; i < demand.length(); i++) {
            purchaseScheme.addDemand(demand.getJSONObject(i));
        }
    }

    /**
     * 委派采购代理购买
     *
     * @param agent 采购代理
     * @return 实际购买量
     */
    public boolean delegatePurchase(PurchaseAgent agent) {
        OutputManager.getInstance().print(
                "正在将采购计划转交给采购负责人.....",
                "正在將採購計劃轉交給採購部長.....",
                "Transferring purchasing scheme to purchaseAgent...."
        );
        return agent.dispatchPurchase(purchaseScheme);
    }

    /**
     * 采购部经理委派采购
     *
     * @param demand 购买需求
     * @return 实际购买量
     */
    public boolean purchase(JSONArray demand) {
        OutputManager.getInstance().print(
                "# 使用委派模式，采购部经理安排采购",
                "# 使用委派模式，採購部經理安排採購",
                "# using delegate pattern, purchase manager begins to dispatch purchasing"
        );
        OutputManager.getInstance().print(
                "采购部经理收到采购需求。",
                "採購部經理收到採購需求。",
                "Purchasing Manager receives the purchase demand."
        );
        designPurchaseScheme(demand);
        return delegatePurchase(new PurchaseAgent());
    }

    //采购需求
    private PurchaseScheme purchaseScheme;
}
