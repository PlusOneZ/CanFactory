package Manufacturing.ProductLine.filter;

import Manufacturing.ProductLine.Fruit.RawMaterial;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO:大小过滤器类，筛选原料大小
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:40
 */
public class SizeFilter implements Filter {

    /**
     * TODO:大小标准值
     */
    private final int criterion;

    public SizeFilter(int criterion) {
        this.criterion = criterion;
    }

    @Override
    public List<RawMaterial> select(List<RawMaterial> rawMaterialList) {
        List<RawMaterial> res = new ArrayList<>();
        for (RawMaterial rawMaterial : rawMaterialList) {
            if (rawMaterial.getSize() > criterion) {
                res.add(rawMaterial);
            }
        }
        return res;
    }
}
