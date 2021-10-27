package Manufacturing.Machine.GeneralMachine;

import Manufacturing.Ingredient.Ingredient;
import Manufacturing.Ingredient.Procedure.Pretreat.Clean;
import Manufacturing.Machine.Machine;
import Presentation.Protocol.OutputManager;

/**
 * TODO:此处写CleanMachine类的描述
 *
 * @author 卓正一
 * @since  2021/10/24 11:01 AM
 */
public class CleanMachine implements Machine {

    @Override
    public Ingredient treat(Ingredient ingredient) {
        return new Clean(ingredient);
    }

}
