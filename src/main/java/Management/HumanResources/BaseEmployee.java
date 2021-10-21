package Management.HumanResources;

import Management.HumanResources.DataAccessObject.EmployeeDao;
import Presentation.Protocol.OutputManager;

import java.util.List;

/**
 * 雇员的基类
 * <b>实现了 Chain of Responsibility 模式</b>
 * <b>实现了 Marker 模式</b>
 * @author 尚丙奇
 * @since 2021-10-16 14:00
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

    public String getName() {
        return name;
    }

    public void setDepartment(DepartmentType department){
        this.department = department;
    }

    public DepartmentType getDepartment(){
        return department;
    }

    public void setLeader(BaseEmployee leader){
        this.leader = leader;
    }

    public BaseEmployee getLeader(){
        return leader;
    }

    /**
     * 处理请假请求的函数
     * @param request
     * @author 尚丙奇
     * @since 2021-10-16 14:00
     */
    public abstract void handleRequest(LeaveRequest request);

    /**
     * 员工接受消息的函数
     * @param message
     */
    public void getMessage(String message){
        System.out.println("员工["+this.name+"]接受消息："+message);
        OutputManager.getInstance().print(
                "员工["+this.name+"]接受消息："+message,
                "員工"+"]接受消息："+message,
                "Staff["+this.name+"] receives the message:"+message
        );
    }

}
