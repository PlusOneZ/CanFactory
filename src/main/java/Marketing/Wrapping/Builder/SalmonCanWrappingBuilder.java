package
        Marketing.Wrapping.Builder;

import Marketing.Wrapping.Cover.PeachCanWrappingCover;
import Marketing.Wrapping.Cover.SalmonCanWrappingCover;
import Marketing.Wrapping.Cover.WrappingCover;
import Marketing.Wrapping.WrappingCanInfo;
import Marketing.Wrapping.WrappingFactoryInfo;

/**
 * 三文鱼封面建造者类
 *
 * @author 王立友
 * @date 2021/10/30 20:37
 */
public class SalmonCanWrappingBuilder extends WrappingBuilder {
    private final SalmonCanWrappingCover wrappingCover = new SalmonCanWrappingCover();

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