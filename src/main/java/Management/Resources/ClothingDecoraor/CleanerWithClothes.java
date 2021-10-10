package Management.Resources.ClothingDecoraor;

import Management.Resources.Staff.Staff;

public class CleanerWithClothes extends StaffWithClothes{
    public CleanerWithClothes(Staff staff) {
        super(staff);
    }

    @Override
    public void putOnClothes() {
        System.out.println(this.obj.getName()+"穿上了保洁服，开始工作");
    }

    @Override
    public void takeOffClothes() {
        System.out.println(this.obj.getName()+"脱下了保洁服，结束工作");
    }
}
