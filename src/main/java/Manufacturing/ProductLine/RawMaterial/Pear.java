package Manufacturing.ProductLine.RawMaterial;

/**
 * TODO:梨类
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:39
 */
public class Pear extends RawMaterial {

    public Pear(Double weight) {
        super.setWeight(weight);
        super.setKind("pear");
    }


    @Override
    public String toString() {
        return "Pear{" +
                "weight=" + super.getWeight() +
                '}';
    }
}
