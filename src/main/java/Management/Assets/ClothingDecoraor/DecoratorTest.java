package Management.Assets.ClothingDecoraor;

import Management.HumanResources.Staff.Cleaner;
import Management.HumanResources.Staff.SecurityStaff;
import Management.HumanResources.Staff.Staff;
import Presentation.Protocol.OutputManager;

public class DecoratorTest {
    public static void main(String[] args) {
        OutputManager.getInstance().setLanguage(OutputManager.Lang.zh_CN);

        Staff staff1 = new Cleaner("李华");
        CleanerWithClothes cleaner = new CleanerWithClothes(staff1);
        cleaner.putOnClothes();

        Staff staff2 = new SecurityStaff("王三");
        SecurityClothes securityStaff = new SecurityClothes(staff2);
        securityStaff.putOnClothes();

        cleaner.takeOffClothes();
        securityStaff.takeOffClothes();
    }
}
