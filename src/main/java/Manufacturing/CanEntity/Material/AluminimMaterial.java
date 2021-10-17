package Manufacturing.CanEntity.Material;

/**
 * 铝材质
 * 桥接模式
 * @author 汪明杰
 */
public class AluminimMaterial implements Material{
    static private AluminimMaterial aluminimMaterial = null;

    private AluminimMaterial(){

    }

    public static AluminimMaterial getInstance(){
        if (AluminimMaterial.aluminimMaterial == null){
            AluminimMaterial.aluminimMaterial = new AluminimMaterial();
        }
        return AluminimMaterial.aluminimMaterial;
    }

    @Override
    public MATERIAL getType() {
        return MATERIAL.ALUMINIM;
    }
}
