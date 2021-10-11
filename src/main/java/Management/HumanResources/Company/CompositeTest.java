package Management.HumanResources.Company;



public class CompositeTest {

    public static void main(String[] args) {
        Company company=Company.getInstance();

        Department accountingDepartment=new Department("财务部");
        Department salesDepartment=new Department("销售部");
        Department personnelDepartment= new Department("人事部");
        Department purchaseDepartment = new Department("采购部");

        company.add(accountingDepartment);
        company.add(salesDepartment);
        company.add(personnelDepartment);

        Manager managerAD = new Manager("财务部经理");
        Manager managerSD = new Manager("销售部经理");
        Manager managerPD = new Manager("人事部经理");
        Manager managerPurchase = new Manager("采购部经理");
        Staff staff1=new Staff("马修");
        Staff staff2=new Staff("麦康纳");
        Staff staff3=new Staff("哈梅特");
        Staff purchaser=new Staff("采购员");

        accountingDepartment.add(managerAD);
        salesDepartment.add(managerSD);
        personnelDepartment.add(managerPD);
        accountingDepartment.add(staff1);
        salesDepartment.add(staff2);
        personnelDepartment.add(staff3);

        purchaseDepartment.add(managerPurchase);
        purchaseDepartment.add(purchaser);



        company.showInfo();


    }
}
