package Management.HumanResources;

import Management.HumanResources.DataAccessObject.EmployeeDao;

import java.util.List;

/**
 * 雇员的基类
 * <b>实现了 Chain of Responsibility 模式</b>
 * <b>实现了 Marker 模式</b>
 * @author 尚丙奇
 * */
public abstract class BaseEmployee {

    protected String name;

    protected String id;

    protected Double salary;

    protected BaseEmployee leader;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public abstract void handleRequest(LeaveRequest request);

}
