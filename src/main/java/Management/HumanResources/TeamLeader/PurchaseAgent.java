package Management.HumanResources.TeamLeader;

import Management.HumanResources.Staff.Purchaser;
import Marketing.Scheme.PurchaseScheme;
import Presentation.Protocol.OutputManager;

/**
 * 采购代理
 * TeamLeader层，负责安排采购员采购
 *
 * @author 吴英豪
 * @since 2021-10-20 8:33
 */
public class PurchaseAgent extends TeamLeader {

    /**
     * 采购代理安排专门的采购员进行采购
     *
     * @param scheme 采购方案
     * @return 采购结果
     */
    public boolean dispatchPurchase(PurchaseScheme scheme) {
        OutputManager.getInstance().print(
                "采购负责人收到采购计划",
                "採購部長收到採購計劃",
                "PurchaseAgent receives the purchaseAgent..."
        );
        // 委派采购员采购
        OutputManager.getInstance().print(
                "采购负责人安排采购员采购。",
                "採購部長安排採購員採購。",
                "PurchaseAgent arrange the purchaser..."
        );

        boolean result = true;
        for (int i=0;i<scheme.getScheme().size();i++){
            Purchaser purchaser = new Purchaser();
            result &= purchaser.purchaseMaterial(scheme.getScheme().get(i));
        }
        return result;
    }
}
