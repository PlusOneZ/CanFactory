package Manufacturing.ProductLine.pretreatment;


import Manufacturing.ProductLine.Fruit.*;
import Manufacturing.ProductLine.filter.*;

import java.util.List;

/**
 * TODO:过滤筛选预处理类.
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:28
 */
public class FilterTreat implements Pretreatment {


    private final AppleFilter appleFilter = new AppleFilter(1, 5);
    private final PearFilter pearFilter = new PearFilter(2, 3);
    private final PeachFilter peachFilter = new PeachFilter(2, 3);
    private final SalmonFilter salmonFilter = new SalmonFilter(1, 2);
    private final CloveFilter cloveFilter = new CloveFilter(2, 3);


    @Override
    public List<RawMaterial> treat(List<RawMaterial> rawMaterialList) {
        //这里调用不同过滤器
        if (rawMaterialList != null && !rawMaterialList.isEmpty()) {

            if (rawMaterialList.get(0) instanceof Apple) {
                return appleFilter.select(rawMaterialList);
            } else if (rawMaterialList.get(0) instanceof Pear) {
                return pearFilter.select(rawMaterialList);
            } else if (rawMaterialList.get(0) instanceof Peach) {
                return peachFilter.select(rawMaterialList);
            } else if (rawMaterialList.get(0) instanceof Salmon) {
                return salmonFilter.select(rawMaterialList);
            } else if (rawMaterialList.get(0) instanceof Clove) {
                return cloveFilter.select(rawMaterialList);
            } else {
                return null;
            }
        } else return null;//没有传进原材料或null
    }
}