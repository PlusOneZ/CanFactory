package Manufacturing.ProductLine.Filter;


import Manufacturing.ProductLine.RawMaterial.RawMaterial;

import java.util.List;

/**
 * TODO:梨过滤器类，聚合了大小过滤器、质量过滤器，筛选梨
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:45
 */
public class PearFilter implements Filter {
    private final SizeFilter sizeFilter;
    private final QualityFilter qualityFilter;

    public PearFilter(int sizeCriterion, int qualityCriterion) {
        this.sizeFilter = new SizeFilter(sizeCriterion);
        this.qualityFilter = new QualityFilter(qualityCriterion);
    }

    @Override
    public List<RawMaterial> select(List<RawMaterial> rawMaterialList) {
        return qualityFilter.select(sizeFilter.select(rawMaterialList));
    }
}
