package Manufacturing.ProductLine.Line;

import Manufacturing.ProductLine.FreshLine;
import Manufacturing.ProductLine.RawMaterial.RawMaterial;
import Presentation.Protocol.OutputManager;

import java.util.List;

/**
 * TODO:三文鱼罐头生产线类.
 *
 * @author 孟繁霖
 * @date 2021-10-12 8:30
 */
public class SalmonLine implements FreshLine {

    @Override
    public List<RawMaterial> preTreat(List<RawMaterial> rawMaterialList) {

        OutputManager.getInstance().errorMassage(
                "*********正在对三文鱼进行预处理*********",
                "*********正在對三文魚進行預處理*********",
                "*********Salmon is being pretreated*********");
        rawMaterialList = pretreatmentApp.filterTreat(rawMaterialList);
        pretreatmentApp.disinfect(rawMaterialList);
        pretreatmentApp.clean(rawMaterialList);
        OutputManager.getInstance().errorMassage(
                "*************三文鱼预处理完成***********",
                "*************三文魚預處理完成***********",
                "*************Salmon pretreatment completed***********");
        return rawMaterialList;
    }

    @Override
    public void produce(int count) {
        OutputManager.getInstance().errorMassage(
                "**********正在对三文鱼进行加工**********",
                "**********正在對三文魚進行加工**********",
                "**********Salmon is being processed**********");
        OutputManager.getInstance().errorMassage(
                "共生产" + count + "个三文鱼罐头",
                "共生產" + count + "個三文魚罐頭",
                "Totally produced" + count + "salmon can!");
    }
}
