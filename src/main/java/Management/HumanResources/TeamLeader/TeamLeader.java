package Management.HumanResources.TeamLeader;

import Management.HumanResources.BaseEmployee;
import Management.HumanResources.LeaveRequest;
import Presentation.Protocol.OutputManager;

/**
 * 组长类
 * @Author 尚丙奇
 * @date 2021-10-16 14:00
 */
public abstract class TeamLeader extends BaseEmployee {

    public static final int MAX_DAYS_OF_APPROVAL = 3;

    /**
     * 组长可以批准 MAX_DAYS_OF_APPROVAL 天以内的假期，否则需要上一级领导审批
     * @param request 员工的请假请求
     * @Author 尚丙奇
     * @date 2021-10-16 14:00
     */
    @Override
    public void handleRequest(LeaveRequest request) {
        if(request.getDays() <= MAX_DAYS_OF_APPROVAL) {
            request.setApproveStatus("组长已同意申请");

            OutputManager.getInstance().print(
                    "组长已同意" + request.getName() + request.getDays() + "天的请假申请",
                    "組長已同意" + request.getName() + request.getDays() + "天的請假申請",
                    "The team leader have accepted the leave request of" + request.getName() + "for"
                            + request.getDays() + "Days"
            );
        }
        else {

            OutputManager.getInstance().print(
                    "组长没有权限批准" + request.getName() + request.getDays() + "天的请假申请，此请求已转达至该部门经理",
                    "組長沒有權限批准" + request.getName() + request.getDays() + "天的請假申請，此請求已轉達至該部門經理",
                    "The team leader have no permission to accept the leave request of" + request.getName()
                            + "for" + request.getDays() + "Days. This request have been forwarded " +
                            "to the department manager."
            );

            leader.handleRequest(request);

        }
    }
}
