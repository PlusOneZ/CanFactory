package Manufacturing.ProductLine.Pretreatment.Test;

import Manufacturing.Ingredient.BaseIngredient;
import Manufacturing.Ingredient.ConcreteIngredient.Apple;
import Manufacturing.Ingredient.Ingredient;
import Manufacturing.ProductLine.Pretreatment.PretreatmentApp;
import Presentation.Protocol.OutputManager;

import java.util.ArrayList;
import java.util.List;


/**
 * 外观模式、过滤器模式测试类
 *
 * @author 孟繁霖
 * @date 2021/10/27 17:58
 */
public class FacadeTest {
    public static void main(String[] args) {
        PretreatmentApp pretreatmentApp=new PretreatmentApp();
        List<Ingredient> baseIngredientList=new ArrayList<>();
        for (int i = 0; i <10; i++) {
            Apple apple =new Apple();
            Double d=100+Math.random()*200;
            apple.setWeight(d);
            baseIngredientList.add(apple);
        }
        OutputManager.getInstance().print(
                "获取的原料分别为:",
                "獲取的原料分別為:",
                "The raw materials obtained are:");
        for (Ingredient baseIngredient : baseIngredientList) {
            OutputManager.getInstance().print(
                    baseIngredient.zhCnDescription(),
                    baseIngredient.zhTwDescription(),
                    baseIngredient.enDescription()
            );
        }
        OutputManager.getInstance().print(
                "利用外观模式进行三项原料预处理工作:",
                "利用外觀模式進行三項原料預處理工作：",
                "Three raw material pretreatment works are carried out by using appearance pattern:");
        pretreatmentApp.disinfect(baseIngredientList);
        pretreatmentApp.peel(baseIngredientList);
        pretreatmentApp.filterTreat(baseIngredientList);//筛选结果为质量大于150的原料
    }
}
