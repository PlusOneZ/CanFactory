package Marketing.Wrapping.Builder;


import Marketing.Wrapping.WrappingCanInfo;
import Marketing.Wrapping.WrappingFactoryInfo;

/**
 * @Author 王立友
 * Builder模式的Director,用于指导生成对应的封面.
 * TODO: 将Director制作成打印封面的生产线
 */
public class Director {
    WrappingBuilder wrappingBuilder = null;

    public Director(WrappingBuilder wrappingBuilder){
        this.wrappingBuilder = wrappingBuilder;
    }

    public void construct(WrappingCanInfo wrappingCanInfo, WrappingFactoryInfo wrappingFactoryInfo){

        wrappingBuilder.buildWrappingCanInfo(wrappingCanInfo);
        wrappingBuilder.buildWrappingFactoryInfo(wrappingFactoryInfo);
    }
}
