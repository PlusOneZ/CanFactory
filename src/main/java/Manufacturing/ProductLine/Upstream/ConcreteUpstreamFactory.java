package Manufacturing.ProductLine.Upstream;

import Presentation.Protocol.IOManager;
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

    private Integer count;

    private String[] ingredientType = new String[]{"candiedapple", "herring", "peach", "pear", "salmon"};

    /**
     * 随机生成上游工厂的种类和数量
     * @author 香宁雨
     * @since 16:42 2021-10-24
     */
    public ConcreteUpstreamFactory() {
        Random r = new Random();
        Integer i = r.nextInt(ingredientType.length);
        this.ingredient = ingredientType[i];
        this.count = r.nextInt(500) + 1000;
    }

    /**
     * 从上游工厂购买产品并且将上游工厂中数量设置为0
     * @author 香宁雨
     * @since 16:44 2021-10-24
     */
    public void purchase() {
        count = 0;
        IOManager.getInstance().print(
                "成功从上游工厂进行购买",
                "成功從上遊工廠進行購買",
                "Successful purchase from upstream factory"
        );
    }

    /**
     * 获取上游工厂所拥有的原材料信息
     * @return : org.json.JSONObject
     * @author 香宁雨
     * @since 16:08 2021-10-24
     */
    @Override
    public JSONObject getInfo() {
        JSONObject ingredient = new JSONObject();
        ingredient.put("ingredientType", this.ingredient);
        ingredient.put("count", this.count);
        IOManager.getInstance().print(
                "当前上游工厂所拥有原材料及其个数为" + ingredient,
                "當前上遊工廠所擁有原材料及其個數為" + ingredient,
                "The current raw material and the count owned by the upstream factory is" + ingredient
        );
        return ingredient;
    }

}
