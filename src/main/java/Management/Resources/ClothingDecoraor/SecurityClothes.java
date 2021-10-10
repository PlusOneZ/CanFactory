package Management.Resources.ClothingDecoraor;

import Management.Resources.Staff.Staff;

public class SecurityClothes extends StaffWithClothes{

    public SecurityClothes(Staff staff) {
        super(staff);
    }

    @Override
    public void putOnClothes() {
        System.out.println(this.obj.getName()+"穿上了保安服，开始工作");
    }

    @Override
    public void takeOffClothes() {
        System.out.println(this.obj.getName()+"脱下了保安服，结束工作");
    }
}
