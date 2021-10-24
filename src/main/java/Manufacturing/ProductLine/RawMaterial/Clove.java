package Manufacturing.ProductLine.RawMaterial;

/**
 * TODO:丁香鱼类
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:40
 */
public class Clove extends RawMaterial {

    public Clove(Double weight) {
        super.setWeight(weight);
        super.setKind("clove");
    }

    @Override
    public String toString() {
        return "Clove{" +
                "weight=" + super.getWeight() +
                '}';
    }
}
