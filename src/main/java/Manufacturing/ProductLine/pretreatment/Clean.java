package Manufacturing.ProductLine.pretreatment;


import Manufacturing.ProductLine.Fruit.RawMaterial;

import java.util.List;

/**
 * TODO:清洗预处理类
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:29
 */
public class Clean implements Pretreatment {
    @Override
    public List<RawMaterial> treat(List<RawMaterial> rawMaterialList) {
        return rawMaterialList;
    }
}
