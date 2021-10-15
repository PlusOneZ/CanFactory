package Manufacturing.CanEntity.Material;

/**
 * 合金材质
 * 桥接模式
 * @author 汪明杰
 */
public class AlloyMaterial implements Material{

    static private AlloyMaterial alloyMaterial = null;

    private AlloyMaterial(){

    }

    public static AlloyMaterial getInstance(){
        if (AlloyMaterial.alloyMaterial == null){
            AlloyMaterial.alloyMaterial = new AlloyMaterial();
        }
        return AlloyMaterial.alloyMaterial;
    }

    @Override
    public MATERIAL getType() {
        return MATERIAL.ALLOY;
    }
}
