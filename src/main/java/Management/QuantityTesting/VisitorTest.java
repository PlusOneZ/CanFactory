package Management.QuantityTesting;

import Management.Resources.Staff.Cleaner;
import Management.Resources.Staff.SecurityStaff;
import Presentation.Protocol.OutputManager;

public class VisitorTest {
    public static void main(String[] args) {
        Cleaner cleaner = new Cleaner("张三");
        SecurityStaff securityStaff = new SecurityStaff("李四");

        OutputManager.getInstance().setLanguage(OutputManager.Lang.zh_CN);
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
