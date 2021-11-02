package Management.QuantityTesting;

import Management.HumanResources.Staff.Cleaner;
import Management.HumanResources.Staff.SecurityStaff;
import Presentation.Protocol.OutputManager;


/**
 * 观察者模式Visitor的测试类
 *
 * @author 汪明杰
 * @since 2021-10-24 11:03
 */
public class VisitorTest {
    public static void main(String[] args) {
        Cleaner cleaner = new Cleaner("张三", 4000.0);
        SecurityStaff securityStaff = new SecurityStaff("李四", 4500.0);

        OutputManager.getInstance().print(
                "CEO开始观察",
                "CEO開始觀察",
                "CEO starts to visit"
        );
        CEOVisitor visitor1 = new CEOVisitor();
        cleaner.accept(visitor1);
        securityStaff.accept(visitor1);

        OutputManager.getInstance().print(
                "业务经理开始观察",
                "業務經理開始觀察",
                "Service manager starts to visit"
        );
        ManagerVisitor visitor2 = new ManagerVisitor();
        cleaner.accept(visitor2);
        securityStaff.accept(visitor2);
    }
}
