package Manufacturing.ProductLine;


import Manufacturing.ProductLine.Fruit.*;

import java.util.ArrayList;
import java.util.List;


/**
 * TODO:供应商
 *
 * @author 孟繁霖
 * @date 2021-10-11 23:51
 */
public class Supplier {

    /**
     * TODO:提供原料
     *
     * @param kind  : 原料所属种类（fruit,fresh）
     * @param count :  原料数量
     * @return : java.util.List<Manufacturing.ProductLine.Fruit.RawMaterial>
     * @author 孟繁霖
     * @date 2021-10-11 23:51
     */
    public List<RawMaterial> provide(String kind, int count) {
        List<RawMaterial> rawMaterialList = new ArrayList<>();
        if ("apple".equals(kind)) {
            for (int i = 0; i < count; i++) {
                rawMaterialList.add(new Apple(i, i + 5));
            }
        } else if ("pear".equals(kind)) {
            for (int i = 0; i < count; i++) {
                rawMaterialList.add(new Pear(i, i + 3));
            }
        } else if ("peach".equals(kind)) {
            for (int i = 0; i < count; i++) {
                rawMaterialList.add(new Peach(i, i + 6));
            }
        } else if ("salmon".equals(kind)) {
            for (int i = 0; i < count; i++) {
                rawMaterialList.add(new Salmon(i, i + 6));
            }
        } else if ("clove".equals(kind)) {
            for (int i = 0; i < count; i++) {
                rawMaterialList.add(new Clove(i, i + 6));
            }
        } else return null;
        return rawMaterialList;
    }
}
