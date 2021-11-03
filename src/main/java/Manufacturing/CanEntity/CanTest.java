package Manufacturing.CanEntity;

import Manufacturing.CanEntity.Material.IronMaterial;
import Manufacturing.CanEntity.Size.BigSize;
import Manufacturing.Ingredient.ConcreteIngredient.LotusRoot;
import Manufacturing.Ingredient.Ingredient;
import Manufacturing.Ingredient.Procedure.Cook;
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
        Can vegetableCan = new VegetableCan(BigSize.getInstance(), IronMaterial.getInstance());
        vegetableCan.setName(
                "藕片罐头",
                "藕片罐頭",
                "Lotus Root Can"
        );

        Ingredient lotusRoot = new LotusRoot();
        vegetableCan.getDisinfection();
        vegetableCan.addIngredient(new Cook(lotusRoot));

        System.out.println(vegetableCan.getCanCost());

        System.out.println(vegetableCan.getCanName());

        System.out.println(vegetableCan);
    }
}
