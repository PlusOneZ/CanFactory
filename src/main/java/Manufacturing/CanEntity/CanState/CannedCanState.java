package Manufacturing.CanEntity.CanState;

import Presentation.Protocol.IOManager;

/**
 * 正常封罐的罐头
 * @author 卓正一
 */
public class CannedCanState extends CanState{
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
        return true;
    }

    @Override
    public CanState handleDisinfection() {
        IOManager.getInstance().errorMassage(
                "消毒已封装罐头！",
                "消毒已封裝罐頭！",
                "Canned can get disinfected!"
        );
        // 因为装好了所以不是错误状态
        return this;
    }

    @Override
    public CanState handleFilling() {
        IOManager.getInstance().errorMassage(
                "尝试装填已封罐罐头！",
                "嘗試裝填已封罐罐頭！",
                "Canned can get filled!"
        );
        return new ErrorCanState(true, true, true, "装填已封罐罐头");
    }

    @Override
    public CanState handleCanning() {
        IOManager.getInstance().errorMassage(
                "重复封罐！",
                "重複封罐！",
                "Canning step repeated!"
        );
        return new ErrorCanState(true, true, true, "重复封罐");
    }

    @Override
    public String getCanDescription() {
        return "正常封罐";
    }
}
