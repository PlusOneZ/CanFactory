package Manufacturing.ProductLine.Line;

import Manufacturing.ProductLine.RawMaterial.RawMaterial;
import Manufacturing.ProductLine.FruitLine;
import Manufacturing.ProductLine.Producer.PeachProducer;
import Presentation.Protocol.OutputManager;

import java.util.List;

/**
 * TODO:黄桃罐头生产线类
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:32
 */
public class PeachLine implements FruitLine {
    @Override
    public List<RawMaterial> preTreat(List<RawMaterial> rawMaterialList) {

        OutputManager.getInstance().errorMassage(
                "******正在对桃子进行预处理********",
                "******正在對桃子進行預處理********",
                "***Treating peaches*****");
        rawMaterialList = pretreatmentApp.filterTreat(rawMaterialList);
        pretreatmentApp.peel(rawMaterialList);
        pretreatmentApp.disinfect(rawMaterialList);
        OutputManager.getInstance().errorMassage(
                "********桃子预处理完成*********",
                "********桃子預處理完成*********",
                "***Peach pretreatment completed***");
        return rawMaterialList;
    }

    @Override
    public void produce(int count, String produceManner) {
        System.out.println("*******正在对黄桃进行加工*******");
        OutputManager.getInstance().errorMassage(
                "*******正在对黄桃进行加工*******",
                "*******正在對黃桃進行加工*******",
                "*******Peaches are being processed*******");
        PeachProducer peachProducer = new PeachProducer(produceManner);
        peachProducer.produce();
        OutputManager.getInstance().errorMassage(
                "共生产" + count + "个黄桃罐头",
                "共生產" + count + "個黃桃罐頭",
                "Totally produced" + count + "peach can!");
    }
}
