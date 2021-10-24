package Management.HumanResources.Staff;


import Management.HumanResources.DepartmentType;
import Management.HumanResources.FinancialSystem.Permission;
import Management.HumanResources.LeaveRequest;
import Presentation.Protocol.OutputManager;

/**
 * 会计类
 * @author 尚丙奇
 * @since 2021-10-16 14:00
 */
public class Accountant extends Staff implements Permission {

    /**
     * 会计类的私有构造函数，在创建时设置其所属的部门。
     */
    private Accountant(){
        setDepartment(DepartmentType.Finance);
    }

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
     * @author 尚丙奇
     * @since 2021-10-16 14:00
     */
    public void accessFinancialSystem() {
        OutputManager.getInstance().print(
                "会计" + name + "访问了财务系统。",
                "會計" + name + "訪問了財務系統。",
                "Accountant " + name + "accessed the financial system.");
    }
}
