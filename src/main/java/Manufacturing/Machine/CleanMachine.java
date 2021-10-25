package Manufacturing.Machine;

import Manufacturing.Ingredient.Ingredient;
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

        return null;
    }

    @Override
    public Ingredient combine(Ingredient... ingredients) {
        OutputManager.getInstance().print(
                "CleanMachine 不能结合原材料",
                "CleanMachine 不能結合原材料",
                "CleanMachine cannot combine ingredients."
        );
        return null;
    }
}
