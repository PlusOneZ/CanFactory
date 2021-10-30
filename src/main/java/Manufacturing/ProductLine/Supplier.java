package Manufacturing.ProductLine;


import Manufacturing.Ingredient.Ingredient;
import Manufacturing.Ingredient.ConcreteIngredient.*;

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
    public List<Ingredient> provide(String kind, int count) {

        List<Ingredient> baseIngredientList=new ArrayList<>();
        JSONObject object = new JSONObject();
        object.put("ingredientType",kind);
        object.put("count",count);
        JSONArray ingredients=PurchaseDepartment.getInstance().getIngredient(object);
        if(ingredients==null){
            JSONArray array=new JSONArray();
            array.put(object);
            if(PurchaseDepartment.getInstance().purchaseIngredient(array)){
                ingredients=PurchaseDepartment.getInstance().getIngredient(object);
            }else{
                return null;
            }
        }

        if("apple".equals(kind)){
            for (int i = 0; i < count; i++) {
                Apple apple =new Apple();
                apple.setWeight(ingredients.getDouble(i));
                baseIngredientList.add(apple);
            }
        }
        else if ("pear".equals(kind)) {
            for (int i = 0; i < count; i++) {
                Pear pear=new Pear();
                pear.setWeight(ingredients.getDouble(i));
                baseIngredientList.add(pear);
            }
        } else if ("peach".equals(kind)) {
            for (int i = 0; i < count; i++) {
                Peach peach=new Peach();
                peach.setWeight(ingredients.getDouble(i));
                baseIngredientList.add(peach);
            }
        } else if ("salmon".equals(kind)) {
            for (int i = 0; i < count; i++) {
                Salmon salmon=new Salmon();
                salmon.setWeight(ingredients.getDouble(i));
                baseIngredientList.add(salmon);
            }
        } else if ("clove".equals(kind)) {
            for (int i = 0; i < count; i++) {
                Clove clove=new Clove();
                clove.setWeight(ingredients.getDouble(i));
                baseIngredientList.add(clove);
            }
        } else return null;
        return baseIngredientList;
    }
}
