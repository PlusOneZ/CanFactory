package Manufacturing.ProductLine.Pretreatment;


import Manufacturing.Ingredient.BaseIngredient;
import Manufacturing.Ingredient.ConcreteIngredient.*;
import Manufacturing.ProductLine.Filter.*;

import java.util.List;

/**
 * TODO:过滤筛选预处理类.
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:28
 */
public class FilterTreat implements Pretreatment {


    private final AppleFilter appleFilter = new AppleFilter(150.0);
    private final PearFilter pearFilter = new PearFilter(150.0);
    private final PeachFilter peachFilter = new PeachFilter(150.0);
    private final SalmonFilter salmonFilter = new SalmonFilter(150.0);
    private final CloveFilter cloveFilter = new CloveFilter(150.0);


    @Override
    public List<BaseIngredient> treat(List<BaseIngredient> baseIngredientList) {
        //这里调用不同过滤器
        if (baseIngredientList != null && !baseIngredientList.isEmpty()) {

            if (baseIngredientList.get(0) instanceof Apple) {
                return appleFilter.select(baseIngredientList);
            } else if (baseIngredientList.get(0) instanceof Pear) {
                return pearFilter.select(baseIngredientList);
            } else if (baseIngredientList.get(0) instanceof Peach) {
                return peachFilter.select(baseIngredientList);
            } else if (baseIngredientList.get(0) instanceof Salmon) {
                return salmonFilter.select(baseIngredientList);
            } else if (baseIngredientList.get(0) instanceof Clove) {
                return cloveFilter.select(baseIngredientList);
            } else {
                return null;
            }
        } else return null;//没有传进原材料或null
    }
}
