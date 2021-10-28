package Manufacturing.Machine.CanTreatmentMachine;

import Manufacturing.CanEntity.Can;
import Manufacturing.Ingredient.Ingredient;
import Manufacturing.Machine.CanMachine;

/**
 * 处理罐头
 *
 * @author 卓正一
 * @since  2021/10/28 10:38 PM
 */
public class IronCanProducingMachine implements CanMachine {

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
