package Manufacturing.CanEntity.Material;


/**
 * 材质
 * @author 汪明杰
 */
public interface Material {

    public enum MATERIAL{
        IRON, ALUMINIM, ALLOY
    }

    public MATERIAL getType();

}
