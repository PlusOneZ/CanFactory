package Manufacturing.ProductLine.filter;


import Manufacturing.ProductLine.Fruit.RawMaterial;

import java.util.ArrayList;

import java.util.List;

/**
 * TODO:质量过滤器类，筛选原料质量
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:43
 */
public class QualityFilter implements Filter {

    /**
     * TODO:质量标准值
     */
    private final int criterion;


    public QualityFilter(int criterion) {
        this.criterion = criterion;
    }

    @Override
    public List<RawMaterial> select(List<RawMaterial> rawMaterialList) {
        List<RawMaterial> res = new ArrayList<>();
        for (RawMaterial rawMaterial : rawMaterialList) {
            if (rawMaterial.getQuality() > criterion) {
                res.add(rawMaterial);
            }
        }
        return res;
    }
}
