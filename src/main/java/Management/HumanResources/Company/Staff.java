package Management.HumanResources.Company;

import Management.HumanResources.LeaveChain.LeaveRequest;

/**
 * Staff类:组合模式下的职员
 * @author 陈垲昕
 * @since 2021-10-11 8:10 下午
 */

//TODO: 1. 加入特殊员工（指一些部门特有的，比如生产车间的工人），并且加入特殊员工检测（工种是否能加入这个部门)

public class Staff extends ManagementUnit {

    /**
     * 职员所属的部门或公司，如果workingSector是公司，该职员为公司高层职员
     */
    private ManagementUnit workingSector;

    /**
     * 职员的请假等级
     */
    private LeaveRequest leaveRequest;

    /**
     * 职员的构造函数
     * @param name :  职员名字
     * @author 陈垲昕
     * @since 2021-10-11 8:12 下午
     */
    public Staff(String name){
        this.name=name;
        this.leaveRequest=new LeaveRequest(0);
    }

    /**
     * 获取职员的工作部门
     * @return : Management.HumanResources.Company.ManagementUnit 职员所属的部门或公司
     * @author 陈垲昕
     * @since 2021-10-11 8:12 下午
     */
    public ManagementUnit getWorkingSector(){ return this.workingSector;}

    /**
     * 重载：设置职员的工作部门
     * @param dep : 部门
     * @author 陈垲昕
     * @since 2021-10-11 8:54 下午
     */
    public void setWorkingSector(Department dep){
        this.workingSector=dep;
    }

    /**
     * 重载：设置职员的工作部门
     * @param com : 公司
     * @author 陈垲昕
     * @since 2021-10-11 8:54 下午
     */
    public void setWorkingSector(Company com){
        this.workingSector=com;
    }

    /**
     * 获取当前的请假请求等级
     * @return : Management.HumanResources.LeaveChain.LeaveRequest 等级
     * @author 陈垲昕
     * @since 2021-10-11 11:27 下午
     */
    public LeaveRequest getRequest(){return this.leaveRequest;}

    /**
     * 设置当前的请假请求等级
     * @param level :  等级
     * @author 陈垲昕
     * @since 2021-10-11 11:28 下午
     */
    public void setRequest(int level){
        this.leaveRequest.setLeaveRequestLevel(level);
    }

    /**
     * 重写showInfo方法，只打印职员信息
     * @author 陈垲昕
     * @since 2021-10-11 8:12 下午
     */
    @Override
    public void showInfo() {
       //TODO:OutputManager
        System.out.println("职员名为"+this.getName());
    }

    //TODO:添加职员可以使用的方法

    //TODO:命令模式下，职员作为命令的接受者执行命令的组分


    public void executeCommand1(){
        System.out.println("职员"+this.getName()+"执行质检操作");
    }

    public void executeCommand2(){
        System.out.println("职员"+this.getName()+"执行记录操作");
    }


}
