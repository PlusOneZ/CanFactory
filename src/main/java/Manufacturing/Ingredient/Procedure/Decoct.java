package Manufacturing.Ingredient.Procedure;

import Manufacturing.Ingredient.ConcreteIngredient.Beef;
import Manufacturing.Ingredient.Ingredient;

/**
 * TODO:此处写Decoct类的描述
 *
 * @author 卓正一
 * @date 2021/10/24 5:03 PM
 */
public class Decoct extends Procedure {

    Decoct(Ingredient ingredient) {
        super(ingredient);
        setName(
                "煎",
                "煎",
                "Decocted "
        );
    }

    /**
     * 测试函数
     *
     * @author 卓正一
     * @since 2021-10-24 3:42 PM
     */
    public static void main(String[] args) {
        Ingredient i = new Decoct(new Beef());
        System.out.println(i.showContents());
    }
}
