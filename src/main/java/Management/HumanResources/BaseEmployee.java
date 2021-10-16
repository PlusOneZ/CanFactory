package Management.HumanResources;

import Management.HumanResources.DataAccessObject.EmployeeDao;

import java.util.List;

/**
 * 雇员的基类
 * <b>实现了 Chain of Responsibility 模式</b>
 * <b>实现了 Marker 模式</b>
 * @author 尚丙奇
 * @date 2021-10-16 14:00
 * */
public abstract class BaseEmployee {

    /**
     * 雇员的名字
     */
    protected String name;

    /**
     * 雇员的时薪
     * 默认为20.8人民币
     */
    protected Double salary = 20.8;

    /**
     * 雇员的直接领导
     * Staff为其Group的Leader
     * GroupLeader为其部门的Manager
     */
    protected BaseEmployee leader;

    protected DepartmentType department = DepartmentType.None;

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(DepartmentType department){
        department = department;
    }

    public String getName() {
        return name;
    }


    /**
     * 处理请假请求的函数
     * @param request
     * @author 尚丙奇
     * @date 2021-10-16 14:00
     */
    public abstract void handleRequest(LeaveRequest request);

}
