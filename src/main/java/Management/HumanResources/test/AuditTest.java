package Management.HumanResources.test;

import Management.HumanResources.DepartmentCommand.AuditSalaryTableCommand;
import Management.HumanResources.DepartmentCommand.Command;
import Management.HumanResources.FinancialSystem.DataAccessObject.SalaryDaoImpl;
import Management.HumanResources.FinancialSystem.FinancialDepartment;
import Management.HumanResources.Staff.Auditor;

/**
 * 测试Audit模块包括命令模式，备忘录模式，脏标记模式
 *
 * @author mount_potato
 * @since 2021/11/2 7:06 下午
 */

public class AuditTest {

    public static void main(String[] args) {


        SalaryDaoImpl.getInstance().setUnvisited();
        Auditor auditor1=new Auditor("审计员1",209.0);
        Auditor auditor2=new Auditor("审计员2",209.0);

        AuditSalaryTableCommand command1 = new AuditSalaryTableCommand(auditor1);
        AuditSalaryTableCommand command2 = new AuditSalaryTableCommand(auditor2);

        FinancialDepartment.getInstance().setCurrentCommand(command1);
        FinancialDepartment.getInstance().giveCommand();
        FinancialDepartment.getInstance().setCurrentCommand(command2);
        FinancialDepartment.getInstance().giveCommand();

        FinancialDepartment.getInstance().viewAuditHistoryList();

    }
}
