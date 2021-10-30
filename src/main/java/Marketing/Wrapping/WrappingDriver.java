package
        Marketing.Wrapping;

import Manufacturing.CanEntity.Can;
import Manufacturing.CanEntity.CanInfoController;
import Manufacturing.CanEntity.FruitCan;
import Manufacturing.CanEntity.Material.IronMaterial;
import Manufacturing.CanEntity.Size.BigSize;
import Manufacturing.CanEntity.VegetableCan;
import Presentation.Protocol.OutputManager;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Scanner;

/**
 * 包装模块的驱动类;
 *
 * @author 王立友
 * @date 2021/10/24 17:53
 */
public class WrappingDriver {

    static List<String> canList = CanInfoController.getInstance().getCanList();

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        //初始化包装部门;
        WrappingDepartment wrappingDepartment = WrappingDepartment.getInstance();
        //设置语言
        OutputManager.getInstance().setLanguage(OutputManager.Lang.zh_CN);

        //进行初始化输出;
        printMenu();
        //对操作进行选择并且根据对应的操作生成相应的罐头实例,以标识测试;
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        Can can = null;
        //根据选择生成对应的罐头;
        String canName = canList.get(choice);
        Class<?> canType = CanInfoController.getInstance().getClassByName(canName);
        Constructor<?> constructor = canType.getConstructor();
        can = (Can) constructor.newInstance();

        //调用包装部门对生产部门进行打包;
        WrappedCan wrappedCan = wrappingDepartment.wrapCan(can);

        //对包装信息进行输出;
        wrappingDepartment.outputWrappedCan(wrappedCan);
    }

    public static void printMenu() {

        //获得所有罐头名称信息;
        OutputManager.getInstance().print("包装部门初始化以完成,请选择要包装的罐头类型: ",
                "包裝部門初始化以完成,請選擇要包裝的罐頭類型: ",
                "The packaging department is initialized to complete, please select the type of canned food to be packaged:");
        for (int i = 0; i < canList.size(); i++) {
            String name = canList.get(i);
            OutputManager.getInstance().print(i + "." + name + " ", i + "." + name + " ", i + "." + name + " ");
        }
    }
}