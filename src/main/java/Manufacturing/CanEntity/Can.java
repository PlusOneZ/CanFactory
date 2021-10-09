package Manufacturing.CanEntity;


import Manufacturing.CanEntity.CanState.CanState;
import Manufacturing.Ingredient.Ingredient;

import java.util.List;

/**
 * 罐头是流水线中的最终产物，它是由"ingredients"装填而来的。
 * 罐头在处理中通过状态（而不是 if-else 语句）来控制其受操作的变化。 <br>
 * <b>实现了 State 模式</b> <br>
 * <b>内含了 Composite 模式实体</b> <br>
 * <b>实现了 Decorator 模式</b>
 * @author 卓正一
 */

public abstract class Can {
    public String CanName = new String();
    public float Price;
    public float Weight;
    Can(String Name,float Price,float weight ){
        this.CanName = Name;
        this.Price = Price;
        this.Weight = weight;
    }

    CanState state;

    List<Ingredient> ingredients;


}
