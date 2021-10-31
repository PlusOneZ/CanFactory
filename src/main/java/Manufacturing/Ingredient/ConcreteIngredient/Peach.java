package Manufacturing.Ingredient.ConcreteIngredient;

import Manufacturing.Ingredient.BaseIngredient;

/**
 * 黄桃罐头原材料
 *
 * @author 孟繁霖
 * @date 2021/10/25 14:04
 */
public class Peach extends BaseIngredient {
    public Peach() {
        this.setName(
                "黄桃",
                "黃桃",
                "Peach"
        );
        setCost(6.3);
    }
}
