package Manufacturing.ProductLine.AbstractCanFactory;

import Manufacturing.CanEntity.*;
import Manufacturing.CanEntity.Material.IronMaterial;
import Manufacturing.CanEntity.Size.BigSize;
import Manufacturing.CanEntity.Size.SmallSize;
import Presentation.Protocol.OutputManager;

/**
 * 铁制罐头工厂
 * 享元模式、抽象工厂模式、单例模式
 * @author 汪明杰
 */
public class IronCanFactory extends AbstractCanFactory {

    private static VegetableCan smallVegetableCan;
    private static VegetableCan bigVegetableCan;
    private static FruitCan smallFruitCan;
    private static FruitCan bigFruitCan;

    // 单例模式
    private static IronCanFactory ironCanFactory;

    private IronCanFactory(){
        OutputManager.getInstance().print(
                "# 使用抽象工厂模式",
                "# 使用抽象工廠模式",
                "# Using Abstract Factory mode"
        );
        IronCanFactory.smallVegetableCan = null;
        IronCanFactory.bigVegetableCan = null;
        IronCanFactory.smallFruitCan = null;
        IronCanFactory.bigFruitCan = null;
        System.out.println("成功创建铁制罐头工厂");
        OutputManager.getInstance().print(
                "成功创建铁制罐头工厂",
                "成功創建鐵制罐頭工廠",
                "Successfully created iron cannery"
        );
    }

    public static IronCanFactory getInstance(){
        if (IronCanFactory.ironCanFactory == null){
            IronCanFactory.ironCanFactory = new IronCanFactory();
        }
        return IronCanFactory.ironCanFactory;
    }

    @Override
    public Can createBigFruitCan() {
        OutputManager.getInstance().print(
                "# 使用享元模式",
                "# 使用享元模式",
                "# Using Fly weight Mode"
        );
        if (IronCanFactory.bigFruitCan == null){
            IronCanFactory.bigFruitCan = new FruitCan(BigSize.getInstance(), IronMaterial.getInstance());
        }
        return IronCanFactory.bigFruitCan.Clone();
    }

    @Override
    public Can createSmallFruitCan() {
        OutputManager.getInstance().print(
                "# 使用享元模式",
                "# 使用享元模式",
                "# Using Fly weight Mode"
        );
        if (IronCanFactory.smallFruitCan == null){
            IronCanFactory.smallFruitCan = new FruitCan(SmallSize.getInstance(), IronMaterial.getInstance());
        }
        return IronCanFactory.smallFruitCan.Clone();
    }

    @Override
    public Can createBigVegetableCan() {
        OutputManager.getInstance().print(
                "# 使用享元模式",
                "# 使用享元模式",
                "# Using Fly weight Mode"
        );
        if(IronCanFactory.bigVegetableCan == null){
            IronCanFactory.bigVegetableCan = new VegetableCan(BigSize.getInstance(),IronMaterial.getInstance());
        }
        return IronCanFactory.bigVegetableCan.Clone();
    }

    @Override
    public Can createSmallVegetableCan() {
        OutputManager.getInstance().print(
                "# 使用享元模式",
                "# 使用享元模式",
                "# Using Fly weight Mode"
        );
        if (IronCanFactory.smallVegetableCan == null){
            IronCanFactory.smallVegetableCan = new VegetableCan(SmallSize.getInstance(), IronMaterial.getInstance());
        }
        return IronCanFactory.smallVegetableCan.Clone();
    }
}
