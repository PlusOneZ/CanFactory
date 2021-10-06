package Manufacturing.CanEntity.CanState;

/**
 * @author 卓正一
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
