package Manufacturing.CanEntity.ConcreteCan;

import Manufacturing.CanEntity.FruitCan;
import Manufacturing.CanEntity.Material.Material;
import Manufacturing.CanEntity.Size.Size;

/**
 * 黄桃罐头
 *
 * @author 汪明杰
 * @date 2021/10/30 15:39
 */
public class PeachCan extends FruitCan {

    public PeachCan(Size s, Material c) {
        super(s, c);
        this.setName(
                "黄桃罐头",
                "黃桃罐頭",
                "Peach Can"
        );
    }
}