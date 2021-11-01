package Management.HumanResources.Staff;

import Manufacturing.ProductLine.PurchaseDepartment;
import Manufacturing.ProductLine.Upstream.ConcreteUpstreamFactory;
import Presentation.Protocol.OutputManager;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 采购员
 * 属于Staff层，主要职责为购买原材料
 *
 * @author 吴英豪
 * @since 2021-10-20 08:43
 */
public class Purchaser extends Staff implements BasePurchaser {

    public Purchaser() {
        upstreamFactories = new ArrayList<ConcreteUpstreamFactory>();
    }

    /**
     *  添加上游工厂
     * @param factory 需要去购买的上游工厂
     */
    @Override
    public void addFactory(ConcreteUpstreamFactory factory){
        this.upstreamFactories.add(factory);
    }

    /**
     * 清除上游工厂
     */
    @Override
    public void clearFactory(){
        this.upstreamFactories.clear();
    }

    /**
     * 采购员进行采购
     *
     * @param plan 具体的采购计划
     * @return 是否采购成功
     */
    @Override
    public boolean purchaseMaterial(JSONObject plan) {
        OutputManager.getInstance().printPattern(
                "# 使用观察者模式，对上游工厂原材料进行购买",
                "# 使用觀察者模式，對上遊工廠原材料進行購買",
                "# Use the observer pattern to purchase raw materials from upstream factories"
        );

        OutputManager.getInstance().printBrief(
                "从上游工厂购买原材料",
                "從上遊工廠購買原材料",
                "Purchase raw materials from upstream factories"
        );

        //试图从上游工厂进行购买
        for (ConcreteUpstreamFactory factory : upstreamFactories) {
            JSONObject result = factory.getInfo();
            if (Objects.equals(result.getString("ingredientType"), plan.getString("ingredientType"))) {
                factory.purchase();
                needToBuy -= result.getInt("count");
                //更新库存
                PurchaseDepartment.getInstance().update(
                        result.getString("ingredientType"),
                        result.getInt("count"),
                        PurchaseDepartment.Status.IN);
                if(needToBuy<=0){
                    return true;
                }
                else {
                    return false;
                }
            }
        }

        return false;

    }

    /**
     * 设置需要购买的量
     * @param account 需要购买的量
     */
    public void setNeedToBuy(int account) {
        needToBuy = account;
    }

    /**
     * 返回需要购买的量
     * @return 目前需要购买的量
     */
    public int getNeedToBuy(){
        return needToBuy;
    }

    // 采购员需要从这些工厂里购买信息
    private List<ConcreteUpstreamFactory> upstreamFactories;

    private int needToBuy;
}
