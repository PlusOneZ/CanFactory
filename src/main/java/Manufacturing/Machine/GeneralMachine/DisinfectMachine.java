package Manufacturing.Machine.GeneralMachine;

import Manufacturing.Ingredient.Ingredient;
import Manufacturing.Ingredient.Procedure.Pretreat.Disinfect;
import Manufacturing.Machine.Machine;

/**
 * 消毒机器
 *
 * @author 卓正一
 * @since 2021/10/26 12:16 AM
 */
public class DisinfectMachine implements Machine {
    @Override
    public Ingredient treat(Ingredient ingredient) {
        return new Disinfect(ingredient);
    }
}
