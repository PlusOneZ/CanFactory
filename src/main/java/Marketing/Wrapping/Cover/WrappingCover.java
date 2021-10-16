package Marketing.Wrapping.Cover;


import Marketing.Wrapping.WrappingCanInfo;
import Marketing.Wrapping.WrappingFactoryInfo;

/**
 * @Author 王立友
 * 该类为真正的包装封面类，内部组合了包装的罐头的固有属性，厂家属性，广告等信息.
 * 通过继承该类实现具体罐头封面的制作与实现.
 */

public abstract class WrappingCover {

    WrappingCanInfo wrappingCanInfo;
    WrappingFactoryInfo wrappingFactoryInfo;

    protected WrappingCover(){}

    public void setWrappingCanInfo(WrappingCanInfo wrappingCanInfo){
        this.wrappingCanInfo = wrappingCanInfo;
    }

    public void setWrappingFactoryInfo(WrappingFactoryInfo wrappingFactoryInfo){
        this.wrappingFactoryInfo = wrappingFactoryInfo;
    }

}
