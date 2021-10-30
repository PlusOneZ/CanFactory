package Manufacturing.CanEntity.ConcreteCan;

import Manufacturing.CanEntity.FruitCan;
import Manufacturing.CanEntity.Material.Material;
import Manufacturing.CanEntity.Size.Size;

/**
 * 糖渍苹果罐头
 *
 * @author 卓正一
 * @since  2021/10/30 2:11 PM
 */
public class CandiedAppleCan extends FruitCan {

    public CandiedAppleCan(Size s, Material c) {
        super(s, c);
        this.setName(
                "糖渍苹果罐头",
                "糖漬蘋果罐頭",
                "Candied Apple Can"
        );
    }
}
