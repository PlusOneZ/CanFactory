package Marketing.Wrapping.Converter;


import Manufacturing.CanEntity.Can;
import Marketing.Wrapping.WrappingCanInfo;

import java.util.function.Function;

/**
 * 转换器模式
 * @Author 王立友
 * 读取Can内容转换到WrappingCanInfo.
 */

public class WrappingConverter {

    private Function<Can, WrappingCanInfo> fromCanEntityFunction;

    public WrappingConverter(){
        new FromCanEntityFunction();
    }

    static class FromCanEntityFunction implements Function<Can, WrappingCanInfo>{
        @Override
        public WrappingCanInfo apply(Can can){
            WrappingCanInfo wrappingCanInfo = new WrappingCanInfo();
            wrappingCanInfo.setCanName(can.getCanName());
            wrappingCanInfo.setIngredients(can.getIngredients());
//            wrappingCanInfo.setWeight(can.getWeight());
            return wrappingCanInfo;
        }
    }
}
