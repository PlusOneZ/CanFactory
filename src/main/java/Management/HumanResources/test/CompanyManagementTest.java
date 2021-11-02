package Management.HumanResources.test;

import CanFactory.CanFactory;
import Management.HumanResources.BaseEmployee;
import Management.HumanResources.DepartmentCommand.AuditSalaryTableCommand;
import Management.HumanResources.FinancialSystem.FinancialDepartment;
import Management.HumanResources.FinancialSystem.Permission;
import Management.HumanResources.LeaveRequest;
import Management.HumanResources.Manager.TestingManager;
import Management.HumanResources.Staff.Accountant;
import Management.HumanResources.Staff.Announcer;
import Management.HumanResources.Staff.Auditor;
import Management.HumanResources.Staff.Worker;
import Management.HumanResources.TeamLeader.TestingTeamLeader;
import Management.QualityTesting.QualityAssuranceDepartment;
import Presentation.Protocol.OutputManager;
import Management.HumanResources.FinancialSystem.DataAccessObject.SalaryDaoImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 故事线2的测试
 *
 * @author 陈垲昕
 * @since 2021/10/30 2:14 下午
 */

public class CompanyManagementTest {

    public static int intputInteger(){
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

    public static void main(String[] args) throws IOException {
        CanFactory factory = CanFactory.getInstance();
        factory.companyManage();
    }
}
