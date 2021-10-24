package Manufacturing.ProductLine.Filter;


import Manufacturing.ProductLine.RawMaterial.RawMaterial;

import java.util.List;

/**
 * TODO:黄桃过滤器类，聚合了大小过滤器、质量过滤器，筛选黄桃
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:46
 */
public class PeachFilter implements Filter {

    private final WeightFilter weightFilter;

    public PeachFilter(Double weightCriterion) {
        this.weightFilter = new WeightFilter(weightCriterion);
    }

    @Override
    public List<RawMaterial> select(List<RawMaterial> rawMaterialList) {
        return weightFilter.select(rawMaterialList);
    }
}
