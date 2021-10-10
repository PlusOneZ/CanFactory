package Marketing.Promotion.SellStrategy;

import Presentation.Protocol.OutputManager;

/**
 * 销售策略：满200减20
 *
 * @author 吴英豪
 */
public class TwoHundredMinusTwenty implements SellStrategy {
    @Override
    public Double discount(Double originalPrice) {
        Double price = originalPrice;
        if (originalPrice >= 200) {
            price = originalPrice - (originalPrice / 200 * 20);
            OutputManager.getInstance().print(
                    "可以享受满200减20的优惠。",
                    "可以享受滿200減20的優惠。",
                    "You can take 20 off the 200 mark.");
            OutputManager.getInstance().print(
                    "优惠价格为:" + price,
                    "優惠價格為:" + price,
                    "Preferential price is:" + price);
        } else {
            OutputManager.getInstance().print(
                    "抱歉，无法享受满200减20的优惠。",
                    "抱歉，無法享受滿200減20的優惠。",
                    "You can not take 20 off the 200 mark.");
        }
        return price;
    }
}
