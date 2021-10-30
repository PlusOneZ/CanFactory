package Management.HumanResources.Staff;

import Management.HumanResources.DepartmentType;
import Management.HumanResources.FinancialSystem.DataAccessObject.SalaryDaoImpl;
import Presentation.Protocol.OutputManager;

/**
 * 审计部门，归于FinancialDept下
 *
 * @author 陈垲昕
 * @since 2021/10/21 9:52 下午
 */

public class Auditor extends Staff {

    SalaryDaoImpl salaryTable = SalaryDaoImpl.getInstance();

    /**
     * 含名字的构造函数
     * @param name : 审计员名字
     * @author 陈垲昕
     * @since 2021-10-21 10:09 下午
     */
    public Auditor(String name){
        super.department= DepartmentType.Finance;
        this.name=name;
    }


    /**
     * 含名字和薪水的构造函数
     * @param name : 审计员名字
     * @param salary :薪水
     * @author 陈垲昕
     * @since 2021-10-17 9:03 下午
     */
    public Auditor(String name,Double salary){
        super.department=DepartmentType.Finance;
        this.name=name;
        this.salary=salary;
    }


    /**
     * 审计员审计Report的操作: 通过脏标记判断是否需要审阅，如果需要审阅则进行审阅
     * @author 陈垲昕
     * @return 返回audit操作是否被进行，如果无需重复审阅，返回假，反之返回真
     * @since 2021-10-21 10:14 下午
     */
    public boolean auditSalaryReport(){



        //report的脏标记已访问过的话，则无需继续
        if(salaryTable.getVisited()){
            OutputManager.getInstance().print(
                    "【命令模式】审计员"+this.getName()+"收到命令\n"+
                            "【脏标记模式】但员工薪水表已经被审阅过，无需重复审阅",
                    "【命令模式】審計員"+this.getName()+"收到命令\n"+
                            "【臟標記模式】但員工薪水表已經被審閱過，無需重復審閱",
                    "[Command Pattern] The Auditor"+this.getName()+" has received the command. \n"+
                            "[Dirty Flag Pattern] But the employee salary report has been reviewed, an extra audition is redundant."
            );
            return false;
        }

        OutputManager.getInstance().print(
                "【命令模式】审计员"+this.getName()+"收到命令，并对报告进行审阅",
                "【命令模式】審計員"+this.getName()+"收到命令，並對報告進行審閱",
                "[Command Pattern] The Auditor"+this.getName()+" has received the command and reviewed the finance report. "
        );


        // 重设脏标记
        salaryTable.setVisited();

        return true;

    }
}