package Management.HumanResources.Company;

import Management.HumanResources.Command.Command;
import Management.HumanResources.LeaveChain.LeaveHandler;

/**
 * Manager类：组合模式下的经理
 * <b>组合模式的一部分</b>
 * @author 陈垲昕
 * @since 2021-10-11 8:05 下午
 */
public class Manager extends ManagementUnit {

    /**
     * 经理工作的部门，可以是Department或Company，如果是Company，该经理为公司总经理
     */
    private ManagementUnit workingSector;

    /**
     * 经理的命令
     */
    private Command command;


    /**
     * 经理处理请假请求的处理器
     */
    private LeaveHandler managerHandler;

    /**
     * 创建经理的构造函数
     * @param name : 经理名字
     * @author 陈垲昕
     * @since 2021-10-11 8:07 下午
     */
    public Manager(String name){
        this.name=name;
    }

    /**
     * 获取经理的处理请假请求处理器
     * <b> 责任链模式的一部分</b>
     * @return : Management.HumanResources.LeaveChain.LeaveHandler
     * @author 陈垲昕
     * @since 2021-10-11 11:33 下午
     */
    public LeaveHandler getHandler(){return this.managerHandler;}

    /**
     * 经理设置处理请假请求的处理器
     * @param handler :  处理器
     * @author 陈垲昕
     * @since 2021-10-11 11:13 下午
     */
    public void setHandler(LeaveHandler handler){this.managerHandler=handler;}

    /**
     * 获取该经理所工作的部门或公司
     * @return : Management.HumanResources.Company.ManagementUnit
     * @author 陈垲昕
     * @since 2021-10-11 8:08 下午
     */
    public ManagementUnit getWorkingSector() {
        return workingSector;
    }
    /**
     * 重载：设置经理的工作部门
     * @param dep : 部门
     * @author 陈垲昕
     * @since 2021-10-11 8:54 下午
     */
    public void setWorkingSector(Department dep){
        this.workingSector=dep;
    }

    /**
     * 重载：设置经理的工作部门
     * @param com : 公司
     * @author 陈垲昕
     * @since 2021-10-11 8:54 下午
     */
    public void setWorkingSector(Company com){
        this.workingSector=com;
    }




    /**
     * 重写showInfo方法，只打印经理信息
     * @author 陈垲昕
     * @since 2021-10-11 8:08 下午
     */
    @Override
    public void showInfo() {
        //TODO:添加OutputManager
        System.out.println("经理名为"+this.getName());
    }

    //TODO:添加其他经理可以使用的方法



    /**
     * 经理作为命令调用者Invoker设置命令的方法
     * <b>命令模式的一部分</b>
     * @param command :
     * @author 陈垲昕
     * @since 2021-10-11 8:09 下午
     */
    public void setManagerCommand(Command command){
        this.command=command;
    }

    /**
     * 经理作为命令调用者Invoker下达命令的方法
     * @author 陈垲昕
     * @since 2021-10-11 8:09 下午
     */
    public void giveCommand(){

        this.command.executeCommand();
    }

}

