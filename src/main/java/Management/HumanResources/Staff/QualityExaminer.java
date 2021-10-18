package Management.HumanResources.Staff;

import Management.HumanResources.DepartmentType;
import Presentation.Protocol.OutputManager;

/**
 * TODO:此处写QualityExaminer类的描述
 *
 * @author 陈垲昕
 * @since 2021/10/17 8:26 下午
 */

public class QualityExaminer extends Staff{

    /**
     * 含名字的构造函数
     * @param name :  质检员名字
     * @author 陈垲昕
     * @since 2021-10-17 9:03 下午
     */
    public QualityExaminer(String name){
        super.department= DepartmentType.QualityAssurance;
        this.name=name;
    }

    /**
     * 含名字和薪水的构造函数
     * @param name : 质检员名字
     * @param salary :薪水
     * @author 陈垲昕
     * @since 2021-10-17 9:03 下午
     */
    public QualityExaminer(String name, Double salary){
        super.department= DepartmentType.QualityAssurance;
        this.name=name;
        this.salary=salary;
    }

    /**
     * 执行质检命令
     * <b>命令模式中在QualityTestingCommand调用</b>
     * @author 陈垲昕
     * @since 2021-10-17 9:04 下午
     */
    public void doQualityTesting(){
        OutputManager.getInstance().print(
                "质检员"+this.getName()+"执行质量检查命令",
                "質檢員"+this.getName()+"執行質量檢查命令",
                "Quality examiner"+this.getName()+"executes quality testing command."
        );
    }

}
