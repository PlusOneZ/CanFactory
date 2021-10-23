package Management.HumanResources.FinancialSystem.DataAccessObject;

import Management.HumanResources.BaseDepartment;

import java.io.IOException;

/**
 * 人员薪资的数据操作接口
 * <b> 使用了DAO模式 </b>
 *
 * @author 尚丙奇
 * @since 2021-10-16 14:00
 */
public abstract interface SalaryDao {
        public Double getSumActualSalary(BaseDepartment department);
        public void setSalary(BaseDepartment department, String name, Double salary);
        public void saveSalary(BaseDepartment department) throws IOException;
}
