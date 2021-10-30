package Manufacturing.CanEntity.Material;

/**
 * 玻璃材质
 * 桥接模式
 * @author 汪明杰
 */
public class GlassMaterial implements Material {

    static private GlassMaterial glassMaterial = null;

    private GlassMaterial() {

    }

    public static GlassMaterial getInstance() {
        if (GlassMaterial.glassMaterial == null) {
            GlassMaterial.glassMaterial = new GlassMaterial();
        }
        return GlassMaterial.glassMaterial;
    }

    @Override
    public MATERIAL getType() {
        return MATERIAL.GLASS;
    }
}
