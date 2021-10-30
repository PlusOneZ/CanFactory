package Manufacturing.Machine.CanTreatmentMachine;

import Manufacturing.CanEntity.Can;
import Manufacturing.Ingredient.Ingredient;
import Manufacturing.Machine.CanMachine;

/**
 * 处理玻璃罐头
 *
 * @author 卓正一
 * @since  2021/10/30 10:21 PM
 */
public class GlassCanProducingMachine implements CanMachine {

    @Override
    public void preTreat(Can can) {
        can.getDisinfection();
    }

    @Override
    public void fill(Can can, Ingredient... ingredients) {
        for (Ingredient i :
                ingredients) {
            can.addIngredient(i);
        }
    }

    @Override
    public void can(Can can) {
        can.getCanned();
    }
}