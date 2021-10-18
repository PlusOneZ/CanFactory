package Manufacturing.ProductLine.Upstream;

import org.json.JSONObject;


/**
 * 上游原材料的接口，
 * 作为 Observer模式的Observer
 *
 * @author 香宁雨
 */
public interface UpstreamFactory {
    JSONObject getInfo();
}
