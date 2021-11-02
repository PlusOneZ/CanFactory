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
        OutputManager.getInstance().print(
                "使用了装饰器模式，煮了一个",
                "使用了裝飾器模式，煮了一個",
                "Using the decorator mode, cook a ",
                ingredient.showContents()
        );
    }
}
