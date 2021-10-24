package Manufacturing.Machine;

import Manufacturing.Ingredient.Ingredient;

import java.util.ArrayList;

/**
 * 机器
 * @author 卓正一
 * @since 2021-10-24 11:07 AM
 */
public interface Machine {
    Ingredient treat(Ingredient ingredient);

    Ingredient combine(Ingredient... ingredients);
}
