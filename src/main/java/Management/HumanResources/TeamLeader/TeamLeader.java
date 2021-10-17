package Management.HumanResources.TeamLeader;

import Management.HumanResources.BaseEmployee;
import Management.HumanResources.LeaveRequest;

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

        }
        else {
            leader.handleRequest(request);
        }
    }
}
