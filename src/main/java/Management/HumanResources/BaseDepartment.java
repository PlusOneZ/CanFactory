package Management.HumanResources;

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
}
