package Management.HumanResources;

import Management.HumanResources.BaseEmployee;
/**
 * @Author 尚丙奇
 */
public class Worker extends BaseEmployee{

    /**
     * 员工无法处理自己的请假请求，通过责任链传递给其直接的leader
     * @param request 员工的请假请求
     */
    @Override
    public void handleRequest(LeaveRequest request) {
        leader.handleRequest(request);
    }
}
