package CanFactory;

import ImplementDepartment.OrderImplementDepartment;
import Management.Assets.Announcement.BlackBoardTest;
import Management.Assets.ClothingDecoraor.DecoratorTest;
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
import Management.HumanResources.test.*;
import Management.QualityTesting.QualityAssuranceDepartment;
import Management.QuantityTesting.VisitorTest;
import Manufacturing.CanEntity.CanTest;
import Manufacturing.CanEntity.ConcreteCan.PrototypeTest;
import Manufacturing.Ingredient.CompositeTest;
import Manufacturing.Machine.CanTreatmentMachine.MultitonTest;
import Manufacturing.ProductLine.Producer.Test.AdapterTest;
import Manufacturing.ProductLine.PurchaseDepartment;
import Manufacturing.ProductLine.test.ProductDepartment;
import Marketing.IteratorPatternTest;
import Marketing.OrderEnity.Order;
import Marketing.OrderEnity.StatePatternTest;
import Marketing.Promotion.SaleTest;
import Marketing.Wrapping.WrappingDriver;
import Mediator.DepartmentMediator;
import Presentation.AsciiVid.AsciiPic;
import Presentation.Protocol.IOManager;
import Storage.InventoryDriver;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 所有类的驱动类
 *
 * @author 卓正一
 * @since 2021/10/29 5:16 PM
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
     *
     * @author 卓正一
     * @since 2021-10-29 5:17 PM
     */
    private CanFactory() {

    }

    public int inputInteger() {
        String inputStr = IOManager.getInstance().input();
        if (inputStr == "") {
            return -1;
        }
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(inputStr);
        if (!isNum.matches()) {
            return -1;
        } else {
            return Integer.parseInt(inputStr);
        }
    }

    public void run() {

        IOManager.getInstance().printLanguageIrrelevantContent("请选择使用语言 /請選擇使用語言 /Please select the language");

        IOManager.getInstance().printLanguageIrrelevantContent("[1 - 中文（简体）]\t[2 - 中文（繁體）]\t[3 - English]");

        int selectedLanguage = -1;
        while ((selectedLanguage = this.inputInteger()) == -1 || selectedLanguage < 1 || selectedLanguage > 3) {
            IOManager.getInstance().printLanguageIrrelevantContent(
                    "无效输入，请重新输入 /無效輸入，请重新輸入/ Invalid input, please input again"
            );
        }

        switch (selectedLanguage) {
            case 1:
                IOManager.getInstance().setLanguage(IOManager.Lang.zh_CN);
                break;
            case 2:
                IOManager.getInstance().setLanguage(IOManager.Lang.zh_TW);
                break;
            case 3:
                IOManager.getInstance().setLanguage(IOManager.Lang.en);
                break;
        }

        try {
            loadingInput();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(IOManager.operatingSystem == IOManager.OperatingSystem.MAC)
            AsciiPic.macHelloPic();

        IOManager.getInstance().print(
                "[1 - 订单系统]\t[2 - 管理系统]\t[3 - 30个设计模式测试]",
                "[1 -訂單系統]\t[2 -管理系統]\t[3 - 30個設計模式測試]",
                "[1 - Order System]\t[2 - Management System]\t[3 - 30 Design Patterns Test]"
        );

        int selectedSystem = -1;
        while ((selectedSystem = this.inputInteger()) == -1 || selectedSystem < 1 || selectedSystem > 3) {
            IOManager.getInstance().errorMassage(
                    "无效输入，请重新输入",
                    "無效輸入，请重新輸入",
                    "Invalid input, please input again"
            );
        }

        switch (selectedSystem) {
            case 1:
                this.orderManage();
                break;
            case 2:
                this.companyManage();
                break;
            case 3:
                this.designPatternTest();
                break;
        }


    }

    /**
     * 起始输入
     *
     * @author 陈垲昕
     * @since 2021-10-30 8:40 下午
     */
    public static void loadingInput() throws InterruptedException {
        for (int i = 0; i <= 100; i++) {
            IOManager.getInstance().printLoading(
                    "罐头工厂加载中：" + i + "%",
                    "罐頭工廠加載中：" + i + "%",
                    "Loading Can Factory：" + i + "%"
            );
            Thread.sleep(20);
            IOManager.getInstance().printLoading("\r", "\r", "\r");
        }
    }


    public void orderManage() {
        //首先提示客户创建订单
        ArrayList<Order> pendingOrders = null;
        try {
            pendingOrders = OrderImplementDepartment.getInstance().CreateOrder();
        } catch (ParseException e) {
            e.printStackTrace();
            IOManager.getInstance().errorMassage(
                    "出现异常！",
                    "出現異常",
                    "Abnormal!"
            );
        }
        //然后通知库存部门作后续处理
        for (Order order : pendingOrders) {
            //对于每一个订单，进行相应的处理
            DepartmentMediator.getInstance().handleOrder(order);
        }
        if(IOManager.getInstance().operatingSystem == IOManager.OperatingSystem.MAC)
            IOManager.getInstance().timer.cancel();
    }


    /**
     * 管理系统测试
     * @throws IOException
     */
    public void companyManage() {


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
        Auditor auditor1 = new Auditor("刘平", 201.0);
        Auditor auditor2 = new Auditor("张婧", 100.0);
        Auditor auditor3 = new Auditor("安婷", 100.0);
        financialDepartment.register(auditor1, false);
        financialDepartment.register(auditor2, false);
        financialDepartment.register(auditor3, false);


        SalaryDaoImpl salaryDaoImpl = SalaryDaoImpl.getInstance();

        try {
            salaryDaoImpl.saveSalary(financialDepartment);
        } catch (IOException e) {
            e.printStackTrace();
        }

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
        qualityTestingDepartment.register(testingManager, false);
        qualityTestingDepartment.register(testingTeamLeader1, false);
        qualityTestingDepartment.register(testingWorker, false);
        qualityTestingDepartment.register(testingTeamLeader2, false);
        qualityTestingDepartment.register(testingWorker1, false);
        qualityTestingDepartment.register(testingWorker2, false);

        IOManager.getInstance().print(
                "公司管理系统已经激活且加载基础数据",
                "公司管理系統已經激活且加載基礎數據",
                "Company management system has been activated."
        );

        while (true) {
            IOManager.getInstance().print(
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

            int selectedOperation = -1;
            while ((selectedOperation = this.inputInteger()) == -1) {
                IOManager.getInstance().errorMassage(
                        "无效输入，请重新输入：",
                        "無效輸入，请重新輸入：",
                        "Invalid input, please input again:"
                );
            }

            //进入员工注册
            if (selectedOperation == 1) {
                IOManager.getInstance().print(
                        "请输入需要注册的员工数量:",
                        "請輸入需要註冊的員工數量:",
                        "Please enter the number of employees to register:"
                );

                Integer numOfEmployees;
                while ((numOfEmployees = CompanyManagementTest.inputInteger()) == -1) {
                    IOManager.getInstance().errorMassage(
                            "无效输入，请重新输入：",
                            "無效輸入，请重新輸入：",
                            "Invalid input, please input again:"
                    );
                }

                if (numOfEmployees < 1) {
                    IOManager.getInstance().errorMassage(
                            "无效输入，请重新输入：",
                            "無效輸入，请重新輸入：",
                            "Invalid input, please input again:"
                    );
                    continue;
                }
                for (int i = 0; i < numOfEmployees; i++) {

                    Worker newWorker = new Worker();


                    IOManager.getInstance().print(
                            "请依次输入要注册的员工" + (i + 1) +
                                    "的名称和薪资(以空格分隔):",
                            "請依次輸入要註冊的員工" + (i + 1) +
                                    "的名稱和薪资(以空格分隔):",
                            "Please enter the name and salary of the " + (i + 1) +
                                    " employee to register(delineated by spaces):"
                    );


                    String[] information = IOManager.getInstance().input().split("\\s+");

                    if (information.length != 2) {
                        IOManager.getInstance().errorMassage(
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
                    } catch (Exception err) {
                        continue;
                    }


                    newWorker.setName(name);
                    newWorker.setSalary(salary);
                    newWorker.setLeader(testingTeamLeader2);
                    qualityTestingDepartment.register(newWorker, true);

                    IOManager.getInstance().print(
                            "员工注册成功！",
                            "員工註冊成功！",
                            "Employees are successfully registered."
                    );
                }

                try {
                    salaryDaoImpl.saveSalary(qualityTestingDepartment);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else if (selectedOperation == 2) {
                IOManager.getInstance().print(
                        "当前可选的审计员: [1 - " + auditor1.getName() + "]\t[2 - " + auditor2.getName() + "]\t[3 - " + auditor3.getName() + "]\n请输入审计员序号：",
                        "當前可選的審計員: [1 - " + auditor1.getName() + "]\t[2 - " + auditor2.getName() + "]\t[3 - " + auditor3.getName() + "]\n請輸入審計員序號",
                        "Available auditors: [1 - " + auditor1.getName() + "]\t[2 - " + auditor2.getName() + "]\t[3 - " + auditor3.getName() + "]\nPlease input the auditor number: "
                );

                Integer auditorNum;
                while ((auditorNum = CompanyManagementTest.inputInteger()) == -1) {
                    IOManager.getInstance().errorMassage(
                            "无效输入，请重新输入：",
                            "無效輸入，请重新輸入：",
                            "Invalid input, please input again:"
                    );
                }


                AuditSalaryTableCommand auditSalaryTableCommand = new AuditSalaryTableCommand();
                if (auditorNum == 1) {
                    auditSalaryTableCommand.setAuditor(auditor1);
                } else if (auditorNum == 2) {
                    auditSalaryTableCommand.setAuditor(auditor2);
                } else if (auditorNum == 3) {
                    auditSalaryTableCommand.setAuditor(auditor3);
                } else {
                    IOManager.getInstance().errorMassage(
                            "找不到该审计员",
                            "找不到該審計員",
                            "Auditor not found."
                    );
                    continue;
                }

                financialDepartment.setCurrentCommand(auditSalaryTableCommand);

                financialDepartment.giveCommand();

            } else if (selectedOperation == 3) {
                financialDepartment.viewAuditHistoryList();
            } else if (selectedOperation == 4) {
                IOManager.getInstance().print(
                        "当前部门的员工有:",
                        "當前部門的員工有:",
                        "The employees in the current department are:"
                );

                List<BaseEmployee> qualityTestingEmployees = qualityTestingDepartment.getAllEmployees();
                for (BaseEmployee employee : qualityTestingEmployees) {
                    IOManager.getInstance().print(
                            employee.getName() + " ",
                            employee.getName() + " ",
                            employee.getName() + " "
                    );
                }

                IOManager.getInstance().print(
                        "请输入要请假的员工姓名:",
                        "請輸入要請假的員工姓名:",
                        "Please enter the name of the employee requesting to leave:"
                );


                String name = IOManager.getInstance().input();
                if (qualityTestingDepartment.getEmployee(name) == null) {
                    IOManager.getInstance().errorMassage(
                            "输入有误，该员工不存在",
                            "輸入有誤，該員工不存在",
                            "Invalid input, the employee doesn't exists."
                    );
                    continue;
                }
                LeaveRequest request = new LeaveRequest();
                BaseEmployee requestee = qualityTestingDepartment.getEmployee(name);
                request.setRequestee(requestee);

                IOManager.getInstance().print(
                        "请输入员工请假的原因:",
                        "請輸入員工請假的原因:",
                        "Please enter the reason of the employee requesting to leave:"
                );

                String reason = IOManager.getInstance().input();
                request.setReason(reason);

                IOManager.getInstance().print(
                        "请输入员工请假的天数:",
                        "請輸入員工請假的天數:",
                        "Please enter the number of days of the employee requesting to leave:"
                );

                Integer days;
                while ((days = CompanyManagementTest.inputInteger()) == -1) {
                    IOManager.getInstance().errorMassage(
                            "无效输入，请重新输入：",
                            "無效輸入，请重新輸入：",
                            "Invalid input, please input again:"
                    );
                }


                if (days < 1) {
                    IOManager.getInstance().errorMassage(
                            "无效输入，请重新输入：",
                            "無效輸入，请重新輸入：",
                            "Invalid input, please input again:"
                    );
                    continue;
                }
//                request.setReason(reason);
                request.setDays(days);

                requestee.handleRequest(request);

            } else if (selectedOperation == 5) {
                IOManager.getInstance().print(
                        "当前QualityTesting部门的员工有：",
                        "當前QualityTesting部門的員工有：",
                        "Current employees in QualityTesting department are:"
                );

                List<BaseEmployee> qualityTestingEmployees = qualityTestingDepartment.getAllEmployees();
                for (BaseEmployee employee : qualityTestingEmployees) {
                    IOManager.getInstance().print(
                            employee.getName() + " ",
                            employee.getName() + " ",
                            employee.getName() + " "
                    );
                }

                IOManager.getInstance().print(
                        "当前财务部门的员工有：",
                        "當前財務部門的員工有：",
                        "Current employees in Finance department are:"
                );

                List<BaseEmployee> financialEmployees = financialDepartment.getAllEmployees();
                for (BaseEmployee employee : financialEmployees) {
                    IOManager.getInstance().print(
                            employee.getName() + " ",
                            employee.getName() + " ",
                            employee.getName() + " "
                    );
                }

                IOManager.getInstance().print(
                        "请输入进入财务系统的员工姓名：",
                        "請輸入進入財務系統的員工姓名：",
                        "Please enter the name of employee accessing the financial system: "
                );


                String name = IOManager.getInstance().input();
                if (financialDepartment.getEmployee(name) != null) {
                    BaseEmployee employee = financialDepartment.getEmployee(name);
//                    System.out.println("1");
                    if (employee instanceof Permission) {
                        IOManager.getInstance().printPattern(
                                "# 使用了标记接口模式",
                                "# 使用了標記接口模式",
                                "# Adopted Marker pattern"
                        );
//                        employee.accessFinancialSystem();
                        IOManager.getInstance().print(
                                "财务处员工" + employee.getName() + "访问了财务系统。",
                                "財務處員工" + employee.getName() + "訪問了財務系統。",
                                "Employee of the financial department " + employee.getName() + "accessed the financial system.");

                    } else {
                        IOManager.getInstance().errorMassage(
                                employee.getName() + "没有权限访问财务系统，访问已被拒绝",
                                employee.getName() + "沒有權限訪問財務系統，訪問已被拒絕",
                                employee.getName() + "The access to financial system is rejected"
                        );
                    }
                } else if (qualityTestingDepartment.getEmployee(name) != null) {
                    BaseEmployee employee = qualityTestingDepartment.getEmployee(name);
                    if (employee instanceof Permission) {
                        IOManager.getInstance().printPattern(
                                "# 使用了标记接口模式",
                                "# 使用了標記接口模式",
                                "# Adopted Marker pattern"
                        );
                        IOManager.getInstance().print(
                                "质量测试部门员工" + employee.getName() + "访问了财务系统。",
                                "質量測試部門員工" + employee.getName() + "訪問了財務系統。",
                                "Employee of the quality testing department " + employee.getName() + "accessed the financial system.");
//                        employee.stealMoney();
                    } else {
                        IOManager.getInstance().errorMassage(
                                employee.getName() + "没有权限访问财务系统，访问已被拒绝",
                                employee.getName() + "沒有權限訪問財務系統，訪問已被拒絕",
                                employee.getName() + "The access to financial system is rejected"
                        );
                    }
                } else {
                    IOManager.getInstance().errorMassage(
                            "输入有误，该员工不存在",
                            "輸入有誤，該員工不存在",
                            "Invalid input, the employee doesn't exists."
                    );
                    continue;
                }
            } else if (selectedOperation == 6) {
                IOManager.getInstance().print(
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

                while ((option = CompanyManagementTest.inputInteger()) == -1) {
                    IOManager.getInstance().errorMassage(
                            "无效输入，请重新输入：",
                            "無效輸入，请重新輸入：",
                            "Invalid input, please input again:"
                    );
                }

                if (option == 1) {
                    IOManager.getInstance().print(
                            "请输入要发布的公告：",
                            "請輸入要發布的公告：",
                            "Please enter the announcement you are about to publish: "
                    );

                    String message = IOManager.getInstance().input();
                    Announcer.getInstance().addMessage(message);

                } else if (option == 2) {


                    IOManager.getInstance().print(
                            "当前部门的员工有：",
                            "當前部門的員工有：",
                            "Current employees are:"
                    );

                    List<BaseEmployee> qualityTestingEmployees = qualityTestingDepartment.getAllEmployees();
                    for (BaseEmployee employee : qualityTestingEmployees) {
                        IOManager.getInstance().print(
                                employee.getName() + " ",
                                employee.getName() + " ",
                                employee.getName() + " "
                        );
                    }

                    IOManager.getInstance().print(
                            "请输入要订阅公告的员工的姓名：",
                            "請輸入要訂閱公告的員工的姓名：",
                            "Please enter the name of the employee subscribing the announcement: "
                    );

                    String name = IOManager.getInstance().input();
                    if (qualityTestingDepartment.getEmployee(name) == null) {
                        IOManager.getInstance().errorMassage(
                                "输入有误，该员工不存在",
                                "輸入有誤，該員工不存在",
                                "Invalid input, the employee doesn't exists."
                        );
                        continue;
                    } else {
                        BaseEmployee employee = qualityTestingDepartment.getEmployee(name);
                        employee.subscribe();
                    }
                } else if (option == 3) {
                    break;
                } else {
                    IOManager.getInstance().errorMassage(
                            "无效的选项输入，请重新输入：",
                            "無效的選項輸入，请重新輸入：",
                            "Invalid option input, please input again:"
                    );
                }
            } else if (selectedOperation == 7) {
                break;
            } else {
                IOManager.getInstance().errorMassage(
                        "无效的整数序号输入，请重新输入：",
                        "無效的整數序號輸入，请重新輸入：",
                        "Invalid integer input, please input again:"
                );
            }
            System.out.print("\n");

        }

        salaryDaoImpl.closeFile();
        IOManager.getInstance().print(
                "已退出公司管理系统",
                "已退出公司管理系統",
                "Exit company management system."
        );

        if(IOManager.getInstance().operatingSystem == IOManager.OperatingSystem.MAC)
            IOManager.getInstance().timer.cancel();
    }

    /**
     * 30个设计模式测试
     */
    public void designPatternTest(){
        while (true) {

            IOManager.getInstance().print(
                    "请输入序号选择要测试的设计模式：",
                    "請輸入序號選擇要測試的設計模式：",
                    "Please enter the index to select the design pattern to test:"
            );

            IOManager.getInstance().print(
                    "[1 - 抽象工厂模式]\t[2 - 建造者模式]\t[3 - 工厂方法模式]\t[4 - 原型模式]\t[5 - 单例模式]",
                    "[1 - 抽象工廠模式]\t[2 - 建造者模式]\t[3 - 工廠方法模式]\t[4 - 原型模式]\t[5 - 單例模式]",
                    "[1 - Abstract Factory]\t[2 - Builder]\t[3 - Factory Method]\t[4 - Prototype]\t[5 - Singleton]"
            );

            IOManager.getInstance().print(
                    "[6 - 转换器模式]\t[7 - 多例模式]\t[8 - 适配器模式]\t[9 - 桥接模式]\t[10 - 组合模式]",
                    "[6 - 轉換器模式]\t[7 - 多例模式]\t[8 - 轉接器模式]\t[9 - 橋接模式]\t[10 - 組合模式]",
                    "[6 - Converter]\t[7 - Multiton]\t[8 - Adapter]\t[9 - Bridge]\t[10 - Composite]"
            );

            IOManager.getInstance().print(
                    "[11 - 装饰器模式]\t[12 - 外观模式]\t[13 - 享元模式]\t[14 - 代理模式]\t[15 - 数据访问对象模式]",
                    "[6 - 裝潢器模式]\t[7 - 外觀模式]\t[8 - 享元模式]\t[9 - 代理模式]\t[10 - 數據訪問對象模式]",
                    "[11 - Decorator]\t[12 - Facade]\t[13 - Flyweight]\t[14 - Proxy]\t[15 - DAO]"
            );

            IOManager.getInstance().print(
                    "[16 - 脏标记模式]\t[17 - 责任链模式]\t[18 - 命令模式]\t[19 - 解释器模式]\t[20 - 迭代器模式]",
                    "[16 - 髒標記模式]\t[17 - 責任鏈模式]\t[18 - 命令模式]\t[19 - 解譯器模式]\t[20 - 迭代器模式]",
                    "[16 - DirtyFlag]\t[17 - Chain of Responsibility]\t[18 - Command]\t[19 - Interpreter]\t[20 - Iterator]"
            );

            IOManager.getInstance().print(
                    "[21 - 中介者模式]\t[22 - 备忘录模式]\t[23 - 观察者模式]\t[24 - 状态模式]\t[25 - 策略模式]",
                    "[21 - 仲介者模式]\t[22 - 備忘錄模式]\t[23 - 觀察者模式]\t[24 - 狀態模式]\t[25 - 策略模式]",
                    "[21 - Mediator]\t[22 - Memento]\t[23 - Observer]\t[24 - State]\t[25 - Strategy]"
            );

            IOManager.getInstance().print(
                    "[26 - 模板方法模式]\t[27 - 访问者模式]\t[28 - 黑板模式]\t[29 - 委派模式]\t[30 - 过滤器模式]",
                    "[26 - 範本方法模式]\t[27 - 訪問者模式]\t[28 - 黑板模式]\t[29 - 委派模式]\t[30 - 篩檢程式模式]",
                    "[26 - Template]\t[27 - Visitor]\t[28 - BlackBoard]\t[29 - Delegate]\t[30 - Filter]"
            );

            IOManager.getInstance().print(
                    "[31 - 退出]",
                    "[31 - 退出]",
                    "[31 - Exit]"
            );


            int selectedOperation = -1;
            while ((selectedOperation = this.inputInteger()) == -1 || selectedOperation < 1
            ||selectedOperation > 31) {
                IOManager.getInstance().errorMassage(
                        "无效输入，请重新输入：",
                        "無效輸入，请重新輸入：",
                        "Invalid input, please input again:"
                );
            }

            String[] args={"test"};

            if(selectedOperation == 31){
                break;
            }

            for(int i = 0 ; i<3;++i){
                IOManager.getInstance().printLanguageIrrelevantContent("");
            }

            IOManager.getInstance().print(
                    "------------------开始测试------------------",
                    "------------------開始測試------------------",
                    "------------------Start test------------------"
            );

            switch (selectedOperation){
                case 1:
                    ProductDepartment.main(args);
                    break;
                case 2:
                case 6:
                    try {
                        WrappingDriver.main(args);
                    } catch (NoSuchMethodException | InvocationTargetException  | InstantiationException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    ProductDepartment.main(args);
                    break;
                case 4:
                    PrototypeTest.main(args);
                    break;
                case 5:
                    IOManager.main(args);
                    break;
                case 7:
                    MultitonTest.main(args);
                    break;
                case 8:
                    AdapterTest.main(args);
                    break;
                case 9:
                    CanTest.main(args);
                    break;
                case 10:
                    CompositeTest.main(args);
                case 11:
                    DecoratorTest.main(args);
                    break;
                case 12:
                    Manufacturing.ProductLine.Pretreatment.Test.FacadeTest.main(args);
                    break;
                case 13:
                    ProductDepartment.main(args);
                    break;
                case 14:
                    BlackBoardTest.main(args);
                    break;
                case 15:
                    try {
                        FinancialDepartmentTest.main(args);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 16:
                    AuditTest.main(args);
                    break;
                case 17:
                    ChainOfResponsibilityTest.main(args);
                    break;
                case 18:
                    AuditTest.main(args);
                    break;
                case 19:
                    IOManager.getInstance().print(
                            "# 使用解释器模式： 当您输入并得到这条输出的时候，您就已经使用了解释器模式",
                            "# 使用解譯器模式：當您輸入並得到這條輸出的時候，您就已經使用了解譯器模式",
                            "# Using Interpreter Pattern: when you input and get this output, you have already used interpreter pattern"
                    );
                    break;
                case 20:
                    IteratorPatternTest.main(args);
                    break;
                case 21:
                    InventoryDriver.main(args);
                    break;
                case 22:
                    AuditTest.main(args);
                    break;
                case 23:
                    PurchaseDepartment.main(args);
                    break;
                case 24:
                    StatePatternTest.main(args);
                    break;
                case 25:
                    SaleTest.main(args);
                    break;
                case 26:
                    ProductDepartment.main(args);
                    break;
                case 27:
                    VisitorTest.main(args);
                    break;
                case 28:
                    BlackBoardTest.main(args);
                    break;
                case 29:
                    TransportDepartmentTest.main(args);
                    break;
                case 30:
                    PurchaseDepartment.main(args);
                    break;
            }

            IOManager.getInstance().print(
                    "------------------结束测试------------------",
                    "------------------結束測試------------------",
                    "------------------End test------------------"
            );

            for(int i = 0 ; i<3;++i){
                IOManager.getInstance().printLanguageIrrelevantContent("");
            }
        }
        if(IOManager.getInstance().operatingSystem == IOManager.OperatingSystem.MAC)
            IOManager.getInstance().timer.cancel();
    }
}
