package Management.HumanResources.test;

import CanFactory.CanFactory;
import Presentation.Protocol.IOManager;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 故事线2的测试
 *
 * @author 陈垲昕
 * @since 2021/10/30 2:14 下午
 */

public class CompanyManagementTest {
    public static int inputInteger() {
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
    public static void main(String[] args) throws IOException {
        CanFactory factory = CanFactory.getInstance();
        factory.companyManage();
    }
}
