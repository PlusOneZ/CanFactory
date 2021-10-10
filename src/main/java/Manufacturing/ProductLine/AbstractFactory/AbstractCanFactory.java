package Manufacturing.ProductLine.AbstractFactory;


import Manufacturing.CanEntity.FactoryCan;

/**
 * 罐头抽象工厂
 * @author 汪明杰
 */
public abstract class AbstractCanFactory {

    /**
     * 创建大水果罐头
     * @return
     */
    public abstract FactoryCan createBigFruitCan();

    /**
     * 创建小水果罐头
     * @return
     */
    public abstract FactoryCan createSmallFruitCan();

    /**
     * 创建大蔬菜罐头
     * @return
     */
    public abstract FactoryCan createBigVegetableCan();

    /**
     * 创建小蔬菜罐头
     * @return
     */
    public abstract FactoryCan createSmallVegetableCan();


}
