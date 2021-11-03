package Marketing.Promotion.Sale;

import Presentation.Protocol.IOManager;

/**
 * 销售策略：满200减20
 *
 * @author 吴英豪
 */
public class TwoHundredMinusTwenty implements Sale {
    @Override
    public Double discount(Double originalPrice) {
        IOManager.getInstance().print(
                "# 使用策略模式：计算产品优惠价格",
                "# 使用策略模式：計算產品優惠價格",
                "# Using strategy pattern: calculating the price");
        IOManager.getInstance().print(
                "产品原价为:" + String.format("%.2f",originalPrice),
                "產品原價爲:" + String.format("%.2f",originalPrice),
                "The product's originalPrice is" + String.format("%.2f",originalPrice));
        Double price = originalPrice;
        if (originalPrice >= 200) {
            price = originalPrice - (originalPrice / 200 * 20);
            IOManager.getInstance().print(
                    "可以享受满200减20的优惠。",
                    "可以享受滿200減20的優惠。",
                    "You can take 20 off the 200 mark.");
            IOManager.getInstance().print(
                    "优惠价格为:" + String.format("%.2f",price),
                    "優惠價格為:" + String.format("%.2f",price),
                    "Preferential price is:" + String.format("%.2f",price));
        } else {
            IOManager.getInstance().print(
                    "抱歉，无法享受满200减20的优惠。",
                    "抱歉，無法享受滿200減20的優惠。",
                    "You can not take 20 off the 200 mark.");
        }
        return price;
    }
}
