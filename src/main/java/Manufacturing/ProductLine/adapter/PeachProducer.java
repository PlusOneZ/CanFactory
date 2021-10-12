package Manufacturing.ProductLine.adapter;

/**
 * TODO:黄桃罐头生产类.
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:51
 */
public class PeachProducer implements FruitProducer {

    private final FruitAdapter fruitAdapter;

    public PeachProducer(String manner) {
        this.fruitAdapter = new FruitAdapter(manner);
    }

    @Override
    public void produce() {
        fruitAdapter.produce();
    }
}
