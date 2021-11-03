package Manufacturing.Ingredient.Procedure;

import Manufacturing.Ingredient.ConcreteIngredient.Apple;
import Manufacturing.Ingredient.Ingredient;
import Presentation.Protocol.IOManager;

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

        Ingredient apple = new Apple();

        IOManager.getInstance().printBrief(
                "基础原料：",
                "基礎原料：",
                "Base ingredient: ",
                apple.showContents()
        );

        Ingredient cookedApple = new Cook(apple);

        IOManager.getInstance().printBrief(
                "处理过的原料：",
                "處理過的原料：",
                "Processed ingredient: ",
                cookedApple.showContents()
        );

    }
}
