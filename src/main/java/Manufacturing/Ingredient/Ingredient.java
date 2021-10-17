package Manufacturing.Ingredient;

import Presentation.Protocol.MultiLanguageDescription;

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
}
