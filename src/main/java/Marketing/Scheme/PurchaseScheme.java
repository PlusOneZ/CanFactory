package Marketing.Scheme;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 委派模式
 * 采购方案
 *
 * @author 吴英豪
 * @since 2021-10-20 08:13
 */
public class PurchaseScheme extends Scheme {

    public PurchaseScheme() {
        scheme = new ArrayList<JSONObject>();
    }

    /**
     * 在采购方案中添加内容
     *
     * @param demand 采购内容
     */
    public void addDemand(JSONObject demand) {
        scheme.add(demand);
    }

    /**
     * 获取方案细则
     *
     * @return 方案内容
     */
    public List<JSONObject> getScheme() {
        return scheme;
    }

    private List<JSONObject> scheme;

}
