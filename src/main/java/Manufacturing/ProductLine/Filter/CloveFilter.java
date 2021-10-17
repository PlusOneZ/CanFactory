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

    private final SizeFilter sizeFilter;
    private final QualityFilter qualityFilter;

    public CloveFilter(int sizeCriterion, int qualityCriterion) {
        this.sizeFilter = new SizeFilter(sizeCriterion);
        this.qualityFilter = new QualityFilter(qualityCriterion);
    }

    @Override
    public List<RawMaterial> select(List<RawMaterial> rawMaterialList) {
        return qualityFilter.select(sizeFilter.select(rawMaterialList));
    }
}
