package Manufacturing.Machine;

import Manufacturing.Ingredient.Ingredient;
import Presentation.Protocol.OutputManager;

/**
 * 机器
 * @author 卓正一
 * @since 2021-10-24 11:07 AM
 */
public interface Machine {
    Ingredient treat(Ingredient ingredient);

    default Ingredient combine(Ingredient... ingredients) {
        OutputManager.getInstance().print(
                "CleanMachine 不能结合原材料",
                "CleanMachine 不能結合原材料",
                "CleanMachine cannot combine ingredients."
        );
        return null;
    }
}
