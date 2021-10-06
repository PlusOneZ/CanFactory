package Manufacturing.Ingredient;

/**
 * 基础原料，指只有一种内含物的原料
 * <b>作为 Composite模式 的一部分</b>
 * @author 卓正一
 */
public abstract class BaseIngredient implements Ingredient{

    @Override
    public final String showContents() {
        return rawIngredient;
    }

    /**
     * @param ingredientName 原材料的名字
     */
    public BaseIngredient(String ingredientName) {
        rawIngredient = ingredientName;
    }

    protected String rawIngredient;
}
