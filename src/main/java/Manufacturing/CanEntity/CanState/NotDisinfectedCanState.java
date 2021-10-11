package Manufacturing.CanEntity.CanState;

import Presentation.Protocol.OutputManager;

/**
 * 未消毒状态
 * 罐头一开始被赋予这种状态。
 * @author 卓正一
 */
public class NotDisinfectedCanState extends CanState {

    @Override
    public boolean isDisinfected() {
        return false;
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
        // 未来可以填充逻辑
        return new DisinfectedAndNotFilledCanState();
    }

    @Override
    public CanState handleFilling() {
        OutputManager.getInstance().errorMassage(
                "尝试给未消毒罐头填充内容！",
                "嘗試給未消毒罐頭填充原料！",
                "Trying to fill a not-disinfected can!"
        );
        return new ErrorCanState(true, isCanned(), isDisinfected(), "给未消毒罐头填充内容");
    }

    @Override
    public CanState handleCanning() {
        OutputManager.getInstance().errorMassage(
                "尝试封罐未消毒罐头！",
                "嘗試封罐未消毒罐頭！",
                "Trying to can a not-disinfected can!"
        );
        return new ErrorCanState(isFilled(), true, isDisinfected(), "封罐未消毒罐头");
    }

    @Override
    public String getCanDescription() {
        return "未消毒";
    }
}
