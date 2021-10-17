package Management.HumanResources.DataAccessObject;

import Management.HumanResources.BaseEmployee;

import java.util.List;

/**
 * Employee类的数据操作接口
 * TODO: 删除
 * <b>使用了 DAO 模式</b>
 *
 * @Author 尚丙奇
 * @date 2021-10-16 14:00
 */
public interface EmployeeDao {
    public List<BaseEmployee> getAllEmployees();
    public BaseEmployee getEmployee(String id);
    public void addEmployee(String name, Double salary);
    public void deleteEmployee(String Id);
    public void updateEmployee(String id, Double salary);
}

