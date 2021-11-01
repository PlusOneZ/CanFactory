package Management.HumanResources.Staff;

import Management.HumanResources.BaseEmployee;
import Management.HumanResources.LeaveRequest;
import Presentation.Protocol.OutputManager;

/**
 * 普通工人类
 * @author 尚丙奇
 * @since 2021-10-16 14:00
 */
public abstract class Staff extends BaseEmployee {

    /**
     * 员工无法处理自己的请假请求，通过责任链传递给其直接的leader
     * @param request 员工的请假请求
     * @author 尚丙奇
     * @since 2021-10-16 14:00
     */
    @Override
    public void handleRequest(LeaveRequest request) {
        OutputManager.getInstance().printPattern(
                "# 使用了责任链模式",
                "# 使用了責任鏈模式",
                "Adopted Chain of Responsibility pattern"
                );

        OutputManager.getInstance().print(
                "员工无权处理自己的请假请求，已传达至组长",
                "員工無權處理自己的請假請求，已傳達至組長",
                "The request have been forwarded to the team leader."
        );

        leader.handleRequest(request);

    }


}
