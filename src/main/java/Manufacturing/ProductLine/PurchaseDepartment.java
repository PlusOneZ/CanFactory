package Manufacturing.ProductLine;

import Management.HumanResources.BaseDepartment;
import Management.HumanResources.DepartmentType;
import Management.HumanResources.Manager.PurchaseManager;
import Presentation.Protocol.OutputManager;
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

    private PurchaseDepartment() {

        this.type = DepartmentType.Purchase;

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

        OutputManager.getInstance().print(
                "新建了一个采购部门",
                "新建了一個采購部門",
                "A new purchasing department has been created"
        );
    }

    private JSONArray rawMaterial = new JSONArray();
    private PurchaseManager purchaseManager = new PurchaseManager();
    static private PurchaseDepartment instance;

//
//    /**
//     * TODO:规约模式 代表是否满足采购的条件
//     *
//     * @param type :采购的种类
//     * @return : boolean
//     * @author 香宁雨
//     * @since 2:27 2021-10-16
//     */
//    private boolean isSatisfiedBy(String type) {
//        for (Object ingredient : rawMaterial) {
//            String a = ((JSONObject) ingredient).getString("ingredientType");
//            if (type == a)
//                return true;
//        }
//        return false;
//    }

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
     * @param weight :原材料的重量
     * @param state :原材料需要更新的状态
     * @return : boolean 是否成功更新
     * @author 香宁雨
     * @since 13:40 2021-10-19
     */
    public boolean update(String type, Double weight, Status state) {
        if (state == Status.IN) {
            Integer index = indexOfRawMaterial(type);
            Double curWeight = rawMaterial.getJSONObject(index).getDouble("weight");
            curWeight += weight;
            rawMaterial.getJSONObject(index).put("weight", curWeight);
            return true;
        } else {
            Integer index = indexOfRawMaterial(type);
            Double curWeight = rawMaterial.getJSONObject(index).getDouble("weight");
            if (Double.doubleToLongBits(curWeight) >= Double.doubleToLongBits(weight)) {
                curWeight -= weight;
                rawMaterial.getJSONObject(index).put("weight", curWeight);
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
    public boolean getIngredient(JSONObject material) {
        String type = material.getString("ingredientType");
        Double weight = material.getDouble("weight");
        System.out.println(update(type, weight, Status.OUT));
        if (update(type, weight, Status.OUT)) return true;
        return false;
    }

    /**
     * 采购流程的测试函数
     * @param args main函数参数args
     */
    public static void main(String[] args) {
        // 设置语言
        OutputManager.getInstance().setLanguage(OutputManager.Lang.zh_CN);

        //创建购买需求
        JSONArray demand = new JSONArray();

        JSONObject apple = new JSONObject();
        apple.put("ingredientType", "apple");
        apple.put("weight", 10.0);
        JSONObject clove = new JSONObject();
        clove.put("ingredientType", "clove");
        clove.put("weight", 20.0);
        JSONObject peach = new JSONObject();
        peach.put("ingredientType", "peach");
        peach.put("weight", 30.0);
        JSONObject pear = new JSONObject();
        pear.put("ingredientType", "pear");
        pear.put("weight", 40.0);
        JSONObject salmon = new JSONObject();
        salmon.put("ingredientType", "salmon");
        salmon.put("weight", 50.0);

        demand.put(apple);
        demand.put(clove);
        demand.put(peach);
        demand.put(pear);
        demand.put(salmon);

        //购买
        if(PurchaseDepartment.getInstance().purchaseIngredient(demand)){
            OutputManager.getInstance().print(
                    "采购成功!",
                    "採購成功!",
                    "Purchasing Success! "
            );
        }
        else{
            OutputManager.getInstance().print(
                    "采购失败!",
                    "採購失敗!",
                    "Purchasing Failed!"
            );
        }
    }

}

