package Management.HumanResources.Staff;

import Management.HumanResources.DepartmentType;
import Management.HumanResources.Staff.Staff;
import Management.QuantityTesting.FactoryVisitor;

import java.util.Random;

/**
 * 保安
 * @author 汪明杰
 */
public class SecurityStaff extends Staff {
    /**
     * 含名字的构造函数
     * @param name :  保安名字
     * @author 汪明杰
     * @since 2021-10-21 9:03 上午
     */
    public SecurityStaff(String name){
        super.department= DepartmentType.Security;
        this.name=name;
    }

    /**
     * 含名字和薪水的构造函数
     * @param name :  保安名字
     * @author 汪明杰
     * @since 2021-10-21 9:03 上午
     */
    public SecurityStaff(String name, Double salary){
        super.department= DepartmentType.Security;
        this.name=name;
        this.salary=salary;
    }


    public void accept(FactoryVisitor visitor) {
        visitor.visit(this);
    }

    // 检查的人的数量
    public int getVerify(){
        return new Random().nextInt(100);
    }

}
