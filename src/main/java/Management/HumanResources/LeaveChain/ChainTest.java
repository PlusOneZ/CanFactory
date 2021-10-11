package Management.HumanResources.LeaveChain;


import Management.HumanResources.Company.Company;
import Management.HumanResources.Company.Department;
import Management.HumanResources.Company.Manager;
import Management.HumanResources.Company.Staff;

public class ChainTest {
    public static void main(String[] args) {
        Company company=Company.getInstance();

        Department accountingDepartment=new Department("财务部");
        Department personnelDepartment= new Department("人事部");

        company.add(accountingDepartment);
        company.add(personnelDepartment);

        Manager managerAD = new Manager("财务部经理");
        Manager managerPD = new Manager("人事部经理");
        Manager managerChief = new Manager("总经理");
        Staff staff1=new Staff("马修");
        Staff staff2=new Staff("麦康纳");
        Staff staff3=new Staff("哈梅特");
        Staff purchaser=new Staff("采购员");

        accountingDepartment.add(managerAD);
        personnelDepartment.add(managerPD);
        company.add(managerChief);
        accountingDepartment.add(staff1);
        personnelDepartment.add(staff3);


        managerAD.setHandler(new DepartManagerHandler());
        managerPD.setHandler(new HRManagerHandler());
        managerChief.setHandler(new CompanyManagerHandler());

        managerAD.getHandler().setNextHandler(managerPD.getHandler());
        managerPD.getHandler().setNextHandler(managerChief.getHandler());

        staff1.setRequest(1);
        staff2.setRequest(2);
        staff3.setRequest(3);

        managerAD.getHandler().handleLeaveRequest(staff1.getRequest());
        managerAD.getHandler().handleLeaveRequest(staff2.getRequest());
        managerAD.getHandler().handleLeaveRequest(staff3.getRequest());

    }
}
