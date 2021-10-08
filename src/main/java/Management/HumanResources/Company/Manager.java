package Management.HumanResources.Company;

import Management.HumanResources.Command.Command;
import Presentation.Protocol.OutputManager;

/**
 * 组合模式下的经理
 * @author 陈垲昕
 *
 * TODO: 1. 加入特殊员工（指一些部门特有的，比如生产车间的工人）
 */


public class Manager extends BaseComponent{
    
    /* 
     * @description: 绑定的经理所属部门，
     */
    private Department workingDepartment;
    /* 
     * @description: 经理的命令
     */
    private Command command;


    public Manager(String name){
        this.name=name;
    }
    public Manager(String name,Department department){
        this.name=name;
        this.workingDepartment=department;
    }

    /**
     * <b>信息展示函数函数，打印了经理信息</b>
     */
    @Override
    public void showInfo() {
        OutputManager.getInstance().print(
                "经理名为:"+this.getName(),
                "經理名為"+this.getName(),
                "the name of the manager:"+this.getName()
        );
    }

    //TODO:添加其他经理可以使用的方法
    /**
     * 命令模式下设置经理的命令
     * @param command  经理要下达的命令
     */
    public void setManagerCommand(Command command){
        this.command=command;
    }

    public void giveCommand(){

        this.command.executeCommand();
    }


}
