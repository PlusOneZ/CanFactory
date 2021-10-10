package Management.QuantityTesting;

import Management.Resources.Staff.Cleaner;
import Management.Resources.Staff.SecurityStaff;
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
        System.out.println("保安["+staff.getName()+"]"+"：工作量为"+staff.getVerify());
    }

    @Override
    public void visit(Cleaner staff) {
        System.out.println("保洁员["+staff.getName()+"]"+"：工作量为"+staff.getCleanArea());
    }
}
