package Manufacturing.ProductLine.Line;

import Manufacturing.Ingredient.Ingredient;

import java.util.List;

/**
 *
 *
 * @author 卓正一
 * @since 2021/10/27 12:17 AM
 */
public interface GeneralLine {

    List<Ingredient> preTreat(List<Ingredient> ingredients);


}
