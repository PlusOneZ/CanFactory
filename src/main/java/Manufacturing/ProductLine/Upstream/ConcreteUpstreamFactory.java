package Manufacturing.ProductLine.Upstream;

import Presentation.Protocol.OutputManager;
import org.json.JSONObject;

import java.util.Random;

/**
 * TODO:上游工厂
 * 实现了Observer模式中的Observer
 *
 * @author 香宁雨
 * @since 2021/10/11 23:28
 */

public class ConcreteUpstreamFactory implements UpstreamFactory {
    private String ingredient;

    private Double weight;

    private String[] ingredientType = new String[]{"apple", "clove", "peach", "pear", "salmon"};

    public ConcreteUpstreamFactory() {
        Random r = new Random();
        Integer i = r.nextInt(ingredientType.length);
        this.ingredient = ingredientType[i];
        this.weight = r.nextDouble() * 10;
        OutputManager.getInstance().print(
                "新建了上游工厂",
                "新建了上遊工廠",
                "Create a new upstream factory"
        );
    }

    public void purchase() {
        weight = 0.0;
        OutputManager.getInstance().print(
                "成功从上游工厂进行购买",
                "成功從上遊工廠進行購買",
                "Successful purchase from upstream factory"
        );
    }

    @Override
    public JSONObject getInfo() {
        JSONObject ingredient = new JSONObject();
        ingredient.put("ingredientType", this.ingredient);
        ingredient.put("weight", this.weight);
        OutputManager.getInstance().print(
                "当前上游工厂所拥有原材料及其重量为" + ingredient,
                "當前上遊工廠所擁有原材料及其重量為" + ingredient,
                "The current raw material and the weight owned by the upstream factory is" + ingredient
        );
        return ingredient;
    }


    public static void main(String[] args) {
    }


}
