package Management.QuantityTesting;

import Management.HumanResources.Staff.Cleaner;
import Management.HumanResources.Staff.SecurityStaff;

/**
 * 观察者模式
 * 用于观察工厂中的生产质量
 * @author 汪明杰
 * @date 2021/10/12
 */
public interface FactoryVisitor {

    // 观察保安工作质量
    public void visit(SecurityStaff staff);

    // 观察保洁员工作质量
    public void visit(Cleaner staff);
}
