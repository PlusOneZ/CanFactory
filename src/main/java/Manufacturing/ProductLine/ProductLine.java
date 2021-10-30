package Manufacturing.ProductLine;

import Manufacturing.CanEntity.Can;
import Manufacturing.Ingredient.Ingredient;

import java.util.List;

/**
* 生产线总接口
*
* @author 孟繁霖
* @date 2021-10-25 15:06
*/
public interface ProductLine {

    /**
    * 获取具体生产线的名字（如appleLine,peachLine等）
    * @return : java.lang.String
    * @author 孟繁霖
    * @date 2021-10-25 15:05
    */
    String getConcreteName();

    List<Ingredient> preTreat(List<Ingredient> baseIngredientList);

    /**
     * 加工罐头
     *
     * @param count :  加工的罐头数量
     * @Param produceManner:  加工方式
     * @author 孟繁霖
     * @since  2021-10-11 23:42
     */
    List<Can> produce(int count);
}
