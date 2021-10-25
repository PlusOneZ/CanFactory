package Manufacturing.ProductLine.Pretreatment;


import Manufacturing.Ingredient.BaseIngredient;

import java.util.List;

/**
 * TODO:Pretreatment 预处理接口
 *
 * @author 孟繁霖
 * @date 2021-10-11 23:27
 */
public interface Pretreatment {
    /**
     * TODO:处理方法，对原料列表预处理
     *
     * @param baseIngredientList :  原材料列表
     * @return : java.util.List<Manufacturing.ProductLine.Fruit.RawMaterial>
     * @author 孟繁霖
     * @date 2021-10-11 23:28
     */
    List<BaseIngredient> treat(List<BaseIngredient> baseIngredientList);
}
