package Manufacturing.Ingredient.Procedure;

import Manufacturing.CanEntity.Can;
import Manufacturing.Ingredient.BaseIngredient;
import Manufacturing.Ingredient.ConcreteIngredient.Apple;
import Manufacturing.Ingredient.ConcreteIngredient.CandiedApple;
import Manufacturing.Ingredient.ConcreteIngredient.Sugar;
import Manufacturing.Ingredient.Ingredient;
import Presentation.Protocol.OutputManager;

/**
 * TODO:此处写Fry类的描述
 *
 * @author 卓正一
 * @date 2021/10/24 4:44 PM
 */
public class Fry extends Procedure {

    public Fry(Ingredient ingredient) {
        super(ingredient);
        setName(
                "炸",
                "炸",
                "Fried"
        );
    }

    /**
     * 测试函数
     * @author 卓正一
     * @since 2021-10-24 3:42 PM
     */
    public static void main(String[] args) {
        OutputManager.getInstance().setLanguage(OutputManager.Lang.zh_CN);
        Ingredient i = new Fry(new CandiedApple(new Apple(), new Sugar()));
        System.out.println(i.showContents());
    }
}