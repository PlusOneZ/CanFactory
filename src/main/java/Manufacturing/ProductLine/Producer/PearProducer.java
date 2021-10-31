package Manufacturing.ProductLine.Producer;

/**
 * 梨罐头生产类
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:50
 */
public class PearProducer implements FruitProducer {
    private final FruitAdapter fruitAdapter;

    public PearProducer(String manner) {
        this.fruitAdapter = new FruitAdapter(manner);
    }

    @Override
    public void produce() {
        fruitAdapter.produce();
    }
}
