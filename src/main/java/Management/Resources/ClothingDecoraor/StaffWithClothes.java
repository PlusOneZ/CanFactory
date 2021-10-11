package Management.Resources.ClothingDecoraor;

import Management.Resources.Staff.Staff;

/**
 * 员工工作服
 * @author 汪明杰
 */
public abstract class StaffWithClothes extends Staff {

    protected Staff obj = null;

    public StaffWithClothes(Staff staff) {
        this.obj = staff;
        System.out.println("# 使用装饰器模式(Decorator)");
    }

    public abstract void putOnClothes();

    public abstract void takeOffClothes();


}
