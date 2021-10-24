package Manufacturing.ProductLine.Filter;

import Manufacturing.ProductLine.RawMaterial.RawMaterial;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO:大小过滤器类，筛选原料大小
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:40
 */
public class WeightFilter implements Filter {

    /**
     * TODO:质量标准值
     */
    private final Double criterion;

    public WeightFilter(Double criterion) {
        this.criterion = criterion;
    }

    @Override
    public List<RawMaterial> select(List<RawMaterial> rawMaterialList) {
        List<RawMaterial> res = new ArrayList<>();
        for (RawMaterial rawMaterial : rawMaterialList) {
            if (rawMaterial.getWeight() > criterion) {
                res.add(rawMaterial);
            }
        }
        return res;
    }
}
