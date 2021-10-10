package Marketing.Promotion.SellStrategy;

import Presentation.Protocol.OutputManager;

/**
 * 具体的销售策略 - 打八折
 *
 * @author 吴英豪
 */
public class TwentyPercentOff implements SellStrategy {
    @Override
    public Double discount(Double originalPrice) {
        double price = originalPrice * 0.8;
        OutputManager.getInstance().print(
                "可享受8折优惠。",
                "可享受8折優惠。",
                "You can enjoy a 20% discount.");
        OutputManager.getInstance().print(
                "优惠价格为:" + price,
                "優惠價格為:" + price,
                "Preferential price is:" + price);
        return price;
    }
}
