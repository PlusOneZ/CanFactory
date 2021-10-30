
package Manufacturing.ProductLine.AbstractCanFactory;


import Manufacturing.CanEntity.Can;

/**
 * 罐头抽象工厂
 * 抽象工厂模式、单例模式
 * @author 汪明杰
 */
public abstract class AbstractCanFactory {

    /**
     * 创建大罐头
     * @return Can 罐头
     */
    public abstract Can createBigCan(String type);

    /**
     * 创建小罐头
     * @return Can 罐头
     */
    public abstract Can createSmallCan(String type);


}
