package Manufacturing.ProductLine.Fruit;

/**
 * TODO:丁香鱼类
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:40
 */
public class Clove extends RawMaterial {

    public Clove(int size, int quality) {
        super.setSize(size);
        super.setQuality(quality);
        super.setKind("clove");
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
        return "Clove{" +
                "quality=" + super.getQuality() +
                ", size=" + super.getSize() +
                '}';
    }
}
