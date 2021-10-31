package Manufacturing.Machine;

import Manufacturing.CanEntity.Can;
import Manufacturing.Ingredient.Ingredient;

import java.util.ArrayList;
import java.util.List;

/**
 * 罐头机器，处理罐头用。
 *
 * @author 卓正一
 * @since  2021/10/28 12:21 AM
 */
public abstract class CanMachine {

    public abstract void preTreat(Can can);

    public abstract void fill(Can can, Ingredient... ingredients);

    public abstract void can(Can can);
}
