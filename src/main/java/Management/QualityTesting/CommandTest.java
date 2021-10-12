package Management.QualityTesting;


import Management.HumanResources.Company.Company;
import Management.HumanResources.Company.Department;
import Management.HumanResources.Company.Manager;
import Management.HumanResources.Company.Staff;

public class CommandTest {
    public static void main(String[] args){
        Company company=Company.getInstance();

        Department accountingDepartment=new Department("财务部");
        Department testDepartment=new Department("质检部");


        company.add(accountingDepartment);
        company.add(testDepartment);


        Manager managerAD = new Manager("财务部经理");
        Manager managerTD = new Manager("质检部经理");

        Staff staff1=new Staff("马修1");
        Staff staff2=new Staff("麦康纳2");
        Staff staff3=new Staff("乔伊3");

        accountingDepartment.add(managerAD);
        testDepartment.add(managerTD);

        accountingDepartment.add(staff1);
        testDepartment.add(staff2);
        testDepartment.add(staff3);

        ////////////命令模式
        QualityTestingCommand qtCommand=new QualityTestingCommand(managerAD,staff1,staff2);
        QualityTestingCommand qtCommand2=new QualityTestingCommand(managerTD,staff2,staff3);
        managerAD.setManagerCommand(qtCommand);
        managerAD.giveCommand();

        managerTD.setManagerCommand(qtCommand2);
        managerTD.giveCommand();



    }
}
