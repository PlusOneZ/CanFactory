package Management.QuantityTesting;

import Management.Resources.Staff.Cleaner;
import Management.Resources.Staff.SecurityStaff;
import Presentation.Protocol.OutputManager;

public class CEOVisitor implements FactoryVisitor{

    public CEOVisitor(){
        OutputManager.getInstance().print(
                "# 使用访问者模式",
                "# 使用訪問者模式",
                "# Using Visitor Mode"
        );
    }

    @Override
    public void visit(SecurityStaff staff) {

        System.out.println("保安["+staff.getName()+"]"+"：工资为"+staff.getPayment());
    }

    @Override
    public void visit(Cleaner staff) {
        System.out.println("保洁员["+staff.getName()+"]"+"：工资为"+staff.getPayment());
    }
}
