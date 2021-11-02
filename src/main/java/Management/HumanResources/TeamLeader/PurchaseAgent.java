package Management.HumanResources.TeamLeader;

import Management.HumanResources.Staff.Purchaser;
import Manufacturing.ProductLine.Upstream.ConcreteUpstreamFactory;
import Marketing.Scheme.PurchaseScheme;
import Presentation.Protocol.IOManager;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

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
        IOManager.getInstance().print(
                "采购负责人收到采购计划",
                "採購部長收到採購計劃",
                "PurchaseAgent receives the purchaseAgent..."
        );
        // 委派采购员采购
        IOManager.getInstance().print(
                "采购负责人安排采购员采购。",
                "採購部長安排採購員採購。",
                "PurchaseAgent arrange the purchaser..."
        );

        List<Purchaser> purchaserList = new ArrayList<Purchaser>();

        for (int i = 0; i < scheme.getScheme().size(); i++) {
            Purchaser purchaser = new Purchaser();
            //安排上游工厂
            dispatchFactory(purchaser);
            purchaserList.add(purchaser);
            purchaser.setNeedToBuy(scheme.getScheme().get(i).getInt("count"));
        }

        for (int i = 0;i<purchaserList.size();i++) {
            JSONObject plan = scheme.getScheme().get(i);
            IOManager.getInstance().print(
                    (i+1)+"号采购员正在购买：" + plan.getString("ingredientType"),
                    (i+1)+"號採購員正在購買：" + plan.getString("ingredientType"),
                    "No."+(i+1)+"purchaser is purchasing: " + plan.getString("ingredientType")
            );
            while(!purchaserList.get(i).purchaseMaterial(plan)){
                IOManager.getInstance().print(
                        "采购失败，正在重新购买......",
                        "採購失敗，正在重新購買......",
                        "Purchasing Failed,purchasing again......"
                );
                dispatchFactory(purchaserList.get(i));
            }
        }

        return true;
    }

    /**
     * 分配上游工厂
     * @param purchaser 采购员
     */
    public void dispatchFactory(Purchaser purchaser){
        purchaser.clearFactory();
        for (int j = 0; j < 10; j++) {
            purchaser.addFactory(new ConcreteUpstreamFactory());
        }
    }
}
