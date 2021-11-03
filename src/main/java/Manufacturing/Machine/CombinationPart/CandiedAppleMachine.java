package Manufacturing.Machine.CombinationPart;

import Manufacturing.Ingredient.ConcreteIngredient.Apple;
import Manufacturing.Ingredient.ConcreteIngredient.Mixed.CandiedApple;
import Manufacturing.Ingredient.ConcreteIngredient.Seasoning.Sugar;
import Manufacturing.Ingredient.Ingredient;
import Manufacturing.Machine.IngredientMachine;

/**
 * TODO:此处写CandiedAppleMachine类的描述
 *
 * @author 卓正一
 * @date 2021/10/27 9:07 PM
 */
public class CandiedAppleMachine implements IngredientMachine {

    @Override
    public Ingredient treat(Ingredient ingredient) {
        // 不会发生任何事
        return ingredient;
    }

    /**
     * 将苹果和糖合并成糖渍苹果
     * @return : 一个糖渍苹果
     * @author 卓正一
     * @since 2021-10-27 10:19 PM
     */
    @Override
    public Ingredient combine(Ingredient... ingredients) {
        Ingredient[] ingredientList = ingredients.clone();
        return new CandiedApple(ingredientList[0], ingredientList[1]);

        
    }


    public static void main(String[] args) {
        IngredientMachine appleMachine = new CandiedAppleMachine();
        Apple apple = new Apple();
        Sugar sugar = new Sugar();
        Ingredient candiedApple = appleMachine.combine(apple, sugar);
        System.out.println(candiedApple.showContentsWithWeight());
    }
}
