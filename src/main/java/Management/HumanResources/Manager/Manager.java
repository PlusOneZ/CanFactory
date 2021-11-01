package Management.HumanResources.Manager;

import Management.HumanResources.BaseEmployee;
import Management.HumanResources.LeaveRequest;
import Presentation.Protocol.OutputManager;

import java.util.Random;

/**
 * 部门经理类
 * @Author 尚丙奇
 * @since 2021-10-16 14:00
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
        OutputManager.getInstance().printPattern(
                "# 使用了责任链模式",
                "# 使用了責任鏈模式",
                "Adopted Chain of Responsibility pattern"
        );

        if(isHappy.nextBoolean()){

            OutputManager.getInstance().print(
                    "部门经理已同意" + request.getName() + request.getDays() + "天的请假申请",
                    "部門經理已同意" + request.getName() + request.getDays() + "天的請假申請",
                    "The department manager have accepted the leave request of" + request.getName() +
                            + request.getDays() + "Days"
            );

            request.setApproveStatus("部门经理已同意申请");
        }
        else{

            OutputManager.getInstance().print(
                    "部门经理已驳回" + request.getName() + request.getDays() + "天的请假申请",
                    "部門經理已駁回" + request.getName() + request.getDays() + "天的請假申請",
                    "The department manager have rejected the leave request of" + request.getName() +
                            + request.getDays() + "Days"
            );

            request.setApproveStatus("部门经理已驳回申请");
        }
    }
}
