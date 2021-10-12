package Manufacturing.ProductLine.Fruit;

/**
 * TODO:三文鱼类
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:34
 */
public class Salmon extends RawMaterial {

    public Salmon(int size, int quality) {
        super.setQuality(quality);
        super.setSize(size);
        super.setKind("salmon");
    }

    public String getKind() {
        return super.getKind();
    }

    public int getQuality() {
        return super.getQuality();
    }

    public int getSize() {
        return super.getSize();
    }

    @Override
    public String toString() {
        return "Salmon{" +
                "quality=" + super.getQuality() +
                ", size=" + super.getSize() +
                '}';
    }
}
