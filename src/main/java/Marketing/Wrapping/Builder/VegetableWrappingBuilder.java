package
        Marketing.Wrapping.Builder;

import Marketing.Wrapping.Cover.VegetableWrappingCover;
import Marketing.Wrapping.Cover.WrappingCover;
import Marketing.Wrapping.WrappingCanInfo;
import Marketing.Wrapping.WrappingFactoryInfo;

/**
 * 蔬菜类的建造者;
 *
 * @author 王立友
 * @date 2021/10/25 0:59
 */
public class VegetableWrappingBuilder extends WrappingBuilder{

    private final WrappingCover wrappingCover = new VegetableWrappingCover();

    @Override
    void buildWrappingCanInfo(WrappingCanInfo wrappingCanInfo){
        wrappingCover.setWrappingCanInfo(wrappingCanInfo);
    }

    @Override
    void buildWrappingFactoryInfo(WrappingFactoryInfo wrappingFactoryInfo){
        wrappingCover.setWrappingFactoryInfo(wrappingFactoryInfo);
    }

    @Override
    void buildWrappingBackground(String wrappingBackground){
        wrappingCover.setWrappingBackground(wrappingBackground);
    }

    @Override
    public WrappingCover build(){
        return wrappingCover;
    }
}