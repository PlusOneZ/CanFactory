package Manufacturing.ProductLine.AbstractCanFactory;

import Manufacturing.CanEntity.*;
import Manufacturing.CanEntity.ConcreteCan.CandiedAppleCan;
import Manufacturing.CanEntity.ConcreteCan.HerringCan;
import Manufacturing.CanEntity.ConcreteCan.PeachCan;
import Manufacturing.CanEntity.ConcreteCan.SalmonCan;
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

    private static HerringCan smallHerringCan;
    private static HerringCan bigHerringCan;
    private static SalmonCan smallSalmonCan;
    private static SalmonCan bigSalmonCan;

    // 单例模式
    private static IronCanFactory ironCanFactory;

    private IronCanFactory(){
        OutputManager.getInstance().print(
                "# 使用抽象工厂模式",
                "# 使用抽象工廠模式",
                "# Using Abstract Factory mode"
        );

        IronCanFactory.smallHerringCan = null;
        IronCanFactory.bigHerringCan = null;
        IronCanFactory.smallSalmonCan = null;
        IronCanFactory.bigSalmonCan = null;

        OutputManager.getInstance().print(
                "成功创建铁制罐头工厂",
                "成功創建鐵制罐頭工廠",
                "Successfully created iron can factory"
        );
    }

    public static IronCanFactory getInstance(){
        if (IronCanFactory.ironCanFactory == null){
            IronCanFactory.ironCanFactory = new IronCanFactory();
        }
        return IronCanFactory.ironCanFactory;
    }

    /**
     * 生产小罐头，不存在则返回null
     * @param type
     * @return Can
     */
    @Override
    public Can createSmallCan(String type){
        OutputManager.getInstance().print(
                "# 使用享元模式",
                "# 使用享元模式",
                "# Using Fly weight Mode"
        );

        if(type.equalsIgnoreCase("Salmon")){
            if (IronCanFactory.smallSalmonCan == null){
                IronCanFactory.smallSalmonCan= new SalmonCan(SmallSize.getInstance(), IronMaterial.getInstance());
            }
            else{
                return IronCanFactory.smallSalmonCan.Clone();
            }
        }
        else if (type.equalsIgnoreCase("Herring")){
            if (IronCanFactory.smallHerringCan == null){
                IronCanFactory.smallHerringCan= new HerringCan(SmallSize.getInstance(), IronMaterial.getInstance());
            }
            else{
                return IronCanFactory.smallHerringCan.Clone();
            }
        }

        OutputManager.getInstance().errorMassage(
                "铁制工厂不能生产该种类的罐头！",
                "鐵制工廠不能生產該種類的罐頭！",
                "Iron factory can't produce this kind of cans!"
        );
        return null;
    }

    /**
     * 生产大罐头，不存在则返回null
     * @param type
     * @return Can
     */
    @Override
    public Can createBigCan(String type){
        OutputManager.getInstance().print(
                "# 使用享元模式",
                "# 使用享元模式",
                "# Using Fly weight Mode"
        );

        if(type.equalsIgnoreCase("Salmon")){
            if (IronCanFactory.bigSalmonCan == null){
                IronCanFactory.bigSalmonCan= new SalmonCan(BigSize.getInstance(), IronMaterial.getInstance());
            }
            else{
                return IronCanFactory.bigSalmonCan.Clone();
            }
        }
        else if (type.equalsIgnoreCase("Herring")){
            if (IronCanFactory.bigHerringCan == null){
                IronCanFactory.bigHerringCan= new HerringCan(BigSize.getInstance(), IronMaterial.getInstance());
            }
            else{
                return IronCanFactory.bigHerringCan.Clone();
            }
        }

        OutputManager.getInstance().errorMassage(
                "铁制工厂不能生产该种类的罐头！",
                "鐵制工廠不能生產該種類的罐頭！",
                "Iron factory can't produce this kind of cans!"
        );
        return null;
    }
}
