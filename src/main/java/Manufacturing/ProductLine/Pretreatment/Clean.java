package Manufacturing.ProductLine.Pretreatment;


import Manufacturing.Ingredient.BaseIngredient;

import java.util.List;

/**
 * TODO:清洗预处理类
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:29
 */
public class Clean implements Pretreatment {
    @Override
    public List<BaseIngredient> treat(List<BaseIngredient> baseIngredientList) {
        return baseIngredientList;
    }
}
