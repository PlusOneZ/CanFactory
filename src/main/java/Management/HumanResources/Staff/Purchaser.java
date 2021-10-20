package Management.HumanResources.Staff;

import Manufacturing.ProductLine.PurchaseDepartment;
import Manufacturing.ProductLine.Upstream.ConcreteUpstreamFactory;
import Presentation.Protocol.OutputManager;
import org.json.JSONObject;

/**
 * 采购员
 * 属于Staff层，主要职责为购买原材料
 *
 * @author 吴英豪
 * @since 2021-10-20 08:43
 */
public class Purchaser extends Staff {

    /**
     * 采购员进行采购
     *
     * @param plan 具体的采购计划
     * @return 是否采购成功
     */
    public boolean purchaseMaterial(JSONObject plan) {
        //从上游工厂购买
        OutputManager.getInstance().print(
                "正在购买：" + plan.getString("ingredientType"),
                "正在購買：" + plan.getString("ingredientType"),
                "Purchasing: " + plan.getString("ingredientType")
        );

        ConcreteUpstreamFactory factory = new ConcreteUpstreamFactory();
        factory.setIngredientType(plan.getString("ingredientType"));
        JSONObject result = factory.getInfo();
        factory.purchase();

        //更新库存
        PurchaseDepartment.getInstance().update(
                result.getString("ingredientType"),
                result.getDouble("weight"),
                PurchaseDepartment.Status.IN);

        return true;
    }
}
