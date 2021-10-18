package Management.HumanResources.DepartmentCommand;

import Management.HumanResources.DepartmentType;

/**
 * Command基类
 * <b>命令模式的一部分</b>
 * @author 陈垲昕
 * @since 2021/10/17 7:38 下午
 */

public abstract class Command {
    /**
     * 这个命令可以被调用的部门
     */
    protected DepartmentType accessedDepartment=DepartmentType.None;

    public abstract void executeCommand();

    public DepartmentType getAccessedDepartment(){
        return this.accessedDepartment;
    }
}
