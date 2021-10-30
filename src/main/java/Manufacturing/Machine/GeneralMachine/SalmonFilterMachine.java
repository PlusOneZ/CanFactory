package Manufacturing.Machine.GeneralMachine;

import Manufacturing.Ingredient.ConcreteIngredient.Salmon;
import Manufacturing.Ingredient.Ingredient;
import Manufacturing.Machine.IngredientMachine;

/**
 * 三文鱼过滤器，筛选是三文鱼并且质量符合要求的三文鱼
 *
 * @author 孟繁霖
 * @date 2021/10/30 19:30
 */
public class SalmonFilterMachine implements IngredientMachine {

    private final FilterMachine filterMachine=new FilterMachine(150.0);

    @Override
    public Ingredient treat(Ingredient ingredient) {
        if(ingredient instanceof Salmon){
            return filterMachine.treat(ingredient);
        }
        return null;
    }
}
