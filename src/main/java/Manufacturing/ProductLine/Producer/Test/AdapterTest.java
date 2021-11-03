package Manufacturing.ProductLine.Producer.Test;

import Manufacturing.ProductLine.Producer.AppleProducer;
import Presentation.Protocol.IOManager;

/**
 * 适配器模式测试类
 *
 * @author 孟繁霖
 * @date 2021/10/27 18:20
 */
public class AdapterTest {
    public static void main(String[] args) {
        IOManager.getInstance().print(
                "# 利用适配器模式：适配不同生产方式:",
                "# 利用適配器模式：適配不同生產方式：",
                "# Using adapter pattern: adapt to different production manners:");
        AppleProducer appleProducer = new AppleProducer("fine");//适配细加工生产方式
        appleProducer.produce();
        AppleProducer appleProducer1=new AppleProducer("rough");//适配粗加工生产方式
        appleProducer1.produce();
    }
}
