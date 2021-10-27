package Manufacturing.ProductLine;

import Manufacturing.Ingredient.Ingredient;
import Manufacturing.ProductLine.Pretreatment.PretreatmentApp;

import java.util.List;

/**
 * TODO:生鲜罐头生产线接口,预处理原料、生产罐头产品
 *
 * @author 孟繁霖
 * @date 2021-10-11 23:39
 */
public interface FreshLine extends ProductLine{


    PretreatmentApp pretreatmentApp = new PretreatmentApp();

    /**
     * TODO:预处理
     *
     * @param baseIngredientList :  原材料列表
     * @return : java.util.List<Manufacturing.ProductLine.Fruit.RawMaterial>
     * @author 孟繁霖
     * @date 2021-10-11 23:41
     */
    List<Ingredient> preTreat(List<Ingredient> baseIngredientList);

    /**
     * TODO:加工罐头
     *
     * @param count :  加工的罐头数量
     * @author 孟繁霖
     * @date 2021-10-11 23:42
     */
    void produce(int count);
}
