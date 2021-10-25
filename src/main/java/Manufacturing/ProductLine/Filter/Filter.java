package Manufacturing.ProductLine.Filter;

import Manufacturing.Ingredient.BaseIngredient;

import java.util.List;

/**
 * TODO:过滤器接口.<br>
 * <b>实现了过滤器模式</b>
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:46
 */
public interface Filter {

    /**
     * TODO:过滤筛选方法.
     *
     * @param baseIngredientList :  待筛选过滤的原材料列表
     * @return : java.util.List<Manufacturing.ProductLine.Fruit.RawMaterial>
     * @author 孟繁霖
     * @date 2021-10-12 8:48
     */
    List<BaseIngredient> select(List<BaseIngredient> baseIngredientList);
}
