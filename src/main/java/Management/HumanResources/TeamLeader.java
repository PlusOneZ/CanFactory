package Management.HumanResources;

public class TeamLeader extends BaseEmployee{

    public static final int MAX_DAYS_OF_APPROVAL = 2;

    /**
     * 组长可以批准 MAX_DAYS_OF_APPROVAL 天以内的假期，否则需要上一级领导审批
     * @param request 员工的请假请求
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
