package Manufacturing.Ingredient;

import Manufacturing.Ingredient.ConcreteIngredient.Apple;
import Manufacturing.Ingredient.ConcreteIngredient.Mixed.CandiedApple;
import Manufacturing.Ingredient.ConcreteIngredient.Seasoning.Sugar;
import Presentation.Protocol.IOManager;

/**
 * 组合模式测试
 *
 * @author 卓正一
 * @since  2021/11/2 4:38 PM
 */
public class CompositeTest {
    public static void main(String[] args) {
        IOManager.getInstance().printBrief(
                "---组合模式测试---",
                "---組合模式測試---",
                "---Composite Pattern Test---"
        );

        Ingredient apple = new Apple();
        Ingredient sugar = new Sugar();

        IOManager.getInstance().printBrief(
                "基础原料#1：",
                "基礎原料#1：",
                "Base ingredient #1: ",
                apple.showContents()
        );

        IOManager.getInstance().printBrief(
                "基础原料#2：",
                "基礎原料#2：",
                "Base ingredient #2: ",
                sugar.showContents()
        );

        Ingredient candiedApple = new CandiedApple(apple, sugar);

        IOManager.getInstance().printBrief(
                "组合的原料：",
                "組合的原料：",
                "Composite ingredient: ",
                candiedApple.showContents()
        );
        IOManager.getInstance().printBrief(
                "---组合模式测试结束---",
                "---組合模式測試結束---",
                "---Composite Pattern Test End---"
        );
    }
}
