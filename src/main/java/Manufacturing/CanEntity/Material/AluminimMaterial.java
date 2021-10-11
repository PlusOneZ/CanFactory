package Manufacturing.CanEntity.Material;

/**
 * 铝材质
 * 桥接模式
 * @author 汪明杰
 */
public class AluminimMaterial implements Material{
    @Override
    public MATERIAL getType() {
        return MATERIAL.ALUMINIM;
    }
}
