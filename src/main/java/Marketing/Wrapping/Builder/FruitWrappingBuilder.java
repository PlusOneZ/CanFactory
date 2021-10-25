package Marketing.Wrapping.Builder;

import Marketing.Wrapping.Cover.FruitWrappingCover;
import Marketing.Wrapping.WrappingCanInfo;
import Marketing.Wrapping.Cover.WrappingCover;
import Marketing.Wrapping.WrappingFactoryInfo;

/**
 * @Author 王立友
 * Builder模式的具体实现，可以通过组装方式
 */
public class FruitWrappingBuilder extends WrappingBuilder {

    private final WrappingCover wrappingCover = new FruitWrappingCover();

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
