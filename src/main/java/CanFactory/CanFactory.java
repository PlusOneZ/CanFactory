package CanFactory;

import ImplementDepartment.OrderImplementDepartment;
import Management.HumanResources.test.CompanyManagementTest;
import Marketing.OrderEnity.Order;
import Mediator.DepartmentMediator;
import Presentation.Protocol.OutputManager;

import java.text.ParseException;
import java.util.ArrayList;
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

        OutputManager.getInstance().printLanguageIrrelevantContent("1. 中文（简体） 2. 中文（繁體） 3. English" );

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
}
