package Manufacturing.CanEntity.Material;

// TODO：使用享元模式来产生材质信息。
/**
 * 材质
 * 桥接模式
 * @author 汪明杰
 */
public interface Material {

    public enum MATERIAL{
        IRON, ALUMINIM, ALLOY
    }

    public MATERIAL getType();

}
