package Management.HumanResources;

import Management.HumanResources.DepartmentCommand.Command;
import Management.HumanResources.Manager.Manager;
import Presentation.Protocol.OutputManager;


import java.util.List;

/**
 * 部门的基类
 *
 * @author 尚丙奇
 * @date 2021-10-16 15:14
 */

public abstract class BaseDepartment {

    protected List<BaseEmployee> employees;

    protected Manager manager = null;

    protected DepartmentType type = DepartmentType.None;

    protected Command departmentCommand; //陈垲昕 添加部门命令

    /**
     * 将员工注册到相应的部门
     * @param employee
     */
    public void register(BaseEmployee employee){
        employees.add(employee);
        employee.setDepartment(type);

        if(manager == null && (employee instanceof Manager)){
            this.manager = (Manager)employee;
        }
    }

    /**
     * 设置该部门的经理
     * @param manager
     */
    public void setManager(Manager manager) {
        if (manager != null) {
            manager = manager;
        }
        else{
            OutputManager.getInstance().errorMassage(
                    "该部门已有经理，请勿重复设置",
                    "該部門已有經理，請勿重複設置",
                    "Manager already exists."
                    );
        }
    }

    /**
     * 设置BaseDepartment当前的Command，如果Command授权部门不匹配则报错退出
     * <b>命令模式的一部分</b>
     * @param currentCommand :  当前可设置的command
     * @author 陈垲昕
     * @since 2021-10-17 7:46 下午
     */
    public void setCurrentCommand(Command currentCommand){
        //获取该命令可调用的部门
        DepartmentType type=currentCommand.getAccessedDepartment();

        if(type!=DepartmentType.All && type!=this.type){
            OutputManager.getInstance().errorMassage(
                    "该部门无权调用该命令",
                    "該部門無權調用該命令",
                    "This department is not authorized to invoke this command."
            );
        }
        else{
            this.departmentCommand=currentCommand;
        }
    }

    /**
     * 部门下达命令，命令开始执行
     * @author 陈垲昕
     * @since 2021-10-17 8:45 下午
     */
    public void giveCommand(){
        if(this.departmentCommand!=null) {
            this.departmentCommand.executeCommand();
        }
        else{
            OutputManager.getInstance().errorMassage(
                    "该部门尚未指定要执行的命令",
                    "該部門尚未指定要執行的命令",
                    "This department hasn't set a concrete command to be executed."
            );
        }
    }
}
