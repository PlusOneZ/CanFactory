package Management.Resources.ClothingDecoraor;

import Management.Resources.Staff.Staff;
import Presentation.Protocol.OutputManager;

/**
 * 员工工作服
 * @author 汪明杰
 */
public abstract class StaffWithClothes extends Staff {

    protected Staff obj = null;

    public StaffWithClothes(Staff staff) {
        this.obj = staff;
        OutputManager.getInstance().print(
                "# 使用装饰器模式",
                "# 使用裝潢器模式",
                "# Using Decorator mode"
        );
    }

    public abstract void putOnClothes();

    public abstract void takeOffClothes();


}
