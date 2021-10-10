package Management.HumanResources;

/**
 * 会计类
 * @Author 尚丙奇
 */

import Management.HumanResources.FinancialSystem.Permission;
import Presentation.Protocol.OutputManager;

public class Accountant extends BaseEmployee implements Permission {

    /**
     * 员工无法处理自己的请假请求，通过责任链传递给其直接的leader
     * @param request 员工的请假请求
     */
    @Override
    public void handleRequest(LeaveRequest request) {
        leader.handleRequest(request);
    }

    /**
     * 访问财务系统
     */
    public void accessFinancialSystem() {
        OutputManager.getInstance().print(
                "会计" + name + "访问了财务系统。",
                "會計" + name + "訪問了財務系統。",
                "Accountant " + name + "accessed the financial system.");
    }
}
