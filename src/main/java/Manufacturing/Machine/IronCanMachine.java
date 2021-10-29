package Manufacturing.Machine;

import Manufacturing.CanEntity.Can;
import Manufacturing.Ingredient.Ingredient;

/**
 * TODO:此处写IronCanMachine类的描述
 *
 * @author 卓正一
 * @since 2021/10/28 1:08 AM
 */
public class IronCanMachine implements CanMachine{

    @Override
    public void preTreat(Can can) {
        can.getDisinfection();
    }

    @Override
    public void fill(Can can, Ingredient ... ingredients) {
        for (Ingredient i: ingredients) {
            can.addIngredient(i);
        }
    }

    @Override
    public void can(Can can) {
        can.getCanned();
    }

}
