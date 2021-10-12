package Manufacturing.ProductLine.Line;

import Manufacturing.ProductLine.Fruit.RawMaterial;
import Manufacturing.ProductLine.FruitLine;
import Manufacturing.ProductLine.adapter.AppleProducer;
import Presentation.Protocol.OutputManager;

import java.util.List;

/**
 * TODO:苹果罐头生产线类
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:33
 */
public class AppleLine implements FruitLine {

    @Override
    public List<RawMaterial> preTreat(List<RawMaterial> rawMaterialList) {

        OutputManager.getInstance().errorMassage(
                "**********正在对苹果进行预处理*********",
                "**********正在對蘋果進行預處理*********",
                "**********Apple is being preprocessed*********");
        rawMaterialList = pretreatmentApp.filterTreat(rawMaterialList);
        pretreatmentApp.peel(rawMaterialList);
        pretreatmentApp.disinfect(rawMaterialList);
        OutputManager.getInstance().errorMassage(
                "*************苹果预处理完成***********",
                "*************蘋果預處理完成***********",
                "********Apple preprocessing is completed*****");
        return rawMaterialList;
    }

    @Override
    public void produce(int count, String produceManner) {
        OutputManager.getInstance().errorMassage(
                "**********正在对苹果进行加工**********",
                "**********正在對蘋果進行加工**********",
                "**********Apples are being processed**********");
        AppleProducer appleProducer = new AppleProducer(produceManner);
        appleProducer.produce();
        OutputManager.getInstance().errorMassage(
                "共生产" + count + "个苹果罐头",
                "共生產" + count + "個蘋果罐頭",
                "Totally produced" + count + "apple can!");
    }
}
