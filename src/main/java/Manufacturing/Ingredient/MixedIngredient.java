package Manufacturing.Ingredient;

import java.util.Arrays;
import java.util.List;

/**
 * 混合原料，指多种原料混合的罐头成分。
 * <b>作为 Composite模式 的一部分</b>
 * @author 卓正一
 */
public abstract class MixedIngredient implements Ingredient {

    /**
     * 打印时默认对原料清单内的内容递归调用 showContents。
     * @return 混合原料的内容物。
     */
    @Override
    public final String showContents() {
        StringBuilder ret = new StringBuilder(ingredientName + "(");
        for (Ingredient i : contentIngredients ) {
            ret.append(i.showContents());
        }
        return ret.toString();
    }

    /**
     * 混合原料构造器
     * @param name 原料本身的名字
     * @param ingredients 组成这个原料的所有子原料，通过变长参数列表传入。
     */
    public MixedIngredient(String name, Ingredient... ingredients) {
        ingredientName = name;
        contentIngredients = Arrays.asList(ingredients);
    }

    protected String ingredientName;
    protected List<Ingredient> contentIngredients;
}
