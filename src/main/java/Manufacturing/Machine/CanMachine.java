package Manufacturing.Machine;

import Manufacturing.CanEntity.Can;
import Manufacturing.Ingredient.Ingredient;

/**
 * 罐头机器，处理罐头用。
 *
 * @author 卓正一
 * @since  2021/10/28 12:21 AM
 */
public interface CanMachine {

    void preTreat(Can can);

    void fill(Can can, Ingredient... ingredients);

    void can(Can can);
}
