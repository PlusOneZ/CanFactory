package Management.Resources.ClothingDecoraor;

import Management.Resources.Staff.Cleaner;
import Management.Resources.Staff.SecurityStaff;
import Management.Resources.Staff.Staff;

public class DecoratorTest {
    public static void main(String[] args) {
        Staff staff1 = new Cleaner("李华");
        CleanerClothes cleaner = new CleanerClothes(staff1);
        cleaner.putOnClothes();

        Staff staff2 = new SecurityStaff("王三");
        SecurityClothes securityStaff = new SecurityClothes(staff2);
        securityStaff.putOnClothes();

        cleaner.takeOffClothes();
        securityStaff.takeOffClothes();
    }
}
