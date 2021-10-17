package Manufacturing.ProductLine.Line;

import Manufacturing.ProductLine.FreshLine;
import Manufacturing.ProductLine.RawMaterial.RawMaterial;
import Presentation.Protocol.OutputManager;

import java.util.List;

/**
 * TODO:丁香鱼罐头生产线类
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:32
 */
public class CloveLine implements FreshLine {
    @Override
    public List<RawMaterial> preTreat(List<RawMaterial> rawMaterialList) {

        OutputManager.getInstance().errorMassage(
                "******正在对丁香鱼进行预处理********",
                "******正在對丁香魚進行預處理********",
                "******Pretreating clove fish********");
        rawMaterialList = pretreatmentApp.filterTreat(rawMaterialList);
        pretreatmentApp.disinfect(rawMaterialList);
        pretreatmentApp.clean(rawMaterialList);
        OutputManager.getInstance().errorMassage(
                "*********丁香鱼预处理完成*********",
                "*********丁香魚預處理完成*********",
                "*********Clove fish pretreatment completed*********");
        return rawMaterialList;
    }

    @Override
    public void produce(int count) {
        OutputManager.getInstance().errorMassage(
                "*******正在对丁香鱼进行加工*******",
                "*******正在對丁香魚進行加工*******",
                "*******Clove fish is being processed*******");
        OutputManager.getInstance().errorMassage(
                "共生产" + count + "个丁香鱼罐头",
                "共生產" + count + "個丁香魚罐頭",
                "Totally produced" + count + "clove can!");
    }
}
