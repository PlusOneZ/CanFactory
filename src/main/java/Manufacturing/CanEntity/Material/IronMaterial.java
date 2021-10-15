package Manufacturing.CanEntity.Material;

/**
 * 铁材质
 * 桥接模式
 * @author 汪明杰
 */
public class IronMaterial implements Material{
    static private IronMaterial ironMaterial = null;

    private IronMaterial(){

    }

    public static IronMaterial getInstance(){
        if (IronMaterial.ironMaterial == null){
            IronMaterial.ironMaterial = new IronMaterial();
        }
        return IronMaterial.ironMaterial;
    }

    @Override
    public MATERIAL getType() {
        return MATERIAL.IRON;
    }
}
