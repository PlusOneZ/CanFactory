package Manufacturing.ProductLine;

import Management.HumanResources.BaseDepartment;
import Management.HumanResources.DepartmentType;
import Management.HumanResources.Manager.PurchaseManager;
import Presentation.Protocol.OutputManager;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Random;


/**
 * TODO:获取原材料信息并对其进行筛选
 * 实现了规约模式
 *
 * @author 香宁雨
 * @since 2021/10/11 23:45
 */

public class PurchaseDepartment extends BaseDepartment {

    private PurchaseDepartment() {

        this.type = DepartmentType.Purchase;

        rawMaterial = generateMaterialList();

        OutputManager.getInstance().print(
                "新建了一个采购部门",
                "新建了一個采購部門",
                "A new purchasing department has been created"
        );
    }

    private JSONArray rawMaterial;
    private PurchaseManager purchaseManager = new PurchaseManager();
    static private PurchaseDepartment instance;

    public JSONArray generateMaterialList(){
        JSONArray material = new JSONArray();
        JSONObject apple = new JSONObject();
        apple.put("ingredientType", "apple");
        apple.put("count", 30);
        JSONObject clove = new JSONObject();
        clove.put("ingredientType", "clove");
        clove.put("count", 0);
        JSONObject peach = new JSONObject();
        peach.put("ingredientType", "peach");
        peach.put("count", 0);
        JSONObject pear = new JSONObject();
        pear.put("ingredientType", "pear");
        pear.put("count", 0);
        JSONObject salmon = new JSONObject();
        salmon.put("ingredientType", "salmon");
        salmon.put("count", 0);

        material.put(apple);
        material.put(clove);
        material.put(peach);
        material.put(pear);
        material.put(salmon);

        return material;
    }

    /**
     * 单例模式
     * 采购部门
     *
     * @since 2021-10-20 09:04
     * @return  采购部门单例
     */
    public static PurchaseDepartment getInstance(){
        if(instance == null){
            instance = new PurchaseDepartment();
        }
        return instance;
    }
    /**
     * TODO:用于获取当前type在rawMaterial中的index
     */
    private Integer indexOfRawMaterial(String type) {
        for (Integer i = 0; i < rawMaterial.length(); i++) {
            if (type == rawMaterial.getJSONObject(i).getString("ingredientType")) {
                return i;
            }
        }
        return null;
    }

    /**
     * TODO:用于描述对库存的状态，其中IN为装入库存，OUT为取出库存
     */
    public enum Status {
        IN, OUT;
    }

    /**
     * TODO:用于对库存进行更新
     * @param type :原材料的种类
     * @param count :原材料的个数
     * @param state :原材料需要更新的状态0
     * @return : boolean 是否成功更新
     * @author 香宁雨
     * @since 13:40 2021-10-19
     */
    public boolean update(String type, Integer count, Status state) {
        Integer index = indexOfRawMaterial(type);
        Integer curCount = rawMaterial.getJSONObject(index).getInt("count");
        if (state == Status.IN) {
            curCount += count;
            rawMaterial.getJSONObject(index).put("count", curCount);
            return true;
        } else {
            if (Double.doubleToLongBits(curCount) >= Double.doubleToLongBits(count)) {
                curCount -= count;
                rawMaterial.getJSONObject(index).put("count", curCount);
                return true;
            }
            return false;
        }
    }

    /**
     * TODO:生产部门所调用的购买接口
     * @param material : JSONArray 传入JSONArray，其中包括所需要的所有原材料以及其所需要的重量
     * @return : boolean 是否购买成功
     * @author 香宁雨
     * @since 13:43 2021-10-19
     */
    public boolean purchaseIngredient(JSONArray material) {
        OutputManager.getInstance().print(
                "正在将采购需求交给采购部经理.....",
                "正在將採購需求交給採購部經理....",
                "Transferring purchasing requirements to purchasing manager......."
        );
        return purchaseManager.purchase(material);
    }

    /**
     * TODO:原材料加工时从采购部门获得所有的原料
     * @param material : JSONObject 所需要的原料，每次只传入一个
     * @return : boolean
     * @author 香宁雨
     * @since 13:48 2021-10-19
     */
//    public boolean getIngredient(JSONObject material) {
//        String type = material.getString("ingredientType");
//        Integer count = material.getInt("count");
//        if (update(type, count, Status.OUT)) return true;
//        return false;
//    }

    public JSONArray getIngredient(JSONObject material){
        JSONArray ingredient = new JSONArray();
        String type = material.getString("ingredientType");
        Integer count = material.getInt("count");
        if (update(type, count, Status.OUT)){
            for(Integer i = 0;i<count;i++){
//                JSONObject single = new JSONObject();
                Random r = new Random();
                Double weight = r.nextDouble()*200;
//                single.put("weight",weight);
                ingredient.put(weight);
            }
        }
        System.out.println(ingredient);
        return ingredient;
    }


    /**
     * 采购流程的测试函数
     * @param args main函数参数args
     */
    public static void main(String[] args) {
        JSONObject apple = new JSONObject();
        apple.put("ingredientType","apple");
        apple.put("count",10);
        PurchaseDepartment.getInstance().getIngredient(apple);
//        // 设置语言
//        OutputManager.getInstance().setLanguage(OutputManager.Lang.zh_CN);
//
//        //创建购买需求
//        JSONArray demand = new JSONArray();
//
//        JSONObject apple = new JSONObject();
//        apple.put("ingredientType", "apple");
//        apple.put("count", 10);
//        JSONObject clove = new JSONObject();
//        clove.put("ingredientType", "clove");
//        clove.put("count", 20);
//        JSONObject peach = new JSONObject();
//        peach.put("ingredientType", "peach");
//        peach.put("count", 21);
//        JSONObject pear = new JSONObject();
//        pear.put("ingredientType", "pear");
//        pear.put("count", 23);
//        JSONObject salmon = new JSONObject();
//        salmon.put("ingredientType", "salmon");
//        salmon.put("count", 24);
//
//        demand.put(apple);
//        demand.put(clove);
//        demand.put(peach);
//        demand.put(pear);
//        demand.put(salmon);
//
//        //购买
//        if(PurchaseDepartment.getInstance().purchaseIngredient(demand)){
//            OutputManager.getInstance().print(
//                    "采购成功!",
//                    "採購成功!",
//                    "Purchasing Success! "
//            );
//        }
//        else{
//            OutputManager.getInstance().print(
//                    "采购失败!",
//                    "採購失敗!",
//                    "Purchasing Failed!"
//            );
//        }
    }

}

