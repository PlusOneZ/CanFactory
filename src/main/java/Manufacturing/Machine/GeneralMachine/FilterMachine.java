package Manufacturing.Machine.GeneralMachine;

import Manufacturing.Ingredient.Ingredient;
import Manufacturing.Machine.IngredientMachine;

/**
 * 筛选机器，可能会返回 null
 *
 * @author 卓正一
 * @since  2021/10/26 12:23 AM
 */
public class FilterMachine implements IngredientMachine {

    public FilterMachine(double criteria) {
        this.criteria = criteria;
    }

    private double criteria;

    @Override
    public Ingredient treat(Ingredient ingredient) {

        if (ingredient.getWeight() >= criteria)
            return ingredient;
        return null;

    }
}
