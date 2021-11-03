package
        Marketing.Wrapping;

import CanFactory.CanFactory;
import Manufacturing.CanEntity.Can;
import Manufacturing.CanEntity.CanInfoController;
import Manufacturing.ProductLine.Line.AutomatedLine.CandiedAppleLine;
import Manufacturing.ProductLine.Line.HerringLine;
import Manufacturing.ProductLine.Line.PeachLine;
import Manufacturing.ProductLine.Line.SalmonLine;
import Presentation.Protocol.IOManager;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * 包装模块的驱动类;
 * 测试转换器模式与建造者模式的测试类;
 *
 * @author 王立友
 * @date 2021/10/24 17:53
 */
public class WrappingDriver {

    static List<String> canList = CanInfoController.getInstance().getCanList();

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        //初始化包装部门;
        WrappingDepartment wrappingDepartment = WrappingDepartment.getInstance();


        //进行初始化输出;
        printMenu();
        //对操作进行选择并且根据对应的操作生成相应的罐头实例,以标识测试;
        int choice;
        while ((choice = CanFactory.getInstance().inputInteger()) ==-1 ||
        choice <1 ||choice >4) {
            IOManager.getInstance().errorMassage(
                    "输入序号非法,请重新输入!",
                    "輸入序號非法,請重新輸入!",
                    "The serial number entered is illegal, please re-enter!");
        }

        Can can = null;
        //根据选择生成对应的罐头;生成stub.
        switch (choice){
            case 1:
                can = CandiedAppleLine.produceSample();
                break;
            case 2:
                can = PeachLine.produceSample();
                break;
            case 3:
                can = HerringLine.produceSample();
                break;
            case 4:
                can = SalmonLine.produceSample();
                break;
            default:
                IOManager.getInstance().errorMassage("没有相应选项的罐头种类!","沒有相應選項的罐頭種類!","There are no corresponding canned food types!");
        }
        //调用包装部门对生产部门进行打包;
        WrappedCan wrappedCan = wrappingDepartment.wrapCan(can);
        //对包装信息进行输出;
        wrappingDepartment.outputWrappedCan(wrappedCan);
    }

    public static void printMenu() {

        IOManager.getInstance().print("*************************************", "*************************************", "*************************************");
        //获得所有罐头名称信息;
        IOManager.getInstance().print("包装部门初始化以完成,请选择要包装的罐头类型: ",
                "包裝部門初始化以完成,請選擇要包裝的罐頭類型: ",
                "The packaging department is initialized to complete, please select the type of canned food to be packaged:");
        for (int i = 0; i < canList.size(); i++) {
            String name = canList.get(i);
            IOManager.getInstance().print(i + 1 + "." + name + " ", i + 1 + "." + name + " ", i + 1 + "." + name + " ");
        }
        IOManager.getInstance().print("*************************************", "*************************************", "*************************************");
    }
}