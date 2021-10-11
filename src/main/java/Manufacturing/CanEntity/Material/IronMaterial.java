package Manufacturing.CanEntity.Material;

/**
 * 铁材质
 * @author 汪明杰
 */
public class IronMaterial implements Material{

    @Override
    public MATERIAL getType() {
        return MATERIAL.IRON;
    }
}
