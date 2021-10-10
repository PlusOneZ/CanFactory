package Management.QuantityTesting;

import Management.Resources.Staff.Cleaner;
import Management.Resources.Staff.SecurityStaff;

public class VisitorTest {
    public static void main(String[] args) {
        Cleaner cleaner = new Cleaner("张三");
        SecurityStaff securityStaff = new SecurityStaff("李四");
        
        System.out.println("CEO开始观察");
        CEOVisitor visitor1 = new CEOVisitor();
        cleaner.accept(visitor1);
        securityStaff.accept(visitor1);

        System.out.println("业务经理开始观察");
        ManagerVisitor visitor2 = new ManagerVisitor();
        cleaner.accept(visitor2);
        securityStaff.accept(visitor2);
    }
}
