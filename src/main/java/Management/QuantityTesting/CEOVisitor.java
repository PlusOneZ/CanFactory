package Management.QuantityTesting;

import Management.Resources.Staff.Cleaner;
import Management.Resources.Staff.SecurityStaff;

public class CEOVisitor implements FactoryVisitor{

    public CEOVisitor(){
        System.out.println("# 使用访问者模式(Visitor)");
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
