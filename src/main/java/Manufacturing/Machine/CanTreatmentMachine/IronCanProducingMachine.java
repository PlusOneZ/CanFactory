package Manufacturing.Machine.CanTreatmentMachine;

import Manufacturing.CanEntity.Can;
import Manufacturing.Ingredient.Ingredient;
import Manufacturing.Machine.CanMachine;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理罐头
 *
 * @author 卓正一
 * @since  2021/10/28 10:38 PM
 */
public class IronCanProducingMachine extends CanMachine {

    @Override
    public void preTreat(Can can) {
        can.getDisinfection();
    }

    @Override
    public void fill(Can can, Ingredient... ingredients) {
        for (Ingredient i :
                ingredients) {
            can.addIngredient(i);
        }
    }

    @Override
    public void can(Can can) {
        can.getCanned();
    }

    private IronCanProducingMachine() {
        super();
    }

    static protected List<IronCanProducingMachine> canMachines = new ArrayList<>();

    static protected int current = 0;

    static protected int amount;

    static private int getNextPosition() {
        current++;
        while (current >= canMachines.size()) {
            current %= canMachines.size();
        }
        return current;
    }

    static public IronCanProducingMachine getInstance() {
        return canMachines.get(getNextPosition());
    }

    static {
        amount = 5;
        for (int i = 0; i < amount; i++) {
            canMachines.add(new IronCanProducingMachine());
        }
    }

    /**
     * 多例测试
     * @author 卓正一
     * @since 2021-10-31 1:49 AM
     */
    public static void main(String[] args) {
        CanMachine machine = IronCanProducingMachine.getInstance();
        CanMachine machine1 = IronCanProducingMachine.getInstance();
        System.out.println(machine == machine1);
    }
}
