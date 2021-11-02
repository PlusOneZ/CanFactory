package Management.QuantityTesting;
import Management.HumanResources.Staff.Cleaner;
import Management.HumanResources.Staff.SecurityStaff;
import Presentation.Protocol.IOManager;

public class CEOVisitor implements FactoryVisitor{

    public CEOVisitor(){
        IOManager.getInstance().print(
                "# 使用访问者模式",
                "# 使用訪問者模式",
                "# Using Visitor Mode"
        );
    }

    @Override
    public void visit(SecurityStaff staff) {
        IOManager.getInstance().print(
                "保安["+staff.getName()+"]"+"：工资为"+staff.getSalary(),
                "警衛["+staff.getName()+"]"+"：薪水為"+staff.getSalary(),
                "The security staff ["+staff.getName()+"]"+"：The salary is"+staff.getSalary()
        );
    }

    @Override
    public void visit(Cleaner staff) {
        IOManager.getInstance().print(
                "保洁员["+staff.getName()+"]"+"：工资为"+staff.getSalary(),
                "保潔員["+staff.getName()+"]"+"：薪水為"+staff.getSalary(),
                "The cleaner ["+staff.getName()+"]"+"：The salary is"+staff.getSalary()
        );
    }
}
