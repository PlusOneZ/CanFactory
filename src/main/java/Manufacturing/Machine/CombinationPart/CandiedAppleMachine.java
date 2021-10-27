package Manufacturing.Machine.CombinationPart;

import Manufacturing.Ingredient.ConcreteIngredient.Apple;
import Manufacturing.Ingredient.ConcreteIngredient.CandiedApple;
import Manufacturing.Ingredient.ConcreteIngredient.Sugar;
import Manufacturing.Ingredient.Ingredient;
import Manufacturing.Machine.Machine;
import Presentation.Protocol.OutputManager;

/**
 * TODO:此处写CandiedAppleMachine类的描述
 *
 * @author 卓正一
 * @date 2021/10/27 9:07 PM
 */
public class CandiedAppleMachine implements Machine {
    @Override
    public Ingredient treat(Ingredient ingredient) {
        // 不会发生任何事
        return ingredient;
    }

    @Override
    public Ingredient combine(Ingredient... ingredients) {
        Ingredient[] ingredientList = ingredients.clone();
        if (ingredientList[0] instanceof Apple) {
            if (ingredientList[1] instanceof Sugar) {
                return new CandiedApple((Apple) ingredientList[0], (Sugar) ingredientList[1]);
            }
        }

        OutputManager.getInstance().errorMassage(
                "检测到错误，不能生产糖渍苹果！",
                "檢測到錯誤，不能生產糖漬蘋果！",
                "Error detected, cannot produce candied apple!"
        );

        return null;
    }


    public static void main(String[] args) {
        Machine appleMachine = new CandiedAppleMachine();
        Apple apple = new Apple();
        Sugar sugar = new Sugar();
        Ingredient candiedApple = appleMachine.combine(apple, sugar);
        System.out.println(candiedApple.showContentsWithWeight());
    }
}
