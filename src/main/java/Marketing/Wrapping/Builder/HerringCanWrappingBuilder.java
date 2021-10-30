package
        Marketing.Wrapping.Builder;

import Marketing.Wrapping.Cover.HerringCanWrappingCover;
import Marketing.Wrapping.Cover.WrappingCover;
import Marketing.Wrapping.WrappingCanInfo;
import Marketing.Wrapping.WrappingFactoryInfo;

/**
 * 鲱鱼罐头建造者类
 *
 * @author 王立友
 * @date 2021/10/30 20:34
 */
public class HerringCanWrappingBuilder extends WrappingBuilder {
    private final HerringCanWrappingCover wrappingCover = new HerringCanWrappingCover();

    @Override
    void buildWrappingCanInfo(WrappingCanInfo wrappingCanInfo) {
        wrappingCover.setWrappingCanInfo(wrappingCanInfo);
    }

    @Override
    void buildWrappingFactoryInfo(WrappingFactoryInfo wrappingFactoryInfo) {
        wrappingCover.setWrappingFactoryInfo(wrappingFactoryInfo);
    }

    @Override
    void buildWrappingBackground(String wrappingBackground) {
        wrappingCover.setWrappingBackground(wrappingBackground);
    }

    @Override
    void buildCanPrice(double canPrice) {
        wrappingCover.setCanPrice(canPrice);
    }

    @Override
    public WrappingCover build() {
        return wrappingCover;
    }
}