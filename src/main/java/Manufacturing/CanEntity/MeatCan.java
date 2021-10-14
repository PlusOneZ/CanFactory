package Manufacturing.CanEntity;

import Manufacturing.Ingredient.MixedIngredient;

import java.util.List;

/**
* 该类继承自Can抽象类，表示一种具体的罐头：肉类罐头
* @author 梁乔
* @date 2021-10-11 19:29
*/
<<<<<<< Updated upstream
public class MeatCan  extends Can {

    public MeatCan(){
        setName("肉罐头", "肉罐頭", "Meat Can");
    }

=======
public class MeatCan  extends Can{

    private List<MixedIngredient> MeatCanIntegredient;

    MeatCan(String Name, float Price, float weight) {
        super(Name, Price, weight);
    }


    @Override
    public boolean otherTests() {
        return false;
    }

    public String getCanName(){
        return CanName;
    }

    public MeatCan(){
        CanName = "MeatCan";
    }





>>>>>>> Stashed changes
}
