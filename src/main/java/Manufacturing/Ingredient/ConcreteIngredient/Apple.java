package Manufacturing.Ingredient.ConcreteIngredient;

import Manufacturing.Ingredient.BaseIngredient;

/**
 * TODO:此处写Apple类的描述
 *
 * @author 卓正一
 * @date 2021/10/24 3:38 PM
 */
public class Apple extends BaseIngredient {

    public Apple() {
        this.setName(
                "苹果",
                "蘋果",
                "Apple"
        );

        this.setCost(3.5);
    }

}
