package Manufacturing.CanEntity;

import Management.QualityTesting.Protocol.Testable;
import Manufacturing.CanEntity.CanState.CanState;
import Manufacturing.CanEntity.CanState.ErrorCanState;
import Manufacturing.CanEntity.CanState.NotDisinfectedCanState;
import Manufacturing.CanEntity.Material.Material;
import Manufacturing.CanEntity.Size.Size;
import Manufacturing.Ingredient.Ingredient;
import Presentation.Protocol.OutputManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 罐头是流水线中的最终产物，它是由"ingredients"装填而来的。<br>
 * 罐头在处理中通过状态（而不是 if-else 语句）来控制其受操作的变化。 <br>
 * <p>
 * 罐头有以下参数：
 * <ol>
 *     <li>state：罐头的状态，消毒、装填等</li>
 *     <li>ingredients：罐头内部的原料</li>
 *     <li>size：罐头尺寸</li>
 *     <li>material：罐头包装的材质</li>
 *     <li>zhCnName：简体中文名</li>
 *     <li>zhTwName：繁体中文名</li>
 *     <li>enName：英文名</li>
 * </ol>
 *
 * <b>实现了 State 模式</b> <br>
 * <b>内含了 Composite 模式实体</b> <br>
 * <b>实现了 Decorator 模式</b>
 * <b>实现了 Servant 模式</b>
 * <b>实现了 Template Method 模式</b>
 *
 * @author 卓正一
 */
public abstract class Can implements Testable,Cloneable {

    /**
     * 罐头状态，实现了状态模式
     *
     * @since 2021-10-11 10:34 PM
     */
    private CanState state;

    /**
     * 罐头内部含有的
     *
     * @since 2021-10-11 10:35 PM
     */
    List<Ingredient> ingredients;


    /**
     * 罐头大小，桥接模式。
     * 实现：汪明杰
     *
     * @since 2021-10-12 4:01 PM
     */
    private Size size;

    /**
     * 罐头材质，桥接模式。
     * 实现：汪明杰
     *
     * @since 2021-10-12 4:01 PM
     */
    private Material material;

    /**
     * 以下三属性是为了多语言输出准备的。
     *
     * @since 2021-10-11 11:02 PM
     */
    private String zhCnName;
    private String zhTwName;
    private String enName;

    /**
     * 保质时间
     * 实现：汪明杰
     * @since 2021-10-12 4:54 PM
     */
    private Date shelfTime;

    /**
     * 生产时间
     * 实现：汪明杰
     * @since 2021-10-12 4:55 PM
     */
    private Date manufactureTime;

    /**
     * 最高储存温度
     * 实现：汪明杰
     * @since 2021-10-12 4:55 PM
     */
    private int maxTemperature;

    /**
     * 最低储存温度
     * 实现：汪明杰
     * @since 2021-10-12 4:55 PM
     */
    private int minTemperature;


    protected Can() {
        ingredients = new ArrayList<Ingredient>();
        state = new NotDisinfectedCanState();
    }


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
     * 判断是否过期
     * @return : boolean
     * @author 汪明杰
     * @since 2021-10-12 4:56 PM
     */
    public boolean isOverdue(){
        // TODO: 获取公有类的当前时间后，判断罐头是否过期

        return true;
    }

    /**
     * 判断温度是否合适
     * @return : boolean
     * @author 汪明杰
     * @since 2021-10-12 4:56 PM
     */
    public boolean isTemperatureAppropriate(){
        // TODO: 获取储存箱的温度，判断储存环境是否合适
        return true;
    }

    /**
     * 接受封罐
     * @author 卓正一
     * @since 2021-10-12 4:34 PM
     */
    public void getCanned() {
        state = state.handleCanning();
    }

    /**
     * 接受填料
     * @param ingredient 填充的一种原料
     * @author 卓正一
     * @since 2021-10-12 4:34 PM
     */
    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
        state = state.handleFilling();
    }

    /**
     * 接受消毒
     * @author 卓正一
     * @since 2021-10-12 4:35 PM
     */
    public void getDisinfection() {
        state = state.handleDisinfection();
    }

    /**
     * 罐头完成其他特殊测试的接口。
     *
     * @return : boolean 是否通过测试。
     * @author 卓正一
     * @since 2021-10-11 11:05 PM
     */
    public boolean otherTests() {
        return true;
    }

    /**
     * TODO: 打印大小、材质的信息
     * @return : java.lang.String
     * @author 卓正一
     * @since 2021-10-12 4:32 PM
     */
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


    // -------------------- getters and setters ------------------------- //



    /**
     * 获取罐头的状态
     *
     * @return : Manufacturing.CanEntity.CanState.CanState
     * @author 梁乔
     * @since 22:40 2021-10-11
     */
    public CanState getCanState() {
        return state;
    }

    /**
     * 设置多语言输出字符。
     *
     * @param zhCnName 中文名
     * @param zhTwName 繁体中文名
     * @param enName   英文名
     * @author 卓正一
     * @since 2021-10-11 11:03 PM
     */
    public void setName(String zhCnName, String zhTwName, String enName) {
        this.zhCnName = zhCnName;
        this.zhTwName = zhTwName;
        this.enName = enName;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Material getMaterial() {
        return material;
    }

    /**
     * 返回当前语言的罐头名字
     *
     * @return : java.lang.String 罐头名
     * @author 卓正一
     * @since 2021-10-12 3:44 PM
     */
    public String getCanName() {
        switch (OutputManager.getInstance().getLanguage()) {
            case zh_CN:
                return zhCnName;
            case zh_TW:
                return zhTwName;
            case en:
                return enName;
        }
        return "";
    }

    public Date getShelfTime() {
        return shelfTime;
    }

    public void setShelfTime(Date shelfTime) {
        this.shelfTime = shelfTime;
    }

    public Date getManufactureTime() {
        return manufactureTime;
    }

    public void setManufactureTime(Date manufactureTime) {
        this.manufactureTime = manufactureTime;
    }

    public int getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(int maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public int getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(int minTemperature) {
        this.minTemperature = minTemperature;
    }


    //获取罐头的售价,默认售价为成本价钱的1.5倍
    public double getCanCost() {
        double cost = 0.;
        for (Ingredient i :
                ingredients) {
            cost += i.getCost();
        }
        return cost*1.5;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder(getCanName() +
                OutputManager.getInstance().selectStringForCurrentLanguage(
                        "；配料：",
                        "；配料：",
                        "; Ingredients: "
                ));
        for (Ingredient in : ingredients) {
            ret.append(in.showContents());
        }
        return ret.toString();
    }

    /**
     * 克隆一个罐头
     * 享元模式
     * @return : Can
     * @author 汪明杰
     * @since 2021-10-29 9:02 PM
     */
    public Can Clone(){
        try {
            Can newCan = (Can)this.clone();

            // 深拷贝原料
            newCan.ingredients = new ArrayList<>();
            newCan.shelfTime = new Date();
            newCan.manufactureTime = new Date();

            return newCan;
        } catch (CloneNotSupportedException e) {
            OutputManager.getInstance().errorMassage(
                    "罐头克隆失败！",
                    "罐頭尅隆失敗！",
                    "Fail to clone the can!"
            );
            return null;
        }
    }
}
