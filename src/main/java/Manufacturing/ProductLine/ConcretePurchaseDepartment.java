package Manufacturing.ProductLine;

import Manufacturing.ProductLine.Upstream.ConcreteUpstreamFactory;
import org.json.JSONArray;
import org.json.JSONObject;


/**
 * TODO:获取原材料信息并对其进行筛选
 * 作为Observer模式中的 concrete observer
 * 实现了规约模式
 *
 * @author 香宁雨
 * @since 2021/10/11 23:45
 */

public class ConcretePurchaseDepartment implements PurchaseDepartment {

    public ConcretePurchaseDepartment() {
        JSONObject fruit = new JSONObject();
        fruit.put("ingredientType", "fruit");
        fruit.put("weight", 0.0);
        JSONObject vegetable = new JSONObject();
        vegetable.put("ingredientType", "vegetable");
        vegetable.put("weight", 0.0);
        rawMaterial.put(fruit);
        rawMaterial.put(vegetable);
    }

    private JSONArray rawMaterial = new JSONArray();

    /**
     * TODO:规约模式 代表是否满足采购的条件
     * @param type :采购的种类
     * @return : boolean
     * @author 香宁雨
     * @since 2:27 2021-10-16
     */
    private boolean isSatisfiedBy(String type) {
        for (Object ingredient : rawMaterial) {
            String a = ((JSONObject) ingredient).getString("ingredientType");
            if (type == a)
                return true;
        }
        return false;
    }

    // 外部调用接口
    public boolean getIngredient() {
        return true;
    }

    @Override
    public void getInfo(Object upstreamFactory) {
        ConcreteUpstreamFactory concreteUpstreamFactory = (ConcreteUpstreamFactory) upstreamFactory;
        String type = concreteUpstreamFactory.getIngredient();
        Double weight = concreteUpstreamFactory.getWeight();
        System.out.println("ingredient from upstream factory remains:" + type + "," + weight);
        if (isSatisfiedBy(type)) {
            for (Integer i = 0; i < rawMaterial.length(); i++) {
                if (type == rawMaterial.getJSONObject(i).getString("ingredientType") && Double.doubleToLongBits(weight) > Double.doubleToLongBits(0.0)) {
                    Double curWeight = rawMaterial.getJSONObject(i).getDouble("weight");
                    curWeight += weight;
                    rawMaterial.getJSONObject(i).put("weight", curWeight);
                    concreteUpstreamFactory.setZero();
                    break;
                }
            }
        }
        System.out.println("raw material currently owned by the purchasing Department:" + rawMaterial);
        System.out.println("ingredient from upstream factory remains:" + concreteUpstreamFactory.getIngredient() + "," + concreteUpstreamFactory.getWeight());
    }

    public static void main(String[] args) {
        ConcretePurchaseDepartment a = new ConcretePurchaseDepartment();
    }

}

