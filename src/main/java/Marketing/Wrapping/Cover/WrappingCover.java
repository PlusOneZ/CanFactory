package Marketing.Wrapping.Cover;


import Marketing.Wrapping.WrappingCanInfo;
import Marketing.Wrapping.WrappingFactoryInfo;

/**
 * @Author 王立友
 * 该类为真正的包装封面类，内部组合了包装的罐头的固有属性，厂家属性，广告等信息.
 * 通过继承该类实现具体罐头封面的制作与实现.
 */
public abstract class WrappingCover {

    /**
     * 罐头包装实体信息;
     */
    protected WrappingCanInfo wrappingCanInfo;

    /**
     * 罐头工厂打印信息;
     */
    protected WrappingFactoryInfo wrappingFactoryInfo;

    /**
     * 罐头背景图片信息;
     */
    protected String wrappingBackground;

    /**
     * 罐头价格信息;
     */
    protected double canPrice;


    protected WrappingCover(){}

    public void setWrappingCanInfo(WrappingCanInfo wrappingCanInfo){
        this.wrappingCanInfo = wrappingCanInfo;
    }

    public void setWrappingFactoryInfo(WrappingFactoryInfo wrappingFactoryInfo){
        this.wrappingFactoryInfo = wrappingFactoryInfo;
    }

    public void setWrappingBackground(String wrappingBackground){
        this.wrappingBackground = wrappingBackground;
    }

    public WrappingCanInfo getWrappingCanInfo(){
        return wrappingCanInfo;
    }
    public WrappingFactoryInfo getWrappingFactoryInfo(){
        return wrappingFactoryInfo;
    }
    public String getWrappingBackground(){
        return wrappingBackground;
    }
    public double getCanPrice(){
        return canPrice;
    }
    public void setCanPrice(double canPrice){
        this.canPrice = canPrice;
    }
}
