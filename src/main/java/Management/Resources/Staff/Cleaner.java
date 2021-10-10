package Management.Resources.Staff;

import Management.QuantityTesting.FactoryVisitor;

import java.util.Random;

/**
 * 保洁员
 * @author 汪明杰
 */
public class Cleaner extends Staff{
    public Cleaner(String name) {
        super(name);
    }


    public void accept(FactoryVisitor visitor) {
        visitor.visit(this);
    }

    // 获取清扫区域面积
    public int getCleanArea(){
        return new Random().nextInt(100);
    }

    // 获取工资
    public int getPayment(){
        return 3000;
    }
}
