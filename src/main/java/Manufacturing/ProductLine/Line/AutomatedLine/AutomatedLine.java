package Manufacturing.ProductLine.Line.AutomatedLine;

import Manufacturing.Ingredient.Ingredient;
import Manufacturing.Machine.GeneralMachine.CleanMachine;
import Manufacturing.Machine.GeneralMachine.DisinfectMachine;
import Manufacturing.Machine.GeneralMachine.FilterMachine;
import Manufacturing.Machine.GeneralMachine.PeelMachine;
import Manufacturing.ProductLine.ProductLine;

import java.util.ArrayList;
import java.util.List;

/**
 * 自动化生产线
 *
 * @author 卓正一
 * @since 2021/10/28 10:05 PM
 */
public abstract class AutomatedLine implements ProductLine {
    @Override
    public List<Ingredient> preTreat(List<Ingredient> baseIngredientList) {
        List<Ingredient> filtered = new ArrayList<>();
        FilterMachine filterMachine = new FilterMachine(200.);
        for (Ingredient i : baseIngredientList) {
            if (filterMachine.treat(i) != null) {
                filtered.add(i);
            }
        }

        CleanMachine cleanMachine = new CleanMachine();
        DisinfectMachine disinfectMachine = new DisinfectMachine();
        PeelMachine peelMachine = new PeelMachine();

        for (int i = 0; i < filtered.size(); i++) {
            filtered.set(i, cleanMachine.treat(
                    disinfectMachine.treat(
                            peelMachine.treat(
                                    filtered.get(i)
                            )
                    )
            ));
        }

        return filtered;
    }
}
