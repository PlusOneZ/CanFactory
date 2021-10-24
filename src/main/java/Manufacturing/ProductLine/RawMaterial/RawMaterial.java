package Manufacturing.ProductLine.RawMaterial;

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
    private Double weight;

    /**
    * TODO:weight属性get方法
    * @return : java.lang.Double
    * @author 孟繁霖
    * @date 2021-10-24 14:39
    */
    public Double getWeight() {
        return weight;
    }

    /**
    * TODO:weight属性set方法
    * @param weight :  原材料质量
    * @author 孟繁霖
    * @date 2021-10-24 14:40
    */
    public void setWeight(Double weight) {
        this.weight = weight;
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
