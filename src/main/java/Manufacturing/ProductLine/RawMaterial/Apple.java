package Manufacturing.ProductLine.RawMaterial;

/**
 * TODO:苹果类
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:40
 */
public class Apple extends RawMaterial {

    public Apple(Double weight) {
        super.setWeight(weight);
        super.setKind("apple");
    }


    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + super.getWeight() +
                '}';
    }
}
