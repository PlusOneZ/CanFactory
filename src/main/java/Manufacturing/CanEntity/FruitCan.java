package Manufacturing.CanEntity;

import Manufacturing.CanEntity.Material.Material;
import Manufacturing.CanEntity.Size.Size;


/**
 * 水果罐头
 * 桥接模式
 * @author 汪明杰
 */
public class FruitCan extends Can{

    public FruitCan(Size s, Material c) {
        super.setSize(s);
        super.setMaterial(c);
    }




}
