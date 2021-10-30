package Manufacturing.CanEntity.ConcreteCan;


import Manufacturing.CanEntity.FreshCan;
import Manufacturing.CanEntity.Material.Material;
import Manufacturing.CanEntity.Size.Size;

/**
 * 三文鱼罐头
 *
 * @author 汪明杰
 * @date 2021/10/30 16:02
 */
public class SalmonCan extends FreshCan {
    public SalmonCan(Size s, Material c) {
        super(s, c);
        this.setName(
                "三文鱼罐头",
                "鲑鱼罐頭",
                "Salmon Can"
        );
    }
}
