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
public class Fry extends BaseIngredient {
    @Override
    public String zhCnDescription() {
        return "炸" + dealtIngredient.zhCnDescription();
    }

    @Override
    public String zhTwDescription() {
        return "炸" + dealtIngredient.zhTwDescription();
    }

    @Override
    public String enDescription() {
        return "Fried " + dealtIngredient.enDescription();
    }

    Fry(Ingredient ingredient) {
        this.dealtIngredient = ingredient;
    }

    Ingredient dealtIngredient;

    @Override
    public String showContents() {
        return OutputManager.getInstance().selectStringForCurrentLanguage(
                "炸",
                "炸",
                "Fried "
        ) + dealtIngredient.showContents();
    }

    /**
     * 测试函数
     * @author 卓正一
     * @since 2021-10-24 3:42 PM
     */
    public static void main(String[] args) {
        OutputManager.getInstance().setLanguage(OutputManager.Lang.en);
        Ingredient i = new Fry(new CandiedApple(new Apple(), new Sugar()));
        System.out.println(i.showContents());
    }
}
