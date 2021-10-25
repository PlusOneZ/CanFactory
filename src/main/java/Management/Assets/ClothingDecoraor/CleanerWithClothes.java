package Management.Assets.ClothingDecoraor;

import Management.HumanResources.Staff.Staff;
import Presentation.Protocol.OutputManager;

public class CleanerWithClothes extends StaffWithClothes{
    public CleanerWithClothes(Staff staff) {
        super(staff);
    }

    @Override
    public void putOnClothes() {
        OutputManager.getInstance().print(
                this.obj.getName()+"穿上了保洁服，开始工作",
                this.obj.getName()+"穿上了保潔服，開始工作",
                this.obj.getName()+" put on the cleaning clothes and starts working"
        );
    }

    @Override
    public void takeOffClothes() {
        OutputManager.getInstance().print(
                this.obj.getName()+"脱下了保洁服，开始工作",
                this.obj.getName()+"脫下了保潔服，開始工作",
                this.obj.getName()+" take off the cleaning clothes and starts working"
        );
    }
}
