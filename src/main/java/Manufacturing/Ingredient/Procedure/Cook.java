package Manufacturing.Ingredient.Procedure;

import Manufacturing.Ingredient.Ingredient;
import Presentation.Protocol.IOManager;

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
        IOManager.getInstance().print(
                "# 使用了装饰器模式：煮了一个",
                "# 使用了裝飾器模式：煮了一個",
                "# Using Decorator Pattern: cook a ",
                ingredient.showContents()
        );
    }
}
