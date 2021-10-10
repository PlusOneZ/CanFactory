package Management.HumanResources;

import java.util.Random;

/**
 * @Author 尚丙奇
 */
public class Manager extends BaseEmployee{

    private Random isHappy = new Random();
    /**
     * 部门经理处理组长无法处理的请假请求
     * @param request 员工请假请求
     */
    @Override
    public void handleRequest(LeaveRequest request) {
        if(isHappy.nextBoolean()){
            request.setApproveStatus("部门经理已同意申请");
        }
        else{
            request.setApproveStatus("部门经理已驳回申请");
        }
    }
}
