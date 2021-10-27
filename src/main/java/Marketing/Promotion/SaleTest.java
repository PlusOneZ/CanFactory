package Marketing.Promotion;

import Marketing.Promotion.Sale.TwentyPercentOff;
import Marketing.Promotion.Sale.TwoHundredMinusTwenty;
import Presentation.Protocol.OutputManager;

/**
 * 策略模式测试类
 *模拟打折营销的情景
 *
 * @author 吴英豪
 * @since 2021/10/27 07:57
 */
public class SaleTest {
    public static void main(String[] args) {
        Double price1 = 100.00;
        Double price2 = 200.00;

        OutputManager.getInstance().print(
                "需要购买两种商品，价格分别为:" + price1 + "," + price2 + '\n',
                "需要購買兩種商品，價格分別爲:" + price1 + "," + price2 + '\n',
                "Need to purchase two products, the price are " + price1 + " and " + price2 + '\n');

        OutputManager.getInstance().print(
                "使用八折优惠券购买两种商品......",
                "使用八折優惠券購買兩種商品......",
                "use TwentyPercentOff coupon to buy products......");
        Coupon coupon = new Coupon(new TwentyPercentOff());
        coupon.getPreferentialPrice(price1);
        coupon.getPreferentialPrice(price2);

        OutputManager.getInstance().print(
                "\n更换为满200减20优惠券重新进行购买......",
                "\n更換爲滿200減20優惠券重新進行購買......",
                "\nuse twoHundredMinusTwenty coupon to buy products once again......");
        coupon.changeStrategy(new TwoHundredMinusTwenty());

        coupon.getPreferentialPrice(price1);
        coupon.getPreferentialPrice(price2);

    }
}
