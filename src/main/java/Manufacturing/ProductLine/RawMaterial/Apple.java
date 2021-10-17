package Manufacturing.ProductLine.RawMaterial;

/**
 * TODO:苹果类
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:40
 */
public class Apple extends RawMaterial {

    public Apple(int size, int quality) {
        super.setSize(size);
        super.setQuality(quality);
        super.setKind("apple");
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
        return "Apple{" +
                "quality=" + super.getQuality() +
                ", size=" + super.getSize() +
                '}';
    }
}
