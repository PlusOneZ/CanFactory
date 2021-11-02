package Manufacturing.CanEntity.CanState;

import Presentation.Protocol.IOManager;

/**
 * 消毒后，但是没有填充内容的状态。
 * @author 卓正一
 */
public class DisinfectedAndNotFilledCanState extends CanState{

    @Override
    public boolean isDisinfected() {
        return true;
    }

    @Override
    public boolean isFilled() {
        return false;
    }

    @Override
    public boolean isCanned() {
        return false;
    }

    @Override
    public CanState handleDisinfection() {
        IOManager.getInstance().errorMassage(
                "重复消毒！",
                "重複消毒！",
                "Disinfection step repeated!"
        );
        return this;
    }

    @Override
    public CanState handleFilling() {
        return new FilledCanState();
    }

    @Override
    public CanState handleCanning() {
        return null;
    }

    @Override
    public String getCanDescription() {
        return null;
    }
}
