package
        Marketing.Wrapping;

import Manufacturing.CanEntity.Can;
import Manufacturing.CanEntity.FruitCan;
import Manufacturing.CanEntity.Material.IronMaterial;
import Manufacturing.CanEntity.Size.BigSize;
import Manufacturing.CanEntity.VegetableCan;
import Presentation.Protocol.OutputManager;

import java.util.Scanner;

/**
 * 包装模块的驱动类;
 *
 * @author 王立友
 * @date 2021/10/24 17:53
 */
public class WrappingDriver {

    public static void main(String[] args){

        //初始化包装部门;
        WrappingDepartment wrappingDepartment = WrappingDepartment.getInstance();
        //设置语言
        OutputManager.getInstance().setLanguage(OutputManager.Lang.zh_CN);

        //进行初始化输出;
        printMenu();
        //对操作进行选择并且根据对应的操作生成相应的罐头实例,以标识测试;
        Scanner input=new Scanner(System.in);
        int choice = input.nextInt();

        Can can = null;
        //根据选择生成对应的罐头;
        switch (choice){
            case 1:
                can = new VegetableCan(BigSize.getInstance(), IronMaterial.getInstance());
                can.setName("蔬菜罐头","蔬菜罐頭","vegetable cans");
                break;
            case 2:
                can = new FruitCan(BigSize.getInstance(), IronMaterial.getInstance());
                can.setName("水果罐头", "水果罐頭", "fruit cans");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }

        //调用包装部门对生产部门进行打包;
        WrappedCan wrappedCan = wrappingDepartment.wrapCan(can);

        //对包装信息进行输出;
        wrappingDepartment.outputWrappedCan(wrappedCan);
    }

    public static void printMenu(){
            OutputManager.getInstance().print("包装部门初始化以完成,请选择要包装的罐头类型: 1.蔬菜罐头 2.水果罐头.",
                    "包裝部門初始化以完成,請選擇要包裝的罐頭類型: 1.蔬菜罐頭 2.水果罐頭.",
                    "The packaging department is initialized to complete, please select the type of canned food to be packaged:" +
                            " 1. Vegetables cans 2. Fruits cans.");
    }
}