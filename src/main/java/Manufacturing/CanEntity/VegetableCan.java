package Manufacturing.CanEntity;

import Manufacturing.CanEntity.Material.Material;
import Manufacturing.CanEntity.Size.Size;

/**
 * 蔬菜罐头
 * 桥接模式
 * @author 汪明杰
 */
public class VegetableCan extends FactoryCan{
    public VegetableCan(Size s, Material c) {
        super(s, c);
    }
}
