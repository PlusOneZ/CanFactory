package Manufacturing.Ingredient.Procedure;

import Manufacturing.Ingredient.BaseIngredient;
import Manufacturing.Ingredient.ConcreteIngredient.Apple;
import Manufacturing.Ingredient.Ingredient;
import Presentation.Protocol.OutputManager;

/**
 * 煮（原材料），装饰器
 *
 * @author 卓正一
 * @date 2021/10/24 2:49 PM
 */
public class Cook extends BaseIngredient {
    @Override
    public String zhCnDescription() {
        return "煮" + dealtIngredient.zhCnDescription();
    }

    @Override
    public String zhTwDescription() {
        return "煮" + dealtIngredient.zhTwDescription();
    }

    @Override
    public String enDescription() {
        return "Cooked " + dealtIngredient.enDescription();
    }

    Cook(Ingredient ingredient) {
        this.dealtIngredient = ingredient;
    }

    Ingredient dealtIngredient;

    @Override
    public String showContents() {
        return OutputManager.getInstance().selectStringForCurrentLanguage(
                "煮",
                "煮",
                "Cooked "
        ) + dealtIngredient.showContents();
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
