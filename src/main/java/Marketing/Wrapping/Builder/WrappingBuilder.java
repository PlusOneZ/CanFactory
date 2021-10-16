package Marketing.Wrapping.Builder;


import Marketing.Wrapping.WrappingCanInfo;
import Marketing.Wrapping.Cover.WrappingCover;
import Marketing.Wrapping.WrappingFactoryInfo;

/**
 * Builder模式
 * @Author 王立友
 * 通过将包装中的CanInfo,FactoryInfo组合成不同的包装封面
 * TODO: 将广告板块集成到Builder模式中
 */
public abstract class WrappingBuilder {

    abstract void buildWrappingCanInfo(WrappingCanInfo wrappingCanInfo);
    abstract void buildWrappingFactoryInfo(WrappingFactoryInfo wrappingFactoryInfo);
    // add the ad.
    abstract WrappingCover build();

}
