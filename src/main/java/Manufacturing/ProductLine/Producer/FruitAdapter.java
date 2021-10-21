package Manufacturing.ProductLine.Producer;

/**
 * TODO:水果适配器类.<br>
 * <b>实现适配器模式</b>
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:53
 */
public class FruitAdapter implements FruitProducer {


    /**
     * TODO:生产方式，被适配对象，水果生产可以通过适配器适配提供的生产方式
     */
    private final ProduceManner produceManner;


    /**
     * TODO:构造器
     *
     * @param manner :  被适配的生产方式对象
     * @return : null
     * @author 孟繁霖
     * @date 2021-10-12 8:54
     */
    public FruitAdapter(String manner) {
        if ("fine".equals(manner)) {
            this.produceManner = new FineProducer();
        } else {
            this.produceManner = new RoughProducer();
        }
    }

    @Override
    public void produce() {
        produceManner.produce();
    }
}
