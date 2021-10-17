
package Manufacturing.ProductLine.AbstractCanFactory;


import Manufacturing.CanEntity.Can;

/**
 * 罐头抽象工厂
 * 抽象工厂模式、单例模式
 * @author 汪明杰
 */
public abstract class AbstractCanFactory {

    /**
     * 创建大水果罐头
     * @return
     */
    public abstract Can createBigFruitCan();

    /**
     * 创建小水果罐头
     * @return
     */
    public abstract Can createSmallFruitCan();

    /**
     * 创建大蔬菜罐头
     * @return
     */
    public abstract Can createBigVegetableCan();

    /**
     * 创建小蔬菜罐头
     * @return
     */
    public abstract Can createSmallVegetableCan();


}
