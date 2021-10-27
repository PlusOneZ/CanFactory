package Manufacturing.Machine.CombinationPart;

import Manufacturing.Ingredient.Ingredient;
import Manufacturing.Machine.Machine;
import Presentation.Protocol.OutputManager;

/**
 * TODO:此处写CandiedAppleMachine类的描述
 *
 * @author 卓正一
 * @date 2021/10/27 9:07 PM
 */
public class CandiedAppleMachine implements Machine {
    @Override
    public Ingredient treat(Ingredient ingredient) {
        // 不会发生任何事
        return ingredient;
    }

    @Override
    public Ingredient combine(Ingredient... ingredients) {

        return Machine.super.combine(ingredients);
    }
}
