package Manufacturing.Ingredient.Procedure.Pretreat;

import Manufacturing.Ingredient.Ingredient;
import Manufacturing.Ingredient.Procedure.Procedure;
import Presentation.Protocol.OutputManager;

/**
 * Disinfect 操作
 *
 * @author 卓正一
 * @since  2021/10/25 9:09 PM
 */
public class Disinfect extends Procedure {

    public Disinfect(Ingredient ingredient) {
        super(ingredient);

        setName(
                "",
                "",
                ""
        );

        OutputManager.getInstance().print(
                "消毒了" + showContents(),
                "消毒了" + showContents(),
                "Disinfected " + showContents()
        );
    }
}
