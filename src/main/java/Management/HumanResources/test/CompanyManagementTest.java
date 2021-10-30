package Management.HumanResources.test;

import Management.HumanResources.DepartmentCommand.AuditSalaryTableCommand;
import Management.HumanResources.FinancialSystem.FinancialDepartment;
import Management.HumanResources.Manager.TestingManager;
import Management.HumanResources.Staff.Auditor;
import Management.HumanResources.Staff.Worker;
import Management.HumanResources.TeamLeader.TestingTeamLeader;
import Management.QualityTesting.QualityAssuranceDepartment;
import Presentation.Protocol.OutputManager;
import Management.HumanResources.FinancialSystem.DataAccessObject.SalaryDaoImpl;

import java.io.IOException;
import java.util.Scanner;

/**
 * 故事线2的测试
 *
 * @author 陈垲昕
 * @since 2021/10/30 2:14 下午
 */

public class CompanyManagementTest {

    /**
     * 起始输入
     * @author 陈垲昕
     * @since 2021-10-30 8:40 下午
     */
    public static void loadingInput() throws InterruptedException {
        for (int i = 0; i <= 100; i++) {
            if(OutputManager.getInstance().getLanguage()== OutputManager.Lang.zh_CN) {
                System.out.print("公司管理系统加载中：" + i + "%");
            }
            else if(OutputManager.getInstance().getLanguage()== OutputManager.Lang.zh_TW){
                System.out.print("公司管理系統加載中：" + i + "%");
            }
            else{
                System.out.print("Loading company management system：" + i + "%");
            }
            Thread.sleep(20);
            System.out.print("\r");
        }
    }

    public static void main(String[] args) throws IOException {

        //OutputManager.getInstance().setLanguage(OutputManager.Lang.zh_TW);

        try{
          loadingInput();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 获取QualityAssurance部门的实例
        QualityAssuranceDepartment qualityTestingDepartment = QualityAssuranceDepartment.getInstance();
        // 获取FinancialDepartment部门的实例
        FinancialDepartment financialDepartment = FinancialDepartment.getInstance();
        // 创建该部门的经理
        TestingManager testingManager = new TestingManager();
        // 创建该部门的一个组长
        TestingTeamLeader testingTeamLeader1 = new TestingTeamLeader();
        // 创建该部门的一个员工
        Worker testingWorker = new Worker();
        //创建经济部门的审计员等
        Auditor auditor1=new Auditor("法克", 201.0);
        Auditor auditor2=new Auditor("尤尔",100.0);
        Auditor auditor3=new Auditor("马泽尔",100.0);
        financialDepartment.register(auditor1);
        financialDepartment.register(auditor2);
        financialDepartment.register(auditor3);


        SalaryDaoImpl salaryDaoImpl = SalaryDaoImpl.getInstance();

        salaryDaoImpl.saveSalary(financialDepartment);

        salaryDaoImpl.closeFile();

        testingManager.setName("Bear");

        testingTeamLeader1.setName("梁乔");
        testingTeamLeader1.setLeader(testingManager);

        testingWorker.setName("桥梁");
        testingWorker.setLeader(testingTeamLeader1);

        // 分别将其注册到该部门
        qualityTestingDepartment.register(testingManager);
        qualityTestingDepartment.register(testingTeamLeader1);
        qualityTestingDepartment.register(testingWorker);

        OutputManager.getInstance().print(
                "公司管理系统已经激活且加载基础数据",
                "公司管理系統已經激活且加載基礎數據",
                "Company management system has been activated."
        );

        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        while(true) {
            OutputManager.getInstance().print(
                    "请输入序号进行所需要的操作：\n" +
                            "[1 - 注册员工]\t[2 - 审计报告]\t[3 - 查看审计记录]\t[4 - 请假处理]\t[5 - 退出系统]\n" +
                            "您的输入：",
                    "請輸入序號進行所需要的操作：\n" +
                            "[1 - 註冊員工]\t[2 - 審計報告]\t[3 - 查看備忘錄]\t[4 - 請假處理]\t[5 - 退出系統]\n" +
                            "您的輸入：",
                    "Please input the following number for corresponding mission:\n" +
                            "[1 - employee registration]\t[2 - salary report audit]\t[3 - view history memento]\t[4 - leave request procedure]\t[5 - exit system]\n" +
                            "Your input: "
            );

            while(!scanner.hasNextInt()) {
                scanner.next();
                OutputManager.getInstance().errorMassage(
                        "无效输入，请重新输入：",
                        "無效輸入，请重新輸入：",
                        "Invalid input, please input again:"
                );
            }
            int num= scanner.nextInt();
            //进入员工注册
            if(num==1) {
                //TODO: 员工注册流程——注意要同时添加DAO
            }
            else if(num==2){
                OutputManager.getInstance().print(
                        "当前可选的审计员: [1 - "+auditor1.getName()+"]\t[2 - "+auditor2.getName()+"]\t[3 - "+auditor3.getName()+"]\n请输入审计员序号：",
                        "當前可選的審計員: [1 - "+auditor1.getName()+"]\t[2 - "+auditor2.getName()+"]\t[3 - "+auditor3.getName()+"]\n請輸入審計員序號",
                        "Available auditors: [1 - "+auditor1.getName()+"]\t[2 - "+auditor2.getName()+"]\t[3 - "+auditor3.getName()+"]\nPlease input the auditor number: "
                );

                while((!scanner2.hasNextInt())){
                    scanner2.next();
                    OutputManager.getInstance().errorMassage(
                            "无效输入，请重新输入：",
                            "無效輸入，请重新輸入：",
                            "Invalid input, please input again:"
                    );
                }
                int auditorNum=scanner2.nextInt();

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
                //TODO: 请假处理
            }
            else if(num==5){
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

        OutputManager.getInstance().print(
                "已退出公司管理系统",
                "已退出公司管理系統",
                "Exit company management system."
        );

    }
}
