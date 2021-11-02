package Marketing.Promotion.Sale;

import Presentation.Protocol.IOManager;

/**
 * 具体的销售策略 - 打八折
 *
 * @author 吴英豪
 */
public class TwentyPercentOff implements Sale {
    @Override
    public Double discount(Double originalPrice) {
        IOManager.getInstance().print(
                "# 使用策略模式，计算产品优惠价格",
                "# 使用策略模式，計算產品優惠價格",
                "# using strategy pattern,calculating the price");
        IOManager.getInstance().print(
                "产品原价为:" + String.format("%.2f",originalPrice),
                "產品原價爲:" + String.format("%.2f",originalPrice),
                "The product's originalPrice is" + String.format("%.2f",originalPrice));
        double price = originalPrice * 0.8;
        IOManager.getInstance().print(
                "可享受8折优惠。",
                "可享受8折優惠。",
                "You can enjoy a 20% discount.");
        IOManager.getInstance().print(
                "优惠价格为:" + String.format("%.2f",price),
                "優惠價格為:" + String.format("%.2f",price),
                "Preferential price is:" + String.format("%.2f",price));
        return price;
    }
}
