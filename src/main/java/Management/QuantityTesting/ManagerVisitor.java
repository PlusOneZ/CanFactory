package Management.QuantityTesting;

import Management.HumanResources.Staff.Cleaner;
import Management.HumanResources.Staff.SecurityStaff;
import Presentation.Protocol.OutputManager;

public class ManagerVisitor implements FactoryVisitor{

    public ManagerVisitor(){
        OutputManager.getInstance().print(
                "# 使用访问者模式",
                "# 使用訪問者模式",
                "# Using Visitor Mode"
        );
    }

    @Override
    public void visit(SecurityStaff staff) {
        OutputManager.getInstance().print(
                "保安["+staff.getName()+"]"+"：工作量为"+staff.getVerify(),
                "警衛["+staff.getName()+"]"+"：工作量為"+staff.getVerify(),
                "The security staff ["+staff.getName()+"]"+"：The workload is"+staff.getVerify()
        );
    }

    @Override
    public void visit(Cleaner staff) {
        OutputManager.getInstance().print(
                "保洁员["+staff.getName()+"]"+"：工作量为"+staff.getCleanArea(),
                "保潔員["+staff.getName()+"]"+"：工作量為"+staff.getCleanArea(),
                "The cleaner ["+staff.getName()+"]"+"：The workload is"+staff.getCleanArea()
        );
    }
}
