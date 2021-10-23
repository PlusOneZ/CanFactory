package Management.HumanResources.FinancialSystem.DataAccessObject;

import Management.HumanResources.BaseDepartment;
import Management.HumanResources.BaseEmployee;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;


/**
 * SalaryDao接口的实现
 *<b>使用了 DAO 模式</b>
 *
 * @author 尚丙奇
 * @since 2021-10-22 15:20
 */

public class SalaryDaoImpl implements SalaryDao{

    String filePath = "./Data/Salary.csv";

    /**
     * 获得该部门总的实发工资
     * @param department 一个部门
     * @return 总的实发工资
     */
    @Override
    public Double getSumActualSalary(BaseDepartment department){
        Double sum = 0.0;
        try{
            CsvReader csvReader = new CsvReader(filePath);
            csvReader.readHeaders();
            while(csvReader.readRecord()){
                if(csvReader.get("部门") == department.toString()){
                    sum += Double.valueOf(csvReader.get("实发工资"));
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return sum;
    }

    /**
     * 将department部门名为name员工的时薪设置为salary
     * @param department
     * @param name
     * @param salary
     */
    @Override
    public void setSalary(BaseDepartment department, String name, Double salary){
        BaseEmployee employee = department.getEmployee(name);

        employee.setSalary(salary);
    }

    /**
     * 将department部门的薪资情况写入Salary.csv文件中
     * @param department
     *
     */
    @Override
    public void saveSalary(BaseDepartment department) throws IOException {
        File file = new File(filePath);
        CsvWriter csvWriter = new CsvWriter(filePath, ',', Charset.forName("UTF-8"));
        if (!file.exists()){
            String[] headers = {"姓名", "部门", "时薪", "工作时长", "税金", "实发工资"};
            file.createNewFile();
            csvWriter.writeRecord(headers);
        }

        List<BaseEmployee> employees = department.getAllEmployees();

        for(BaseEmployee employee:employees){
            String[] content = new String[6];
            content[0] = employee.getName();
            content[1] = department.toString();
            content[2] = employee.getSalary().toString();
            content[3] = Integer.toString(40);
            Double tax = 0.2 * employee.getSalary() * 40;
            content[4] = tax.toString();
            content[5] = Double.toString(0.8 * employee.getSalary() * 40);

            csvWriter.writeRecord(content);
        }
        csvWriter.close();

    }
}
