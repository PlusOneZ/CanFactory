package Marketing.Wrapping.Builder;


import Marketing.Wrapping.WrappingCanInfo;
import Marketing.Wrapping.WrappingFactoryInfo;

/**
 * @Author 王立友
 * Builder模式的Director,用于指导生成对应的封面.
 * TODO: 将Director制作成打印封面的生产线
 */
public class WrappingDirector {

    WrappingBuilder wrappingBuilder = null;

    public WrappingDirector(WrappingBuilder wrappingBuilder){
        this.wrappingBuilder = wrappingBuilder;
    }

    /**
     * construct命令builder构建相应的wrappingConver;
     * @param wrappingCanInfo : 实体信息;
     * @param wrappingFactoryInfo : 工厂信息;
     * @param wrappingBackground :  背景信息;
     * @author "王立友"
     * @date 2021-10-24 16:02
     */
    public void construct(WrappingCanInfo wrappingCanInfo, WrappingFactoryInfo wrappingFactoryInfo, String wrappingBackground, double canPrice){

        wrappingBuilder.buildWrappingCanInfo(wrappingCanInfo);
        wrappingBuilder.buildWrappingFactoryInfo(wrappingFactoryInfo);
        wrappingBuilder.buildWrappingBackground(wrappingBackground);
        wrappingBuilder.buildCanPrice(canPrice);
    }
}
