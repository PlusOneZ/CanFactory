package
        Management.HumanResources;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO:员工（雇员）类.<br>
 *
 * <b>实现了组合模式</b>
 *
 * @author 孟繁霖
 * @date 2021/10/12 9:01
 */
public class Employee {

    private String name;
    private int salary;
    private String dept;
    private List<Employee> subordinates;

    public Employee(String name,  String dept,int salary) {
        this.name = name;
        this.salary = salary;
        this.dept = dept;
        this.subordinates = new ArrayList<>();
    }

    public void add(Employee e) {
        subordinates.add(e);
    }

    public void remove(Employee e) {
        subordinates.remove(e);
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", dept='" + dept + '\'' +
                '}';
    }
}
