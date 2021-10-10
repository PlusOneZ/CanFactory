package Manufacturing.ProductLine.AbstractFactory;

import Manufacturing.CanEntity.*;
import Manufacturing.CanEntity.Material.IronMaterial;
import Manufacturing.CanEntity.Size.BigSize;
import Manufacturing.CanEntity.Size.SmallSize;

/**
 * 铁制罐头工厂
 * @author 汪明杰
 */
public class IronCanFactory extends AbstractCanFactory{

    private VegetableCan smallVegetableCan;
    private VegetableCan bigVegetableCan;
    private FruitCan smallFruitCan;
    private FruitCan bigFruitCan;

    public IronCanFactory(){
        System.out.println("# 使用抽象工厂模式(Abstract Factory)");
        this.smallVegetableCan = null;
        this.bigVegetableCan = null;
        this.smallFruitCan = null;
        this.bigFruitCan = null;
        System.out.println("# 成功创建铁制罐头工厂");
    }

    @Override
    public FactoryCan createBigFruitCan() {
        System.out.println("# 使用享元模式(Fly weight)");
        if (this.bigFruitCan == null){
            this.bigFruitCan = new FruitCan(new BigSize(), new IronMaterial());
        }
        return this.bigFruitCan;
    }

    @Override
    public FactoryCan createSmallFruitCan() {
        System.out.println("# 使用享元模式(Fly weight)");
        if (this.smallFruitCan == null){
            this.smallFruitCan = new FruitCan(new SmallSize(), new IronMaterial());
        }
        return this.smallFruitCan;
    }

    @Override
    public FactoryCan createBigVegetableCan() {
        System.out.println("# 使用享元模式(Fly weight)");
        if(this.bigVegetableCan == null){
            this.bigVegetableCan = new VegetableCan(new BigSize(),new IronMaterial());
        }
        return this.bigVegetableCan;
    }

    @Override
    public FactoryCan createSmallVegetableCan() {
        System.out.println("# 使用享元模式(Fly weight)");
        if (this.smallVegetableCan == null){
            this.smallVegetableCan = new VegetableCan(new SmallSize(), new IronMaterial());
        }
        return this.smallVegetableCan;
    }
}
