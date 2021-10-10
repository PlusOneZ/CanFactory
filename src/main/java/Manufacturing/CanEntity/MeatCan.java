package Manufacturing.CanEntity;

import Manufacturing.Ingredient.MixedIngredient;

import java.util.List;

/**
 * @author 梁乔 2021/10/10
 **/
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
