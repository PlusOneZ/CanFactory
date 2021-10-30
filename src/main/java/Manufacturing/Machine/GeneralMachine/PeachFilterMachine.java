package Manufacturing.Machine.GeneralMachine;

import Manufacturing.Ingredient.ConcreteIngredient.Peach;
import Manufacturing.Ingredient.Ingredient;
import Manufacturing.Machine.IngredientMachine;

/**
 * 黄桃过滤器，筛选是黄桃并且质量符合要求的黄桃
 *
 * @author 孟繁霖
 * @date 2021/10/30 19:19
 */
public class PeachFilterMachine implements IngredientMachine {

    private final FilterMachine filterMachine=new FilterMachine(150.0);

    @Override
    public Ingredient treat(Ingredient ingredient) {
        if(ingredient instanceof Peach){
            return filterMachine.treat(ingredient);
        }
        return null;
    }
}
