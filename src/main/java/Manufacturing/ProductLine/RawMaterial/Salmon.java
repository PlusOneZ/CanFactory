package Manufacturing.ProductLine.RawMaterial;

/**
 * TODO:三文鱼类
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:34
 */
public class Salmon extends RawMaterial {

    public Salmon(Double weight) {
       super.setWeight(weight);
        super.setKind("salmon");
    }



    @Override
    public String toString() {
        return "Salmon{" +
                "quality=" + super.getWeight() +
                '}';
    }
}
