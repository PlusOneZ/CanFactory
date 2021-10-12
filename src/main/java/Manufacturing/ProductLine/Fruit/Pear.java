package Manufacturing.ProductLine.Fruit;

/**
 * TODO:梨类
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:39
 */
public class Pear extends RawMaterial {

    public Pear(int size, int quality) {
        super.setSize(size);
        super.setQuality(quality);
        super.setKind("pear");
    }

    public int getSize() {
        return super.getSize();
    }

    public int getQuality() {
        return super.getQuality();
    }

    public String getKind() {
        return super.getKind();
    }

    @Override
    public String toString() {
        return "Pear{" +
                "quality=" + super.getQuality() +
                ", size=" + super.getSize() +
                '}';
    }
}
