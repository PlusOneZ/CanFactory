package Manufacturing.CanEntity.CanState;

/**
 * 罐头的状态
 * <b>实现了状态模式</b>
 * @author 卓正一
 * @since 2021-10-11 10:18 PM
 */
public abstract class CanState {

    /**
     * @return 是否被消毒
     */
    public abstract boolean isDisinfected();

    /**
     * @return 是否被填充
     */
    public abstract boolean isFilled();

    /**
     * @return 是否被封口
     */
    public abstract boolean isCanned();


    /**
     * 当罐头被消毒时，对状态调用这个函数。
     * @return 下一个状态，若错误应该返回 ErrorState。
     */
    public abstract CanState handleDisinfection();

    /**
     * 当罐头被填充原料时，对状态调用这个函数。
     * @return 下一个状态，若错误应该返回 ErrorState。
     */
    public abstract CanState handleFilling();

    /**
     * 当罐头被封罐时，对状态调用这个函数。
     * @return 下一个状态，若错误应该返回 ErrorState。
     */
    public abstract CanState handleCanning();

    public abstract String getCanDescription();
}
