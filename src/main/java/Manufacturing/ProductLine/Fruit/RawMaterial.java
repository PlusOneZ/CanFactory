package Manufacturing.ProductLine.Fruit;

/**
 * TODO:原料类，所有原材料父类
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:34
 */
public class RawMaterial {
    /**
     * TODO:原料种类
     */
    private String kind;
    /**
     * TODO:原料大小
     */
    private int size;
    /**
     * TODO:原料质量好坏（数值越大越好）
     */
    private int quality;

    /**
     * TODO:quality属性get方法.
     *
     * @return : int
     * @author 孟繁霖
     * @date 2021-10-12 8:36
     */
    public int getQuality() {
        return quality;
    }

    /**
     * TODO:quality属性set方法.
     *
     * @param quality :  原材料质量好坏评级
     * @author 孟繁霖
     * @date 2021-10-12 8:36
     */
    public void setQuality(int quality) {
        this.quality = quality;
    }


    /**
     * TODO:size属性set方法.
     *
     * @param size : 原材料大小
     * @author 孟繁霖
     * @date 2021-10-12 8:37
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * TODO:size属性get方法.
     *
     * @return : int
     * @author 孟繁霖
     * @date 2021-10-12 8:37
     */
    public int getSize() {
        return size;
    }

    /**
     * TODO:kind属性set方法.
     *
     * @param kind :  原材料种类
     * @author 孟繁霖
     * @date 2021-10-12 8:38
     */
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * TODO:kind属性get方法.
     *
     * @return : java.lang.String
     * @author 孟繁霖
     * @date 2021-10-12 8:38
     */
    public String getKind() {
        return kind;
    }


}
