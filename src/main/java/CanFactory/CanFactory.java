package CanFactory;

import ImplementDepartment.OrderImplementDepartment;
import Management.HumanResources.BaseEmployee;
import Management.HumanResources.DepartmentCommand.AuditSalaryTableCommand;
import Management.HumanResources.FinancialSystem.DataAccessObject.SalaryDaoImpl;
import Management.HumanResources.FinancialSystem.FinancialDepartment;
import Management.HumanResources.FinancialSystem.Permission;
import Management.HumanResources.LeaveRequest;
import Management.HumanResources.Manager.TestingManager;
import Management.HumanResources.Staff.Announcer;
import Management.HumanResources.Staff.Auditor;
import Management.HumanResources.Staff.Worker;
import Management.HumanResources.TeamLeader.TestingTeamLeader;
import Management.HumanResources.test.CompanyManagementTest;
import Management.QualityTesting.QualityAssuranceDepartment;
import Marketing.OrderEnity.Order;
import Mediator.DepartmentMediator;
import Presentation.Protocol.OutputManager;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 所有类的驱动类
 *
 * @author 卓正一
 * @since  2021/10/29 5:16 PM
 */
public class CanFactory {

    private static CanFactory canFactory;

    static {
        canFactory = new CanFactory();
    }

    public static CanFactory getInstance() {
        return canFactory;
    }

    /**
     * 单例构造器
     * @author 卓正一
     * @since 2021-10-29 5:17 PM
     */
    private CanFactory() {

    }

    public int intputInteger(){
        String inputStr = OutputManager.getInstance().input();
        if(inputStr==""){
            return -1;
        }
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(inputStr);
        if(!isNum.matches()){
            return -1;
        }
        else{
            return Integer.parseInt(inputStr);
        }
    }

    public void run()  {

        OutputManager.getInstance().printLanguageIrrelevantContent("请选择使用语言 /請選擇使用語言 /Please select the language");

        OutputManager.getInstance().printLanguageIrrelevantContent("[1 - 中文（简体）]\t[2 - 中文（繁體）]\t[3 - English]" );

        int selectedLanguage=-1;
        while((selectedLanguage = this.intputInteger())==-1 || selectedLanguage<1 ||selectedLanguage>3){
            OutputManager.getInstance().printLanguageIrrelevantContent(
                    "无效输入，请重新输入 /無效輸入，请重新輸入/ Invalid input, please input again"
                    );
        }

        switch (selectedLanguage){
            case 1:
                OutputManager.getInstance().setLanguage(OutputManager.Lang.zh_CN);
                break;
            case 2:
                OutputManager.getInstance().setLanguage(OutputManager.Lang.zh_TW);
                break;
            case 3:
                OutputManager.getInstance().setLanguage(OutputManager.Lang.en);
                break;
        }

        try{
            loadingInput();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        OutputManager.getInstance().print(
                "请选择要运行的系统：",
                "請選擇要運行的系統：",
                "Please select the system to run:"
        );

        OutputManager.getInstance().print(
                "[1 - 订单系统]\t[2 - 管理系统]\t[3 - 30个设计模式测试]",
                "[1 -訂單系統]\t[2 -管理系統]\t[3 - 30個設計模式測試]",
                "[1 - Order System]\t[2 - Management System]\t[3 - 30 Design Patterns Test]"
        );

        int selectedSystem=-1;
        while((selectedSystem = this.intputInteger())==-1 || selectedSystem<1 ||selectedSystem>3){
            OutputManager.getInstance().errorMassage(
                    "无效输入，请重新输入",
                    "無效輸入，请重新輸入",
                    "Invalid input, please input again"
            );
        }

        switch (selectedSystem){
            case 1:
                this.orderManage();
                break;
            case 2:
                try{
                    this.companyManage();
                }
                catch (IOException err){

                }
                break;
            case 3:
                OutputManager.getInstance().setLanguage(OutputManager.Lang.en);
                break;
        }


    }

    /**
     * 起始输入
     * @author 陈垲昕
     * @since 2021-10-30 8:40 下午
     */
    public static void loadingInput() throws InterruptedException {
        for (int i = 0; i <= 100; i++) {
            OutputManager.getInstance().printLoading(
                    "罐头工厂加载中：" + i + "%",
                    "罐頭工廠加載中：" + i + "%",
                    "Loading Can Factory：" + i + "%"
            );
            Thread.sleep(20);
            OutputManager.getInstance().printLoading("\r","\r","\r");
        }
    }


    public void orderManage(){
        //首先提示客户创建订单
        ArrayList<Order> pendingOrders = null;
        try {
            pendingOrders = OrderImplementDepartment.getInstance().CreateOrder();
        } catch (ParseException e) {
            e.printStackTrace();
            OutputManager.getInstance().errorMassage(
                    "出现异常！",
                    "出現異常",
                    "Abnormal!"
            );
        }
        //然后通知库存部门作后续处理
        for(Order order : pendingOrders){
            //对于每一个订单，进行相应的处理
            DepartmentMediator.getInstance().handleOrder(order);
        }
    }

    public void companyManage() throws IOException {


        // 获取QualityAssurance部门的实例
        QualityAssuranceDepartment qualityTestingDepartment = QualityAssuranceDepartment.getInstance();
        // 获取FinancialDepartment部门的实例
        FinancialDepartment financialDepartment = FinancialDepartment.getInstance();
        // 创建该部门的经理
        TestingManager testingManager = new TestingManager();
        // 创建该部门的一个组长
        TestingTeamLeader testingTeamLeader1 = new TestingTeamLeader();

        // 该部门的第二个组长
        TestingTeamLeader testingTeamLeader2 = new TestingTeamLeader();
        // 创建该部门的一个员工
        Worker testingWorker = new Worker();

        // 该部门的第二个员工
        Worker testingWorker1 = new Worker();

        // 该部门的第三个员工
        Worker testingWorker2 = new Worker();

        //创建经济部门的审计员等
        Auditor auditor1=new Auditor("法克", 201.0);
        Auditor auditor2=new Auditor("尤尔",100.0);
        Auditor auditor3=new Auditor("马泽尔",100.0);
        financialDepartment.register(auditor1,false);
        financialDepartment.register(auditor2,false);
        financialDepartment.register(auditor3,false);


        SalaryDaoImpl salaryDaoImpl = SalaryDaoImpl.getInstance();

        salaryDaoImpl.saveSalary(financialDepartment);

//        salaryDaoImpl.closeFile();

        testingManager.setName("Bear");

        testingTeamLeader1.setName("梁乔");
        testingTeamLeader1.setLeader(testingManager);

        testingTeamLeader2.setName("Trios");
        testingTeamLeader2.setLeader(testingManager);

        testingWorker1.setName("Hamilton");
        testingWorker1.setLeader(testingTeamLeader1);

        testingWorker.setName("桥梁");
        testingWorker.setLeader(testingTeamLeader1);

        testingWorker2.setName("Zimmerman");
        testingWorker2.setLeader(testingTeamLeader2);

        // 分别将其注册到该部门
        qualityTestingDepartment.register(testingManager,false);
        qualityTestingDepartment.register(testingTeamLeader1,false);
        qualityTestingDepartment.register(testingWorker,false);
        qualityTestingDepartment.register(testingTeamLeader2, false);
        qualityTestingDepartment.register(testingWorker1, false);
        qualityTestingDepartment.register(testingWorker2, false);

        OutputManager.getInstance().print(
                "公司管理系统已经激活且加载基础数据",
                "公司管理系統已經激活且加載基礎數據",
                "Company management system has been activated."
        );

//        Scanner scanner = new Scanner(System.in);
//        Scanner scanner2 = new Scanner(System.in);
        while(true) {
            OutputManager.getInstance().print(
                    "请输入序号进行所需要的操作：\n" +
                            "[1 - 注册员工]\t[2 - 审计报告]\t[3 - 查看审计记录]\t[4 - 请假处理]\t[5 - 检查员工权限]\t[6 - 进入公告系统]\t" +
                            "[7 - 退出系统]\n" +
                            "您的输入：",
                    "請輸入序號進行所需要的操作：\n" +
                            "[1 - 註冊員工]\t[2 - 審計報告]\t[3 - 查看備忘錄]\t[4 - 請假處理]\t[5 - 檢查員工權限]\t[6 - 進入公告系統]\t" +
                            "[7 - 退出系統]\n" +
                            "您的輸入：",
                    "Please input the following number for corresponding mission:\n" +
                            "[1 - employee registration]\t[2 - salary report audit]\t[3 - view history memento]\t[4 - leave request procedure]\t[5 - check employee authority]\t[6 - exit system]\n" +
                            "Your input: "
            );

            int num;
            while((num=CompanyManagementTest.intputInteger())==-1) {
                OutputManager.getInstance().errorMassage(
                        "无效输入，请重新输入：",
                        "無效輸入，请重新輸入：",
                        "Invalid input, please input again:"
                );
            }

            //进入员工注册
            if(num==1) {
                OutputManager.getInstance().print(
                        "请输入需要注册的员工数量:",
                        "請輸入需要註冊的員工數量:",
                        "Please enter the number of employees to register:"
                );

                Integer numOfEmployees;
                while((numOfEmployees=CompanyManagementTest.intputInteger())==-1) {
                    OutputManager.getInstance().errorMassage(
                            "无效输入，请重新输入：",
                            "無效輸入，请重新輸入：",
                            "Invalid input, please input again:"
                    );
                }

                if(numOfEmployees < 1){
                    OutputManager.getInstance().errorMassage(
                            "无效输入，请重新输入：",
                            "無效輸入，请重新輸入：",
                            "Invalid input, please input again:"
                    );
                    continue;
                }
                for(int i = 0; i < numOfEmployees; i++){

                    Worker newWorker = new Worker();


                    OutputManager.getInstance().print(
                            "请依次输入要注册的员工" + (i+1) +
                                    "的名称和薪资(以空格分隔):",
                            "請依次輸入要註冊的員工" + (i+1) +
                                    "的名稱和薪资(以空格分隔):",
                            "Please enter the name and salary of the " + (i+1) +
                                    " employee to register(delineated by spaces):"
                    );


                    String[] information = OutputManager.getInstance().input().split("\\s+");

                    if(information.length != 2){
                        OutputManager.getInstance().errorMassage(
                                "无效输入，请重新输入：",
                                "無效輸入，请重新輸入：",
                                "Invalid input, please input again:"
                        );
                        continue;
                    }

                    String name = information[0];
                    Double salary;
                    try {
                        salary = Double.parseDouble(information[1]);
                    }
                    catch (Exception err){
                        continue;
                    }


                    newWorker.setName(name);
                    newWorker.setSalary(salary);
                    newWorker.setLeader(testingTeamLeader2);
                    qualityTestingDepartment.register(newWorker, true);

                    OutputManager.getInstance().print(
                            "员工注册成功！",
                            "員工註冊成功！",
                            "Employees are successfully registered."
                    );
                }

                salaryDaoImpl.saveSalary(qualityTestingDepartment);

            }
            else if(num==2){
                OutputManager.getInstance().print(
                        "当前可选的审计员: [1 - "+auditor1.getName()+"]\t[2 - "+auditor2.getName()+"]\t[3 - "+auditor3.getName()+"]\n请输入审计员序号：",
                        "當前可選的審計員: [1 - "+auditor1.getName()+"]\t[2 - "+auditor2.getName()+"]\t[3 - "+auditor3.getName()+"]\n請輸入審計員序號",
                        "Available auditors: [1 - "+auditor1.getName()+"]\t[2 - "+auditor2.getName()+"]\t[3 - "+auditor3.getName()+"]\nPlease input the auditor number: "
                );

                Integer auditorNum;
                while((auditorNum=CompanyManagementTest.intputInteger())==-1){
                    OutputManager.getInstance().errorMassage(
                            "无效输入，请重新输入：",
                            "無效輸入，请重新輸入：",
                            "Invalid input, please input again:"
                    );
                }


                AuditSalaryTableCommand auditSalaryTableCommand=new AuditSalaryTableCommand();
                if(auditorNum==1){
                    auditSalaryTableCommand.setAuditor(auditor1);
                }
                else if(auditorNum==2){
                    auditSalaryTableCommand.setAuditor(auditor2);
                }
                else if(auditorNum==3){
                    auditSalaryTableCommand.setAuditor(auditor3);
                }
                else{
                    OutputManager.getInstance().errorMassage(
                            "找不到该审计员",
                            "找不到該審計員",
                            "Auditor not found."
                    );
                    continue;
                }

                financialDepartment.setCurrentCommand(auditSalaryTableCommand);

                financialDepartment.giveCommand();

            }
            else if(num==3){
                financialDepartment.viewAuditHistoryList();
            }
            else if(num==4){
                OutputManager.getInstance().print(
                        "当前部门的员工有:",
                        "當前部門的員工有:",
                        "The employees in the current department are:"
                );

                List<BaseEmployee> qualityTestingEmployees = qualityTestingDepartment.getAllEmployees();
                for(BaseEmployee employee: qualityTestingEmployees){
                    OutputManager.getInstance().print(
                            employee.getName()+" ",
                            employee.getName()+" ",
                            employee.getName()+" "
                    );
                }

                OutputManager.getInstance().print(
                        "请输入要请假的员工姓名:",
                        "請輸入要請假的員工姓名:",
                        "Please enter the name of the employee requesting to leave:"
                );


                String name = OutputManager.getInstance().input();
                if(qualityTestingDepartment.getEmployee(name) == null){
                    OutputManager.getInstance().errorMassage(
                            "输入有误，该员工不存在",
                            "輸入有誤，該員工不存在",
                            "Invalid input, the employee doesn't exists."
                    );
                    continue;
                }
                LeaveRequest request = new LeaveRequest();
                BaseEmployee requestee = qualityTestingDepartment.getEmployee(name);
                request.setRequestee(requestee);

                OutputManager.getInstance().print(
                        "请输入员工请假的原因:",
                        "請輸入員工請假的原因:",
                        "Please enter the reason of the employee requesting to leave:"
                );

                String reason = OutputManager.getInstance().input();
                request.setReason(reason);

                OutputManager.getInstance().print(
                        "请输入员工请假的天数:",
                        "請輸入員工請假的天數:",
                        "Please enter the number of days of the employee requesting to leave:"
                );

                Integer days;
                while((days=CompanyManagementTest.intputInteger())==-1){
                    OutputManager.getInstance().errorMassage(
                            "无效输入，请重新输入：",
                            "無效輸入，请重新輸入：",
                            "Invalid input, please input again:"
                    );
                }


                if(days < 1){
                    OutputManager.getInstance().errorMassage(
                            "无效输入，请重新输入：",
                            "無效輸入，请重新輸入：",
                            "Invalid input, please input again:"
                    );
                    continue;
                }
//                request.setReason(reason);
                request.setDays(days);

                requestee.handleRequest(request);

            }
            else if(num==5){
                OutputManager.getInstance().print(
                        "当前QualityTesting部门的员工有：",
                        "當前QualityTesting部門的員工有：",
                        "Current employees in QualityTesting department are:"
                );

                List<BaseEmployee> qualityTestingEmployees = qualityTestingDepartment.getAllEmployees();
                for(BaseEmployee employee: qualityTestingEmployees){
                    OutputManager.getInstance().print(
                            employee.getName()+" ",
                            employee.getName()+" ",
                            employee.getName()+" "
                    );
                }

                OutputManager.getInstance().print(
                        "当前财务部门的员工有：",
                        "當前財務部門的員工有：",
                        "Current employees in Finance department are:"
                );

                List<BaseEmployee> financialEmployees = financialDepartment.getAllEmployees();
                for(BaseEmployee employee: financialEmployees){
                    OutputManager.getInstance().print(
                            employee.getName()+" ",
                            employee.getName()+" ",
                            employee.getName()+" "
                    );
                }

                OutputManager.getInstance().print(
                        "请输入进入财务系统的员工姓名：",
                        "請輸入進入財務系統的員工姓名：",
                        "Please enter the name of employee accessing the financial system: "
                );


                String name = OutputManager.getInstance().input();
                if(financialDepartment.getEmployee(name) != null){
                    BaseEmployee employee = financialDepartment.getEmployee(name);
//                    System.out.println("1");
                    if(employee instanceof Permission){
                        OutputManager.getInstance().printPattern(
                                "# 使用了标记接口模式",
                                "# 使用了標記接口模式",
                                "# Adopted Marker pattern"
                        );
//                        employee.accessFinancialSystem();
                        OutputManager.getInstance().print(
                                "财务处员工" + employee.getName() + "访问了财务系统。",
                                "財務處員工" + employee.getName() + "訪問了財務系統。",
                                "Employee of the financial department " + employee.getName() + "accessed the financial system.");

                    } else{
                        OutputManager.getInstance().errorMassage(
                                employee.getName()+ "没有权限访问财务系统，访问已被拒绝",
                                employee.getName()+"沒有權限訪問財務系統，訪問已被拒絕",
                                employee.getName()+"The access to financial system is rejected"
                        );
                    }
                }
                else if(qualityTestingDepartment.getEmployee(name) != null){
                    BaseEmployee employee = qualityTestingDepartment.getEmployee(name);
                    if(employee instanceof Permission){
                        OutputManager.getInstance().printPattern(
                                "# 使用了标记接口模式",
                                "# 使用了標記接口模式",
                                "# Adopted Marker pattern"
                        );
                        OutputManager.getInstance().print(
                                "质量测试部门员工" + employee.getName() + "访问了财务系统。",
                                "質量測試部門員工" + employee.getName() + "訪問了財務系統。",
                                "Employee of the quality testing department " + employee.getName() + "accessed the financial system.");
//                        employee.stealMoney();
                    } else{
                        OutputManager.getInstance().errorMassage(
                                employee.getName()+ "没有权限访问财务系统，访问已被拒绝",
                                employee.getName()+"沒有權限訪問財務系統，訪問已被拒絕",
                                employee.getName()+"The access to financial system is rejected"
                        );
                    }
                }
                else{
                    OutputManager.getInstance().errorMassage(
                            "输入有误，该员工不存在",
                            "輸入有誤，該員工不存在",
                            "Invalid input, the employee doesn't exists."
                    );
                    continue;
                }
            }
            else if(num == 6) {
                OutputManager.getInstance().print(
                        "请输入序号进行所需要的操作：\n" +
                                "[1 - 发布公告]\t[2 - 员工订阅公告]\t" +
                                "[3 - 退出系统]\n" +
                                "您的输入：",
                        "請輸入序號進行所需要的操作：\n" +
                                "[1 - 發佈公告]\t[2 - 員工訂閱公告]\t" +
                                "[3 - 退出系統]\n" +
                                "您的輸入：",
                        "Please input the following number for corresponding mission:\n" +
                                "[1 - Publish announcement]\t[2 - Subscribe announcement]\t" +
                                "[3 - Exit]" + "Your input: "
                );

                int option;

                while((option=CompanyManagementTest.intputInteger())==-1){
                    OutputManager.getInstance().errorMassage(
                            "无效输入，请重新输入：",
                            "無效輸入，请重新輸入：",
                            "Invalid input, please input again:"
                    );
                }

                if(option == 1) {
                    OutputManager.getInstance().print(
                            "请输入要发布的公告：",
                            "請輸入要發布的公告：",
                            "Please enter the announcement you are about to publish: "
                    );

                    String message = OutputManager.getInstance().input();
                    Announcer.getInstance().addMessage(message);

                }
                else if(option == 2) {


                    OutputManager.getInstance().print(
                            "当前部门的员工有：",
                            "當前部門的員工有：",
                            "Current employees are:"
                    );

                    List<BaseEmployee> qualityTestingEmployees = qualityTestingDepartment.getAllEmployees();
                    for(BaseEmployee employee: qualityTestingEmployees){
                        OutputManager.getInstance().print(
                                employee.getName() + " ",
                                employee.getName() + " ",
                                employee.getName() + " "
                        );
                    }

                    OutputManager.getInstance().print(
                            "请输入要订阅公告的员工的姓名：",
                            "請輸入要訂閱公告的員工的姓名：",
                            "Please enter the name of the employee subscribing the announcement: "
                    );

                    String name = OutputManager.getInstance().input();
                    if(qualityTestingDepartment.getEmployee(name) == null){
                        OutputManager.getInstance().errorMassage(
                                "输入有误，该员工不存在",
                                "輸入有誤，該員工不存在",
                                "Invalid input, the employee doesn't exists."
                        );
                        continue;
                    }
                    else {
                        BaseEmployee employee = qualityTestingDepartment.getEmployee(name);
                        employee.subscribe();
                    }
                }
                else if(option == 3){
                    break;
                }
                else {
                    OutputManager.getInstance().errorMassage(
                            "无效的选项输入，请重新输入：",
                            "無效的選項輸入，请重新輸入：",
                            "Invalid option input, please input again:"
                    );
                }
            }
            else if(num==7){
                break;
            }
            else{
                OutputManager.getInstance().errorMassage(
                        "无效的整数序号输入，请重新输入：",
                        "無效的整數序號輸入，请重新輸入：",
                        "Invalid integer input, please input again:"
                );
            }
            System.out.print("\n");

        }

        salaryDaoImpl.closeFile();
        OutputManager.getInstance().print(
                "已退出公司管理系统",
                "已退出公司管理系統",
                "Exit company management system."
        );
    }
}
