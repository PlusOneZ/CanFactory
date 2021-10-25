package Manufacturing.ProductLine.Producer;

import Presentation.Protocol.OutputManager;

/**
 * TODO:粗加工生产类
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:49
 */
public class RoughProducer implements ProduceManner {
    @Override
    public void produce() {

        OutputManager.getInstance().print(
                "粗加工:切块去核->倒入调味剂->熬制->出锅密封",
                "粗加工:切塊去核->倒入調味劑->熬製->出鍋密封",
                "Rough processing: cut into pieces and remove the core -> pour in the flavoring -> boil -> seal out the pot");
    }
}
