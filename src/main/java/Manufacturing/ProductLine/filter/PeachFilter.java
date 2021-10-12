package Manufacturing.ProductLine.filter;


import Manufacturing.ProductLine.Fruit.RawMaterial;

import java.util.List;

/**
 * TODO:黄桃过滤器类，聚合了大小过滤器、质量过滤器，筛选黄桃
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:46
 */
public class PeachFilter implements Filter {

    private final SizeFilter sizeFilter;
    private final QualityFilter qualityFilter;

    public PeachFilter(int sizeCriterion, int qualityCriterion) {
        this.sizeFilter = new SizeFilter(sizeCriterion);
        this.qualityFilter = new QualityFilter(qualityCriterion);
    }

    @Override
    public List<RawMaterial> select(List<RawMaterial> rawMaterialList) {
        return qualityFilter.select(sizeFilter.select(rawMaterialList));
    }
}
