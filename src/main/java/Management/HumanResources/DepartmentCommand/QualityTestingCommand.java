package Management.HumanResources.DepartmentCommand;

import Management.HumanResources.DepartmentType;
import Management.HumanResources.Staff.QualityExaminer;
import Presentation.Protocol.OutputManager;

/**
 * 质量检测部门调用的质量检测
 *  <b>命令模式的一部分</b>
 * @author 陈垲昕
 * @since 2021/10/17 8:17 下午
 */

public class QualityTestingCommand extends Command{
    /**
     * 命令接受者，质检部门下的一个质检员
     */
    private QualityExaminer receiver;

    /**
     * 空构造函数，此时该质检命令还不能执行，需调用setQualityTester设置receiver后才可执行
     * @author 陈垲昕
     * @since 2021-10-17 8:41 下午
     */
    public QualityTestingCommand(){
        super.accessedDepartment=DepartmentType.QualityAssurance;
    }

    /**
     * 含质检员的构造函数
     * @param receiver :质检部门下的一个质检员
     * @author 陈垲昕
     * @since 2021-10-17 8:42 下午
     */
    public QualityTestingCommand(QualityExaminer receiver){
        super.accessedDepartment=DepartmentType.QualityAssurance;
        this.receiver=receiver;
    }

    /**
     * 设置质检员的方法
     * @param receiver :质检部门下的一个质检员
     * @author 陈垲昕
     * @since 2021-10-17 8:43 下午
     */
    public void setQualityTester(QualityExaminer receiver){
        if(receiver==null){
            OutputManager.getInstance().errorMassage(
                    "质检员不能为空",
                    "質檢員不能為空",
                    "The receiver (QualityTester) cannot be empty."
            );
        }
        else{
            this.receiver=receiver;
        }
    }

    /**
     * 重写命令的执行方法
     * @author 陈垲昕
     * @since 2021-10-17 8:43 下午
     */
    @Override
    public void executeCommand() {
        if(receiver==null){
            OutputManager.getInstance().errorMassage(
                    "该质检命令尚未指定质检员，请指定一个",
                    "該質檢命令尚未指定質檢員，請指定一個",
                    "This quality assurance command has no receiver,please set a QualityTester as the receiver."
            );
        }
        else {
            receiver.doQualityTesting();
        }
    }
}
