package Manufacturing.ProductLine;

import Management.HumanResources.BaseDepartment;
import Management.HumanResources.DepartmentType;
import Manufacturing.ProductLine.Upstream.ConcreteUpstreamFactory;
import org.json.JSONArray;
import org.json.JSONObject;


/**
 * TODO:获取原材料信息并对其进行筛选
 * 实现了规约模式
 *
 * @author 香宁雨
 * @since 2021/10/11 23:45
 */

public class PurchaseDepartment extends BaseDepartment {

    public PurchaseDepartment() {

        this.type = DepartmentType.Purchase;
//        newManager = null;
//        manager = setManager(manager);

        JSONObject apple = new JSONObject();
        apple.put("ingredientType", "apple");
        apple.put("weight", 0.0);
        JSONObject clove = new JSONObject();
        clove.put("ingredientType", "clove");
        clove.put("weight", 0.0);
        JSONObject peach = new JSONObject();
        peach.put("ingredientType", "peach");
        peach.put("weight", 0.0);
        JSONObject pear = new JSONObject();
        pear.put("ingredientType", "pear");
        pear.put("weight", 0.0);
        JSONObject salmon = new JSONObject();
        salmon.put("ingredientType", "salmon");
        salmon.put("weight", 0.0);


        rawMaterial.put(apple);
        rawMaterial.put(clove);
        rawMaterial.put(peach);
        rawMaterial.put(pear);
        rawMaterial.put(salmon);

        System.out.println(rawMaterial);
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

    private Integer indexOfRawMaterial(String type){
        for (Integer i = 0; i < rawMaterial.length(); i++) {
            if (type == rawMaterial.getJSONObject(i).getString("ingredientType")) {
                return i;
            }
        }
        return null;
    }


    // 外部调用接口
    public boolean purchaseIngredient(JSONArray material){
        for(Object ingredient : material){
            Integer index = indexOfRawMaterial(((JSONObject)ingredient).getString("ingredientType"));
        }
        return true;
    }

    // 外部调用接口
    public boolean getIngredient(JSONObject material) {
        String type = material.getString("ingredientType");
        Double weight = material.getDouble("weight");

        Integer index = indexOfRawMaterial(type);
        Double curWeight  = rawMaterial.getJSONObject(index).getDouble("weight");
        System.out.println(curWeight + "\n");
        if(Double.doubleToLongBits(curWeight) >= Double.doubleToLongBits(weight)){
            curWeight -= weight;
            rawMaterial.getJSONObject(index).put("weight", curWeight);
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        PurchaseDepartment a = new PurchaseDepartment();
        JSONObject x = new JSONObject();
        x.put("ingredientType","apple");
        x.put("weight",3.3);
        a.getIngredient(x);

    }

}

