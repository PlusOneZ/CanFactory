package Manufacturing.ProductLine.Fruit;

/**
 * TODO:黄桃类
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:39
 */
public class Peach extends RawMaterial {

    public Peach(int size, int quality) {
        super.setSize(size);
        super.setQuality(quality);
        super.setKind("peach");
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
        return "Peach{" +
                "quality=" + super.getQuality() +
                ", size=" + super.getSize() +
                '}';
    }
}
