package Manufacturing.CanEntity;

import Manufacturing.Ingredient.MixedIngredient;

import java.util.List;

/**
* 该类继承自Can抽象类，表示一种具体的罐头：肉类罐头
* @author 梁乔
* @date 2021-10-11 19:29
*/
public class MeatCan  extends Can{

    private List<MixedIngredient> MeatCanIntegredient;

    /**
     *
     * @param newMeatIntegredient 传入的配方列表，罐头名称为固定值无法修改
     */
    public MeatCan(List<MixedIngredient> newMeatIntegredient){
        MeatCanIntegredient=newMeatIntegredient;
        CanName="MeatCan";
    }

    public MeatCan(){
        CanName = "MeatCan";
    }

    public String getCanName(){
        return CanName;
    }



}
