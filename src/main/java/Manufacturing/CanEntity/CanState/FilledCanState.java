package Manufacturing.CanEntity.CanState;

import Presentation.Protocol.IOManager;

/**
 * 装填了内容，但是没有被封罐的状态
 * @author 卓正一
 */
public class FilledCanState extends CanState{

    @Override
    public boolean isDisinfected() {
        return true;
    }

    @Override
    public boolean isFilled() {
        return true;
    }

    @Override
    public boolean isCanned() {
        return false;
    }

    @Override
    public CanState handleDisinfection() {
        IOManager.getInstance().errorMassage(
                "消毒已填充罐头，请检查流水线！",
                "消毒已填充罐頭，請檢查流水線！",
                "Filled (but not canned) can get disinfected, check the product line!"
        );
        return new ErrorCanState(true, false, true, "消毒已填充罐头");
    }

    @Override
    public CanState handleFilling() {
        // 允许填充多样内容物 TODO: 有没有可能被填满？
        return this;
    }

    @Override
    public CanState handleCanning() {

        return new CannedCanState();
    }

    @Override
    public String getCanDescription() {
        return "装填了内容，但是没有被封罐";
    }
}
