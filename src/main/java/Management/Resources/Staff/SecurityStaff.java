package Management.Resources.Staff;

import Management.QuantityTesting.FactoryVisitor;

import java.util.Random;

/**
 * 保安
 * @author 汪明杰
 */
public class SecurityStaff extends Staff{
    public SecurityStaff(String name){
        super(name);
    }


    public void accept(FactoryVisitor visitor) {
        visitor.visit(this);
    }

    // 检查的人的数量
    public int getVerify(){
        return new Random().nextInt(100);
    }

    public int getPayment(){
        return 4000;
    }
}
