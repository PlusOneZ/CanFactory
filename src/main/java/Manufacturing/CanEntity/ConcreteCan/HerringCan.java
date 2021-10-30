package Manufacturing.CanEntity.ConcreteCan;

import Manufacturing.CanEntity.FreshCan;
import Manufacturing.CanEntity.Material.Material;
import Manufacturing.CanEntity.Size.Size;

/**
 * 鲱鱼罐头
 *
 * @author 汪明杰
 * @date 2021/10/30 16:07
 */
public class HerringCan extends FreshCan {
    public HerringCan(Size s, Material c) {
        super(s, c);
        this.setName(
                "鲱鱼罐头",
                "鲱鱼罐頭",
                "Herring Can"
        );
    }
}
