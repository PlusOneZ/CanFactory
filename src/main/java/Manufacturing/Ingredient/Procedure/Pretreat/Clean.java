package Manufacturing.Ingredient.Procedure.Pretreat;

import Manufacturing.Ingredient.Ingredient;
import Manufacturing.Ingredient.Procedure.Procedure;
import Presentation.Protocol.OutputManager;

/**
 * Clean 操作
 *
 * @author 卓正一
 * @since  2021/10/25 4:25 PM
 */
public class Clean extends Procedure {
    public Clean(Ingredient ingredient) {
        super(ingredient);

        OutputManager.getInstance().print(
                "清洗了" + showContents(),
                "清洗了" + showContents(),
                "Cleaned " + showContents()
        );

        setName(
                "",
                "",
                ""
        );
    }
}