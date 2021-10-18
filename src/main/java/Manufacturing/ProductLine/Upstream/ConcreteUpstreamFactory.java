package Manufacturing.ProductLine.Upstream;

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

    private String[] ingredientType = new String[]{"apple","clove","peach","pear","salmon"};

    ConcreteUpstreamFactory() {
        Random r = new Random();
        Integer i = r.nextInt(ingredientType.length);
        this.ingredient = ingredientType[i];
        this.weight = r.nextDouble() * 10;
    }

    public String getIngredient() {
        return ingredient;
    }

    public Double getWeight() {
        return weight;
    }

    public void purchase() {
        weight = 0.0;

    }

    @Override
    public JSONObject getInfo() {
        JSONObject ingredient = new JSONObject();
        ingredient.put("ingredientType",this.ingredient);
        ingredient.put("weight",this.weight);
        return ingredient;
    }



    public static void main(String[] args) {
    }


}

