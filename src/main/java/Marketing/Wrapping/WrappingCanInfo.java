package Marketing.Wrapping;


import Manufacturing.Ingredient.Ingredient;

import java.util.List;

/**
 * TODO：罐头属性的添加，如生产日期，保质期
 * @Author 王立友
 * 包装封面中罐头的实体信息属性,如名称，质量，原料
 * TODO: 根据罐头的类别编号确定背景颜色(背景图url) 桥接模式
 */

public class WrappingCanInfo {

    private String canName;
    private float weight;
    private List<Ingredient> ingredients;


    public void setIngredients(List<Ingredient> ingredients){
        this.ingredients = ingredients;
    }

    public void setCanName(String canName){
        this.canName = canName;
    }

    public void setWeight(float weight){
        this.weight = weight;
    }

}
