package Manufacturing.Ingredient.Procedure;

import Manufacturing.Ingredient.ConcreteIngredient.Apple;
import Manufacturing.Ingredient.Ingredient;
import Presentation.Protocol.OutputManager;

/**
 * 煮（原材料），装饰器
 *
 * @author 卓正一
 * @date 2021/10/24 2:49 PM
 */
public class Cook extends Procedure {

    public Cook(Ingredient ingredient) {
        super(ingredient);
        cost = 1.0;
        setName(
                "煮",
                "煮",
                "Cooked"
        );
    }

    /**
     * 测试函数
     * @author 卓正一
     * @since 2021-10-24 3:42 PM
     */
    public static void main(String[] args) {
        OutputManager.getInstance().setLanguage(OutputManager.Lang.en);
        Ingredient i = new Cook(new Apple());
        System.out.println(i.showContents());
    }
}
