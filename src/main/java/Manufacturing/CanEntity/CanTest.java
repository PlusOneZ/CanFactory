package Manufacturing.CanEntity;

import Manufacturing.CanEntity.Material.IronMaterial;
import Manufacturing.CanEntity.Size.BigSize;

/**
 * 测试初始化罐头并打印
 *
 * @author 卓正一
 * @since  2021/10/12 4:42 PM
 */
public class CanTest {
    public static void main(String[] args) {
        Can vegetableCan = new VegetableCan(BigSize.getInstance(), IronMaterial.getInstance());
        System.out.println(vegetableCan.getCanName());
    }
}
