package
        Marketing.Wrapping.Builder;

import Marketing.Wrapping.Cover.HerringCanWrappingCover;
import Marketing.Wrapping.Cover.PeachCanWrappingCover;
import Marketing.Wrapping.Cover.WrappingCover;
import Marketing.Wrapping.WrappingCanInfo;
import Marketing.Wrapping.WrappingFactoryInfo;

/**
 * 黄桃罐头建造类
 *
 * @author 王立友
 * @date 2021/10/30 20:36
 */
public class PeachCanWrappingBuilder extends WrappingBuilder {
    private final PeachCanWrappingCover wrappingCover = new PeachCanWrappingCover();

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