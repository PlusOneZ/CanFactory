package Manufacturing.CanEntity;

import Manufacturing.CanEntity.Material.Material;
import Manufacturing.CanEntity.Size.Size;

/**
 * 生鲜罐头
 * 桥接模式
 * @author 汪明杰
 * @date 2021/10/30 16:05
 */
public class FreshCan extends Can {
    public FreshCan(Size s, Material c) {
        super.setSize(s);
        super.setMaterial(c);
    }
}
