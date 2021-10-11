package Manufacturing.CanEntity;

import Management.QualityTesting.Protocol.Testable;
import Manufacturing.CanEntity.CanState.CanState;
import Manufacturing.CanEntity.CanState.ErrorCanState;
import Manufacturing.Ingredient.Ingredient;

import java.util.List;


/**
 * 罐头是流水线中的最终产物，它是由"ingredients"装填而来的。
 * 罐头在处理中通过状态（而不是 if-else 语句）来控制其受操作的变化。 <br>
 * <b>实现了 State 模式</b> <br>
 * <b>内含了 Composite 模式实体</b> <br>
 * <b>实现了 Decorator 模式</b>
 * <b>实现了 Servant 模式</b>
 * <b>实现了 Template Method 模式</b>
 * @author 卓正一
 */
public abstract class Can implements Testable {

    /**
     * 罐头状态，实现了状态模式
     * @since 2021-10-11 10:34 PM
     */
    protected CanState state;

    /**
     * 罐头内部含有的
     * @since 2021-10-11 10:35 PM
     */
    protected List<Ingredient> ingredients;

    @Override
    public final boolean getQualityTest() {
        if (state instanceof ErrorCanState) return false;
        return state.isCanned()
                && state.isDisinfected()
                && state.isFilled()
                && otherTests();
    }

    @Override
    public final boolean getSafetyTest() {
        if (state instanceof ErrorCanState) return false;
        return state.isDisinfected();
        // TODO: 通过测试机器进行
    }

    /**
     * 罐头完成其他特殊测试的接口。
     * @return : boolean 是否通过测试。
     * @author 卓正一
     * @since 2021-10-11 11:05 PM
     */
    abstract public boolean otherTests();

    /**
     * 以下三属性是为了多语言输出准备的。
     * @since 2021-10-11 11:02 PM
     */
    private String zhCnName;
    private String zhTwName;
    private String enName;

    /**
     * 设置多语言输出字符。
     * @param zhCnName 中文名
     * @param zhTwName 繁体中文名
     * @param enName 英文名
     * @author 卓正一
     * @since 2021-10-11 11:03 PM
     */
    public void setName(String zhCnName, String zhTwName, String enName) {
        this.zhCnName = zhCnName;
        this.zhTwName = zhTwName;
        this.enName = enName;
    }

    @Override
    public String enDescription() {
        return enName;
    }

    @Override
    public String zhCnDescription() {
        return zhCnName;
    }

    @Override
    public String zhTwDescription() {
        return zhTwName;
    }
}
