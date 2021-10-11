package Management.QuantityTesting;

import Management.Resources.Staff.Cleaner;
import Management.Resources.Staff.SecurityStaff;

/**
 * 观察者模式
 * 用于观察工厂中的生产质量
 * @author 汪明杰
 */
public interface FactoryVisitor {

    // 观察保安工作质量
    public void visit(SecurityStaff staff);

    // 观察保洁员工作质量
    public void visit(Cleaner staff);
}
