package Management.HumanResources.Manager;

import Management.HumanResources.BaseEmployee;
import Management.HumanResources.LeaveRequest;

import java.util.Random;

/**
 * 部门经理类
 * @Author 尚丙奇
 * @date 2021-10-16 14:00
 */

public abstract class Manager extends BaseEmployee {

    /**
     * 一个Random对象
     * 部门的Manager通过是否Happy来审批请假申请
     */
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
