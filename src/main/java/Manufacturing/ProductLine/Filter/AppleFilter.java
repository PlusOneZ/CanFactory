package Manufacturing.ProductLine.Filter;

import Manufacturing.Ingredient.BaseIngredient;

import java.util.List;

/**
 * TODO:苹果过滤器类,聚合了大小过滤器、质量过滤器,筛选苹果
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:49
 */
public class AppleFilter implements Filter {
    private final WeightFilter weightFilter;

    public AppleFilter(Double weightCriterion) {
        this.weightFilter = new WeightFilter(weightCriterion);
    }

    @Override
    public List<BaseIngredient> select(List<BaseIngredient> baseIngredientList) {
        return weightFilter.select(baseIngredientList);
    }
}
