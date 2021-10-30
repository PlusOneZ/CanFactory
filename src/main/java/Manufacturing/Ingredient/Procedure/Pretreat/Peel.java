package Manufacturing.Ingredient.Procedure.Pretreat;

import Manufacturing.Ingredient.Ingredient;
import Manufacturing.Ingredient.Procedure.Procedure;
import Presentation.Protocol.OutputManager;

/**
 * 削皮
 *
 * @author 卓正一
 * @since  2021/10/25 11:30 PM
 */
public class Peel extends Procedure {
    public Peel(Ingredient ingredient) {
        super(ingredient);

        setName(
                "",
                "",
                ""
        );

        OutputManager.getInstance().print(
                "削皮了" + showContents(),
                "削皮了" + showContents(),
                "Peeled " + showContents()
        );
    }
}
