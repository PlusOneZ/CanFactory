package Manufacturing.ProductLine.RawMaterial;

/**
 * TODO:黄桃类
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:39
 */
public class Peach extends RawMaterial {

    public Peach(Double weight) {
        super.setWeight(weight);
        super.setKind("peach");
    }

    @Override
    public String toString() {
        return "Peach{" +
                "weight=" + super.getWeight() +
                '}';
    }
}
