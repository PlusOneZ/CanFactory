package
        ImplementDepartment;

import Manufacturing.CanEntity.Can;
import Manufacturing.CanEntity.CanInfoController;
import Manufacturing.CanEntity.ConcreteCan.CandiedAppleCan;
import Marketing.OrderCenterEntity.OrderCenter;
import Marketing.OrderEnity.Order;
import Marketing.OrderEnity.OrderCanInformation;
import Marketing.Promotion.Coupon;
import Marketing.Promotion.Sale.TwentyPercentOff;
import Mediator.DepartmentMediator;
import Presentation.Protocol.OutputManager;

import javax.crypto.Mac;
import javax.naming.InsufficientResourcesException;
import java.io.ObjectStreamException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 订单创建业务执行部门，单例模式
 * @author 梁乔
 * @date 2021/10/30 13:02 
 */
public class OrderImplementDepartment {

    private static OrderImplementDepartment orderImplementDepartment = new OrderImplementDepartment();

    private OrderImplementDepartment(){

    }

    public static OrderImplementDepartment getInstance(){
        return orderImplementDepartment;
    }


    public ArrayList<Order> CreateOrder() throws ParseException {
        OutputManager.getInstance().setLanguage(OutputManager.Lang.zh_CN);
        OutputManager.getInstance().print(
                "进入订单创建系统。",
                "進入訂單創建系統。",
                "Enter the order creation system."
        );
        OutputManager.getInstance().print(
                "请输入创建订单相关信息。",
                "請輸入創建訂單相關信息。",
                "Please enter the relevant information to create the order."
        );
        while(true){
            ArrayList<OrderCanInformation> orderCanInformationArrayList = new ArrayList<OrderCanInformation>();
            while(true) {
                String canName;
                OutputManager.getInstance().print(
                        "输入需要的订单罐头类型，1表示"+CanInfoController.getInstance().getCanList().get(0)+",2表示"+
                                CanInfoController.getInstance().getCanList().get(1)+
                                ",3表示"+ CanInfoController.getInstance().getCanList().get(2)+",4表示"+CanInfoController.getInstance().getCanList().get(3),
                        "輸入需要的訂單罐頭類型，1表示"+CanInfoController.getInstance().getCanList().get(0)+",2表示"+
                                CanInfoController.getInstance().getCanList().get(1)+",3表示"+
                                CanInfoController.getInstance().getCanList().get(2)+"，4表示"+CanInfoController.getInstance().getCanList().get(3),
                        "Enter the type of canned food you need, 1 means"+CanInfoController.getInstance().getCanList().get(0)+
                                ", 2 means"+CanInfoController.getInstance().getCanList().get(1)+", 3 means"
                        +CanInfoController.getInstance().getCanList().get(2)+", 4 means"+CanInfoController.getInstance().getCanList().get(3)
                );
                double canPrice;//订单中罐头的单价
                while(true) {
                    Scanner inputScanner = new Scanner(System.in);
                    String canType = inputScanner.next();
                    if (Objects.equals(canType, "1")) {
                        canName = CanInfoController.getInstance().getCanList().get(0);
                        OutputManager.getInstance().print(
                                "您输入的该子订单的罐头类型为"+canName,
                                "您輸入的該子訂單的罐頭類型為"+canName,
                                "The canned food type of the sub-order you entered is"+canName
                        );
                        canPrice = CanInfoController.getInstance().getCanPriceByName(CanInfoController.getInstance().getCanList().get(0));
                        break;
                    } else if (Objects.equals(canType,"2")) {
                        canName = CanInfoController.getInstance().getCanList().get(1);
                        OutputManager.getInstance().print(
                                "您输入的该子订单的罐头类型为"+canName,
                                "您輸入的該子訂單的罐頭類型為"+canName,
                                "The canned food type of this sub-order you entered is"+canName
                        );
                        canPrice = CanInfoController.getInstance().getCanPriceByName(CanInfoController.getInstance().getCanList().get(1));
                        break;
                    }
                    else if(Objects.equals(canType,"3")){
                        canName = CanInfoController.getInstance().getCanList().get(2);
                        OutputManager.getInstance().print(
                                "您输入的该子订单的罐头类型为"+canName,
                                "您輸入的該子訂單的罐頭類型為"+canName,
                                "The canned food type of this sub-order you entered is"+canName
                        );
                        canPrice = CanInfoController.getInstance().getCanPriceByName(CanInfoController.getInstance().getCanList().get(2));
                        break;
                    }
                    else if(Objects.equals(canType,"4")){
                        canName = CanInfoController.getInstance().getCanList().get(3);
                        OutputManager.getInstance().print(
                                "您输入的该子订单的罐头类型为"+canName,
                                "您輸入的該子訂單的罐頭類型為"+canName,
                                "The canned food type of this sub-order you entered is"+canName
                        );
                        canPrice = CanInfoController.getInstance().getCanPriceByName(CanInfoController.getInstance().getCanList().get(3));
                        break;
                    }
                    else
                     {
                        OutputManager.getInstance().errorMassage(
                                "输入了错误的罐头类型！请重新输入！",
                                "輸入了錯誤的罐頭類型！請重新輸入！",
                                "The wrong type of can was entered! please enter again!"
                        );
                    }
                }
                OutputManager.getInstance().print(
                        "请输入该子订单罐头需要的数量:",
                        "請輸入該子訂單罐頭需要的數量:",
                        "Please enter the quantity required for this sub-order can:"
                );
                String canCount;
                Integer canCountOfInt;
                Scanner scanner = new Scanner(System.in);
                while(true) {
                    //获取对应的价格
                    while(true) {
                        canCount = scanner.next();
                        //使用正则表达式判断字符串内是否是数字
                        Pattern pattern = Pattern.compile("[0-9]*");
                        Matcher isNum = pattern.matcher(canCount);
                        if(!isNum.matches()){
                            OutputManager.getInstance().errorMassage(
                                    "您输入了错误的字符！请输入数字！",
                                    "您輸入了錯誤的字符！ 請輸入號碼！",
                                    "You entered the wrong character! Please enter the number!"
                            );
                            continue;
                        }
                        break;
                    }
                    canCountOfInt = Integer.parseInt(canCount);
                    if(canCountOfInt <= 0){
                        OutputManager.getInstance().errorMassage(
                                "您输入了错误的罐头数量！请重新输入！",
                                "您輸入了錯誤的罐頭數量！請重新輸入！",
                                "You have entered the wrong quantity of cans! please enter again!"
                        );
                        continue;
                    }
                    break;
                }
                OrderCanInformation orderCanInformation = new OrderCanInformation(canName, canCountOfInt,canPrice);
                orderCanInformationArrayList.add(orderCanInformation);
                //加入一个新的订单罐头信息
                boolean loopFlag = false;
                while (true){
                    OutputManager.getInstance().print(
                            "是否继续加入子订单？y表示是，n表示否：",
                            "是否繼續加入子訂單？ y表示是，n表示否：",
                            "Do you want to continue to add sub-orders? y means yes, n means no:"
                    );
                    String inputChr = scanner.next();
                    inputChr = inputChr.toLowerCase();//先转化为小写
                    if (inputChr.equals("y")) {
                        loopFlag = true;
                        OutputManager.getInstance().print(
                                "继续创建新的子订单。",
                                "繼續創建新的子訂單。",
                                "Continue to create new sub-orders."
                        );
                        break;
                    } else if (inputChr.equals("n")) {
                        OutputManager.getInstance().print(
                                "订单创建完成。",
                                "訂單創建完成。",
                                "Order creation completed."
                        );
                        break;
                    } else {
                        OutputManager.getInstance().errorMassage(
                                "输入错误.请重新输入！",
                                "輸入錯誤.請重新輸入！",
                                "Input errors, please re-enter!"
                        );
                    }
                }
                if(!loopFlag){
                    break;
                }
            }
            OutputManager.getInstance().print(
                    "请输入该订单最晚完成的时间，以'yyyy-MM-dd'的方式输入：",
                    "請輸入該訂單最晚完成的時間，以'yyyy-MM-dd'的方式輸入：",
                    "Please enter the latest completion time of the order, in the form of'yyyy-MM-dd':"
            );
            String latestDeliveryTime;
            while(true) {
                latestDeliveryTime = new Scanner(System.in).next();
                //判断输入的日期是否符合条件的正则表达式
                if (!isDate(latestDeliveryTime)){
                    OutputManager.getInstance().errorMassage(
                            "您输入的日期格式有误？请重新输入！",
                            "您輸入的日期格式有誤？請重新輸入！",
                            "The date format you entered is wrong? please enter again!"
                    );
                    continue;
                }
                //需要判断输入的日期是否晚于当前的日期
                if(!laterThanNowDate(latestDeliveryTime)){
                    OutputManager.getInstance().errorMassage(
                            "您输入的日期不能早于当前日期！请重新输入！",
                            "您輸入的日期不能早於當前日期！請重新輸入！",
                            "The date you entered cannot be earlier than the current date! please enter again!"
                    );
                    continue;
                }
                break;
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(latestDeliveryTime);
            OutputManager.getInstance().print(
                    "请输入该订单的运送地址：",
                    "請輸入該訂單的運送地址：",
                    "Please enter the shipping address of this order:"
            );
            String customerAddress = new Scanner(System.in).next();

            Coupon coupon = new Coupon(new TwentyPercentOff());
            OrderCenter.getInstance().createOneOrder(orderCanInformationArrayList, coupon, date, customerAddress);

            boolean loopFlag = false;
            for(;;) {
                OutputManager.getInstance().print(
                        "是否继续创建新的订单？y表示是，n表示否",
                        "是否繼續創建新的訂單？ y表示是，n表否",
                        "Do you want to continue to create new orders? y means yes, n means no."
                );
                String inputChoice = new Scanner(System.in).next();
                inputChoice = inputChoice.toLowerCase();
                if (inputChoice.equals("y")) {
                    loopFlag = true;
                    OutputManager.getInstance().print(
                            "继续创建订单。",
                            "繼續創建訂單。",
                            "Continue to create an order."
                    );
                    break;
                } else if (inputChoice.equals("n")) {
                    loopFlag = false;
                    OutputManager.getInstance().print(
                            "订单创建结束",
                            "訂單創建結束",
                            "End of order creation."
                    );
                    break;
                } else {
                    OutputManager.getInstance().errorMassage(
                            "输入错误！请重新输入！",
                            "輸入錯誤！請重新輸入！",
                            "input error! please enter again!"
                    );
                }
            }
            if(!loopFlag)
                break;
        }
        OrderCenter.getInstance().displayOrderData();//显示当前所有订单的数据

        //订单创建完毕，调用中介者处理订单
        //获取待处理的订单列表
        ArrayList<Order> pendingOrder = DepartmentMediator.getInstance().getPendingOrders();
        return pendingOrder;
    }


    //判断数日的字符串是否符合日期的格式
    public boolean isDate(String dateStr){
        String regularExpression = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";
        return(dateStr.matches(regularExpression));
    }

    //判断输入的日期是否晚于当前日期
    public boolean laterThanNowDate(String dateStr) {
        boolean flag = false;
        Date nowDate = new Date();
        Date newDate = null;
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        //在日期字符串非空时
        if (dateStr != null && !"".equals(dateStr)) {
            //将字符串转化为日期对象，若为非法日期就会抛出异常
            try {
                newDate = sdf.parse(dateStr);
                flag = newDate.after(nowDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }
}