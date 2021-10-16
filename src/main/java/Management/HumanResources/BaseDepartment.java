package Management.HumanResources;

import Management.HumanResources.Manager.Manager;

import java.util.List;

/**
 * 部门的基类
 *
 * @author 尚丙奇
 * @date 2021-10-16 15:14
 */

public abstract class BaseDepartment {

    protected List<BaseEmployee> employees;

    protected Manager manager;

    protected DepartmentType type = DepartmentType.None;

    public void register(BaseEmployee employee){
        employees.add(employee);
        employee.setDepartment(type);
    }

    public void setManager(Manager manager){
        // TODO: 判断该部门是否已经有经理

        manager = manager;
    }

}
