package Manufacturing.ProductLine;


import Manufacturing.Ingredient.BaseIngredient;
import Manufacturing.ProductLine.RawMaterial.*;
import jdk.swing.interop.SwingInterOpUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * TODO:供应商
 *
 * @author 孟繁霖
 * @date 2021-10-11 23:51
 */
public class Supplier {

    /**
     * TODO:提供原料
     *
     * @param kind  : 原料所属种类（fruit,fresh）
     * @param count :  原料数量
     * @return : java.util.List<Manufacturing.ProductLine.Fruit.RawMaterial>
     * @author 孟繁霖
     * @date 2021-10-11 23:51
     */
    public List<RawMaterial> provide(String kind, int count) {
        List<RawMaterial> rawMaterialList = new ArrayList<>();
        List<BaseIngredient> baseIngredientList=new ArrayList<>();
        JSONObject object = new JSONObject();
        object.put("ingredientType",kind);
        object.put("count",count);
        JSONArray ingredients=PurchaseDepartment.getInstance().getIngredient(object);
        if(ingredients==null){
            return null;
        }
        if("apple".equals(kind)){
            for (int i = 0; i < count; i++) {
                Manufacturing.Ingredient.ConcreteIngredient.Apple apple =new Manufacturing.Ingredient.ConcreteIngredient.Apple();
                apple.setWeight(ingredients.getDouble(i));
                baseIngredientList.add(apple);
                System.out.println(apple.zhCnDescription());
            }
        }


        if ("apple".equals(kind)) {
            for (int i = 0; i < count; i++) {
                rawMaterialList.add(new Apple(ingredients.getDouble(i)));
            }
        } else if ("pear".equals(kind)) {

            for (int i = 0; i < count; i++) {
                rawMaterialList.add(new Pear(ingredients.getDouble(i)));
            }
        } else if ("peach".equals(kind)) {
            for (int i = 0; i < count; i++) {
                rawMaterialList.add(new Peach(ingredients.getDouble(i)));
            }
        } else if ("salmon".equals(kind)) {
            for (int i = 0; i < count; i++) {
                rawMaterialList.add(new Salmon(ingredients.getDouble(i)));
            }
        } else if ("clove".equals(kind)) {
            for (int i = 0; i < count; i++) {
                rawMaterialList.add(new Clove(ingredients.getDouble(i)));
            }
        } else return null;
        return rawMaterialList;
    }
}
