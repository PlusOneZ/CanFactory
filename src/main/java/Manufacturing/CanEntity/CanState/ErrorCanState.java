package Manufacturing.CanEntity.CanState;

/**
 * 错误状态，遇到这个状态，说明某些步骤顺序错了。
 * @author 卓正一
 */
public final class ErrorCanState extends CanState{

    /**
     * ErrorCanState 有办法记录当前罐头的状态，但是当这个状态出现时，说明某些步骤的顺序已经出错。
     * @param filled 当前罐头是否被装填
     * @param canned 当前罐头是否被封装
     * @param disinfected 当前罐头是否被消毒
     * @param description
     */
    public ErrorCanState(boolean filled, boolean canned, boolean disinfected, String description) {
        this.filled = filled;
        this.canned = canned;
        this.disinfected = disinfected;
        this.description = description;
    }

    @Override
    public boolean isDisinfected() {
        return disinfected;
    }

    @Override
    public boolean isFilled() {
        return filled;
    }

    @Override
    public boolean isCanned() {
        return canned;
    }

    @Override
    public CanState handleDisinfection() {
        disinfected = true;
        return this;
    }

    @Override
    public CanState handleFilling() {
        filled = true;
        return this;
    }

    @Override
    public CanState handleCanning() {
        canned = true;
        return this;
    }

    @Override
    public String getCanDescription() {
        return description;
    }

    private boolean filled;
    private boolean canned;
    private boolean disinfected;
    private final String description;
}
