package
        Manufacturing.Machine.GeneralMachine;

import Manufacturing.Ingredient.ConcreteIngredient.Herring;
import Manufacturing.Ingredient.Ingredient;
import Manufacturing.Machine.IngredientMachine;

/**
 * 鲱鱼过滤器，筛选是鲱鱼并且质量符合要求的鲱鱼
 *
 * @author 孟繁霖
 * @date 2021/10/30 19:27
 */
public class HerringFilterMachine implements IngredientMachine {

    private final FilterMachine filterMachine=new FilterMachine(150.0);

    @Override
    public Ingredient treat(Ingredient ingredient) {
        if(ingredient instanceof Herring){
            return filterMachine.treat(ingredient);
        }
        return null;
    }
}
