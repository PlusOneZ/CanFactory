package Manufacturing.CanEntity.Material;

/**
 * 合金材质
 * 桥接模式
 * @author 汪明杰
 */
public class AlloyMaterial implements Material{
    @Override
    public MATERIAL getType() {
        return MATERIAL.ALLOY;
    }
}
