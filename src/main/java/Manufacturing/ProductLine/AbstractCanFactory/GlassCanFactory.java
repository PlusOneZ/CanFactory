package Manufacturing.ProductLine.AbstractCanFactory;

import Manufacturing.CanEntity.Can;
import Manufacturing.CanEntity.ConcreteCan.CandiedAppleCan;
import Manufacturing.CanEntity.ConcreteCan.PeachCan;
import Manufacturing.CanEntity.Material.GlassMaterial;
import Manufacturing.CanEntity.Size.BigSize;
import Manufacturing.CanEntity.Size.SmallSize;
import Presentation.Protocol.OutputManager;

/**
 * 玻璃罐头工厂
 * 享元模式、抽象工厂模式、单例模式
 * @author 汪明杰
 */
public class GlassCanFactory extends AbstractCanFactory {

    private static CandiedAppleCan smallCandiedAppleCan;
    private static CandiedAppleCan bigCandiedAppleCan;
    private static PeachCan smallPeachCan;
    private static PeachCan bigPeachCan;

    // 单例模式
    private static GlassCanFactory glassCanFactory;

    private GlassCanFactory(){
        OutputManager.getInstance().print(
                "# 使用抽象工厂模式",
                "# 使用抽象工廠模式",
                "# Using Abstract Factory mode"
        );

        GlassCanFactory.smallCandiedAppleCan = null;
        GlassCanFactory.bigCandiedAppleCan = null;
        GlassCanFactory.smallPeachCan = null;
        GlassCanFactory.bigPeachCan = null;

        OutputManager.getInstance().print(
                "成功创建玻璃罐头工厂",
                "成功創建玻璃罐頭工廠",
                "Successfully created glass can factory"
        );
    }

    public static GlassCanFactory getInstance(){
        if (GlassCanFactory.glassCanFactory == null){
            GlassCanFactory.glassCanFactory = new GlassCanFactory();
        }
        return GlassCanFactory.glassCanFactory;
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

        if(type.equalsIgnoreCase("Peach")){
            if (GlassCanFactory.smallPeachCan == null){
                GlassCanFactory.smallPeachCan = new PeachCan(SmallSize.getInstance(), GlassMaterial.getInstance());
            }
                return GlassCanFactory.smallPeachCan.Clone();
        }
        else if (type.equalsIgnoreCase("CandiedApple")){
            if (GlassCanFactory.smallCandiedAppleCan == null){
                GlassCanFactory.smallCandiedAppleCan = new CandiedAppleCan(SmallSize.getInstance(), GlassMaterial.getInstance());
            }
                return GlassCanFactory.smallCandiedAppleCan.Clone();
        }

        OutputManager.getInstance().errorMassage(
                "玻璃工厂不能生产该种类的罐头！",
                "玻璃工廠不能生產該種類的罐頭！",
                "Glass factory can't produce this kind of cans!"
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

        if(type.equalsIgnoreCase("Peach")){
            if (GlassCanFactory.bigPeachCan == null){
                GlassCanFactory.bigPeachCan = new PeachCan(BigSize.getInstance(), GlassMaterial.getInstance());
            }
                return GlassCanFactory.bigPeachCan.Clone();
        }
        else if (type.equalsIgnoreCase("CandiedApple")){
            if (GlassCanFactory.bigCandiedAppleCan == null){
                GlassCanFactory.bigCandiedAppleCan = new CandiedAppleCan(BigSize.getInstance(), GlassMaterial.getInstance());
            }
                return GlassCanFactory.bigCandiedAppleCan.Clone();
        }

        OutputManager.getInstance().errorMassage(
                "玻璃工厂不能生产该种类的罐头！",
                "玻璃工廠不能生產該種類的罐頭！",
                "Glass factory can't produce this kind of cans!"
        );
        return null;
    }
}
