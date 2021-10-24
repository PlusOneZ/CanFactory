package Management.HumanResources.Staff;

import Management.HumanResources.DepartmentType;
import Management.QuantityTesting.FactoryVisitor;


import java.util.Random;

/**
 * 保洁员
 * @author 汪明杰
 */
public class Cleaner extends Staff {
    /**
     * 含名字的构造函数
     * @param name :  保洁员名字
     * @author 汪明杰
     * @since 2021-10-21 9:03 上午
     */
    public Cleaner(String name){
        super.department= DepartmentType.Backup;
        this.name=name;
    }

    /**
     * 含名字和薪水的构造函数
     * @param name :  保洁员名字
     * @author 汪明杰
     * @since 2021-10-21 9:03 上午
     */
    public Cleaner(String name, Double salary){
        super.department= DepartmentType.Backup;
        this.name=name;
        this.salary=salary;
    }


    public void accept(FactoryVisitor visitor) {
        visitor.visit(this);
    }

    // 获取清扫区域面积
    public int getCleanArea(){
        return new Random().nextInt(100);
    }


}
