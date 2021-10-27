package Manufacturing.Ingredient.ConcreteIngredient.Mixed;

import Manufacturing.Ingredient.ConcreteIngredient.Apple;
import Manufacturing.Ingredient.ConcreteIngredient.Seasoning.Sugar;
import Manufacturing.Ingredient.MixedIngredient;

/**
 * 糖渍苹果
 * @author 卓正一
 * @date 2021/10/24 4:50 PM
 */
public class CandiedApple extends MixedIngredient {

    public CandiedApple(Apple apple, Sugar sugar) {
        super(apple, sugar);
        setName(
                "糖渍苹果",
                "糖漬蘋果",
                "Candied Apple"
        );
    }

}
