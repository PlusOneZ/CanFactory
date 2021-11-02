package Manufacturing.Ingredient.Procedure;

import Manufacturing.Ingredient.ConcreteIngredient.Apple;
import Manufacturing.Ingredient.Ingredient;
import Presentation.Protocol.OutputManager;

/**
 * 测试装饰器模式
 *
 * @author 卓正一
 * @since  2021/11/2 3:34 PM
 */
public class DecoratorTest {

    /**
     * 测试函数
     * @author 卓正一
     * @since 2021-10-24 3:42 PM
     */
    public static void main(String[] args) {
        OutputManager.getInstance().printBrief(
                "---装饰器模式测试---",
                "---裝飾器模式測試---",
                "---Decorator Pattern Test---"
        );
        Ingredient apple = new Apple();

        OutputManager.getInstance().printBrief(
                "基础原料：",
                "基礎原料：",
                "Base ingredient: "
        );

        Ingredient cookedApple = new Cook(apple);

        OutputManager.getInstance().printBrief(
                "处理过的原料：" + cookedApple.showContents(),
                "處理過的原料：",
                "Processed ingredient: "
        );
    }
}
