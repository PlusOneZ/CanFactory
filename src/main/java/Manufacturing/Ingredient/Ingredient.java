package Manufacturing.Ingredient;

import Presentation.Protocol.MultiLanguageDescription;
import Presentation.Protocol.IOManager;

/**
 * 原料的接口，
 * <b>作为 Composite模式 的一部分</b>
 * @author 卓正一
 */
public interface Ingredient extends MultiLanguageDescription {

    /**
     * <i>复合原料是递归调用的</i>
     * @return 原料本身是什么的描述
     */
    String showContents();

    String showContentsWithWeight();

    /**
     * 组合模式要求的接口，平时会打印错误并且不让操作，只有在 MixedIngredient 中会被覆盖并且允许添加。
     * @author 卓正一
     * @since 2021-10-24 11:16 AM
     */
    default void addIngredient(Ingredient i) {
        String className = this.getClass().getTypeName();
        IOManager.getInstance().errorMassage(
                className + " 不能增加内含物。",
                className + " 不能增加內含物。",
                className + " cannot have inner ingredients."
        );
    }

    void setName(String zhCnName, String zhTwName, String enName);

    void setCost(double cost);

    void setWeight(double weight);

    double getCost();

    double getWeight();
}
