package Management.HumanResources.Company;

import Presentation.Protocol.OutputManager;

/**
 * 组合模式下的职员
 * @author 陈垲昕
 *
 * TODO: 1. 加入特殊员工（指一些部门特有的，比如生产车间的工人），并且加入特殊员工检测（工种是否能加入这个部门)
 */

public class Staff extends BaseComponent{

    /*
     * @description: 绑定的经理所属部门，
     */
    private Department workingDepartment;

    public Staff(String name){
        this.name=name;
    }
    public Staff(String name,Department department){
        this.name=name;
        this.workingDepartment=department;
    }

    @Override
    public void showInfo() {
        OutputManager.getInstance().print(
                "职员名为:"+this.getName(),
                "職員名為"+this.getName(),
                "the name of the staff:"+this.getName()
        );
    }

    //TODO:添加职员可以使用的方法

    //TODO:命令模式下，职员作为命令的接受者执行命令的组分
}
