package Management.Assets.ClothingDecoraor;

import Management.HumanResources.Staff.Cleaner;
import Management.HumanResources.Staff.SecurityStaff;
import Management.HumanResources.Staff.Staff;

public class DecoratorTest {
    public static void main(String[] args) {

        Staff staff1 = new Cleaner("ζε");
        CleanerWithClothes cleaner = new CleanerWithClothes(staff1);
        cleaner.putOnClothes();

        Staff staff2 = new SecurityStaff("ηδΈ");
        SecurityClothes securityStaff = new SecurityClothes(staff2);
        securityStaff.putOnClothes();

        cleaner.takeOffClothes();
        securityStaff.takeOffClothes();
    }
}
