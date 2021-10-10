package Manufacturing.Machine;

import Manufacturing.CanEntity.Can;

import java.util.ArrayList;

/**
 *
 * @author 梁乔
 */
public abstract class Machine {
    private ArrayList<Can> CanList;

    public void addNewCan(Can can){
        CanList.add(can);
    }

    public abstract void createPackedCan();
}
