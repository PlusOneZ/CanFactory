package Management.QualityTesting;

import Management.HumanResources.Command.Command;
import Management.HumanResources.Company.Manager;
import Management.HumanResources.Company.Staff;

/**
 * 命令模式的具体命令：质量检测命令：调用者：质检部门的经理 接受者 质检部门的两个职员，一个负责检查，一个负责记录
 * <b>作为 Command模式 的一部分</b>
 * @author 陈垲昕
 * @date 2021-10-11 8:13 下午
 */

public class QualityTestingCommand extends Command {

    /**
     * 命令调用者，为一个经理
     */
    private final Manager managerInvoke;

    /**
     * 命令执行者1，为一个职员,执行质量检查命令
     */
    private final Staff examinerReceive;

    /**
     * 命令执行者2，为一个职员，执行检查情况记录命令
     */
    private final Staff recorderReceive;


    /**
     * 此处写QualityTestingCommand的默认构造函数
     * @param manager : 经理，命令调用者
     * @param examiner : 职员，命名接受并执行者1，为质检员
     * @param recorder : 职员，命令接受并执行者2，为记录员
     * @author 陈垲昕
     * @since 2021-10-11 8:30 下午
     */
    public QualityTestingCommand(Manager manager,Staff examiner,Staff recorder){
        this.managerInvoke=manager;
        this.examinerReceive=examiner;
        this.recorderReceive=recorder;
    }


    @Override
    public void executeCommand() {
        if(!managerInvoke.getWorkingSector().getName().equals("质检部")){
            System.out.println("错误：该经理不是质检部门的经理，无权调用");
            return;
        }
        boolean examinerQualified=examinerReceive.getWorkingSector().getName().equals("质检部");
        boolean recorderQualified=recorderReceive.getWorkingSector().getName().equals("质检部");
        if(examinerQualified && recorderQualified){
            examinerReceive.executeCommand1();
            recorderReceive.executeCommand2();

        }else{
            System.out.println("错误：执行该命令的并非质检部的职员，无权执行");
        }


    }
}
