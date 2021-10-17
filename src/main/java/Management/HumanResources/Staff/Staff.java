package Management.HumanResources.Staff;

import Management.HumanResources.BaseEmployee;
import Management.HumanResources.LeaveRequest;

import java.util.List;

/**
 * 普通工人类
 * @Author 尚丙奇
 * @date 2021-10-16 14:00
 */
public abstract class Staff extends BaseEmployee {

    /**
     * 员工无法处理自己的请假请求，通过责任链传递给其直接的leader
     * @param request 员工的请假请求
     * @Author 尚丙奇
     * @date 2021-10-16 14:00
     */
    @Override
    public void handleRequest(LeaveRequest request) {
        leader.handleRequest(request);
    }


}
