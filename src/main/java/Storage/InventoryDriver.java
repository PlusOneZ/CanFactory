package
        Storage;

/**
 * 此类为库存管理相关的测试驱动类;
 * 意图为验证库存管理的有效性;
 *
 * @author 王立友
 * @date 2021/10/17 23:32
 */
public class InventoryDriver {
    public static void main(String[] args){

        System.out.println("1.测试生成库存管理部门");
        InventoryDepartment inventoryDepartment = InventoryDepartment.getInstance();
        System.out.println("已经生成库存管理部门");
        System.out.println("2.测试生成罐头仓库");
        CanWareHouse canWareHouse = CanWareHouse.getInstance();
        System.out.println("已经生成罐头仓库");


    }
}