package Manufacturing.Ingredient;

import Presentation.Protocol.OutputManager;

/**
 * 基础原料，指只有一种内含物的原料
 * <b>作为 Composite模式 的一部分</b>
 *
 * @author 卓正一
 */
public abstract class BaseIngredient implements Ingredient {

    @Override
    public String showContents() {
        return OutputManager.getInstance().selectStringForCurrentLanguage(
                zhCnDescription(),
                zhTwDescription(),
                enDescription()
        );
    }

    @Override
    public String showContentsWithWeight() {
        return OutputManager.getInstance().selectStringForCurrentLanguage(
                zhCnDescription() + "{质量 = " + weight + '}',
                zhTwDescription() + "{質量 = " + weight + '}',
                enDescription() + "{weight = " + weight + '}'
        );
    }

    /**
     * 设置多语言名字
     *
     * @author 卓正一
     * @since 2021-10-12 4:17 PM
     */
    public void setName(String zhCnName, String zhTwName, String enName) {
        this.zhCnName = zhCnName;
        this.zhTwName = zhTwName;
        this.enName = enName;
    }

    /**
     * 以下三属性是为了多语言输出准备的。
     *
     * @since 2021-10-11 11:02 PM
     */
    private String zhCnName;
    private String zhTwName;
    private String enName;


    @Override
    public String zhCnDescription() {
        return zhCnName;
    }

    @Override
    public String zhTwDescription() {
        return zhTwName;
    }

    @Override
    public String enDescription() {
        return enName;
    }

    protected String baseIngredient;

    protected double cost;
    protected double weight;

    @Override
    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
