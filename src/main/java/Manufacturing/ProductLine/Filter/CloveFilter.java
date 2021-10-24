package Manufacturing.ProductLine.Filter;


import Manufacturing.ProductLine.RawMaterial.RawMaterial;

import java.util.List;

/**
 * TODO:丁香鱼过滤器类，聚合了大小过滤器、质量过滤器，筛选丁香鱼
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:48
 */
public class CloveFilter implements Filter {

    private final WeightFilter weightFilter;

    public CloveFilter(Double weightCriterion) {
        this.weightFilter = new WeightFilter(weightCriterion);
    }

    @Override
    public List<RawMaterial> select(List<RawMaterial> rawMaterialList) {
        return weightFilter.select(rawMaterialList);
    }
}
