package Manufacturing.ProductLine.Producer;

import Presentation.Protocol.OutputManager;

/**
 * 细加工生产方式类.
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:55
 */
public class FineProducer implements ProduceManner {
    @Override
    public void produce() {
        OutputManager.getInstance().print(
                "细加工:切块去核->冰糖小火熬制->加入添加剂->大火熬制->出锅密封保存",
                "細加工:切塊去核->冰糖小火熬製->加入添加劑->大火熬製->出鍋密封保存",
                "Fine processing: cut into pieces and remove core -> rock sugar boiled on low fire -> added additives -> boiled on high fire -> sealed and stored out of the pot"
        );
    }
}
