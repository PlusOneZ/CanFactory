package Manufacturing.CanEntity;

import Manufacturing.CanEntity.ConcreteCan.PeachCan;
import Manufacturing.CanEntity.Material.IronMaterial;
import Manufacturing.CanEntity.Size.BigSize;
import Manufacturing.Ingredient.ConcreteIngredient.LotusRoot;
import Manufacturing.Ingredient.Ingredient;
import Manufacturing.Ingredient.Procedure.Cook;
import Manufacturing.ProductLine.Line.PeachLine;
import Presentation.Protocol.IOManager;

/**
 * 测试初始化罐头并打印
 * 桥接模式
 * @author 卓正一
 * @since  2021/10/12 4:42 PM
 */
public class CanTest {
    public static void main(String[] args) {
        IOManager.getInstance().print(
                "# 使用桥接模式",
                "# 使用橋接模式",
                "# Using Bridge Pattern"
        );
        Can can = new PeachCan(BigSize.getInstance(),IronMaterial.getInstance());
        IOManager.getInstance().print("已经使用桥接模式生成测试罐头",
                "已經使用橋接模式生成測試罐頭",
                "Test cans have been generated using bridge pattern");
    }
}
