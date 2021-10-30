package
        Marketing.Wrapping.Builder;

import Marketing.Wrapping.Cover.CandiedAppleCanWrappingCover;
import Marketing.Wrapping.Cover.WrappingCover;
import Marketing.Wrapping.WrappingCanInfo;
import Marketing.Wrapping.WrappingFactoryInfo;

/**
 * 糖渍苹果罐头封面生成类
 *
 * @author 王立友
 * @date 2021/10/30 20:27
 */
public class CandiedAppleCanWrappingBuilder extends WrappingBuilder {
    private final CandiedAppleCanWrappingCover wrappingCover = new CandiedAppleCanWrappingCover();

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