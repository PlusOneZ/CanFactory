package Manufacturing.ProductLine.Producer;


/**
 * 苹果罐头生产类.
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:55
 */
public class  AppleProducer implements FruitProducer {
    /**
     * 水果罐头生产适配器
     */
    private final FruitAdapter fruitAdapter;

    public AppleProducer(String manner) {
        this.fruitAdapter = new FruitAdapter(manner);
    }

    @Override
    public void produce() {
        fruitAdapter.produce();
    }
}
