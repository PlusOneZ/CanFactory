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
     * @param canName  : 原料
     * @param count :  原料数量
     * @return : java.util.List<Manufacturing.ProductLine.Fruit.RawMaterial>
     * @author 孟繁霖
     * @date 2021-10-11 23:51
     */
    public List<Ingredient> provide(String canName, int count) {

        List<Ingredient> baseIngredientList=new ArrayList<>();
        JSONObject object = new JSONObject();
        object.put("ingredientType",canName);
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
        if ("peach".equals(canName)) {
            for (int i = 0; i < count; i++) {
                Peach peach=new Peach();
                peach.setWeight(ingredients.getDouble(i));
                baseIngredientList.add(peach);
            }
        } else if ("salmon".equals(canName)) {
            for (int i = 0; i < count; i++) {
                Salmon salmon=new Salmon();
                salmon.setWeight(ingredients.getDouble(i));
                baseIngredientList.add(salmon);
            }
        } else if ("herring".equals(canName)) {
            for (int i = 0; i < count; i++) {
                Herring herring =new Herring();
                herring.setWeight(ingredients.getDouble(i));
                baseIngredientList.add(herring);
            }
        } else return null;
        return baseIngredientList;
    }
}
