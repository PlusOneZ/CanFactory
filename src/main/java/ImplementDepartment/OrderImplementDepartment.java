package
        ImplementDepartment;

import Marketing.OrderCenterEntity.OrderCenter;
import Marketing.OrderEnity.Order;
import Marketing.OrderEnity.OrderCanInformation;
import Marketing.Promotion.Coupon;
import Marketing.Promotion.Sale.TwentyPercentOff;
import Mediator.DepartmentMediator;
import Presentation.Protocol.OutputManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

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
        for(;;) {
            ArrayList<OrderCanInformation> orderCanInformationArrayList = new ArrayList<OrderCanInformation>();
            for (; ; ) {
                String canName = new String();
                for (; ; ) {
                    OutputManager.getInstance().print(
                            "输入需要的订单罐头类型，1表示水果罐头，2表示蔬菜罐头。",
                            "輸入需要的訂單罐頭類型，1表示水果罐頭，2表示蔬菜罐頭。",
                            "Enter the type of canned food required for the order. 1 means canned fruit and 2 means canned vegetable."
                    );
                    Scanner inputScanner = new Scanner(System.in);
                    Integer canType = inputScanner.nextInt();
                    if (canType == 1) {
                        canName = "水果罐头";
                        OutputManager.getInstance().print(
                                "您输入的该子订单的罐头类型为水果罐头。",
                                "您輸入的該子訂單的罐頭類型為水果罐頭。",
                                "The canned food type of the sub-order you entered is fruit can."
                        );
                        break;
                    } else if (canType == 2) {
                        canName = "蔬菜罐头";
                        OutputManager.getInstance().print(
                                "您输入的该子订单的罐头类型为蔬菜罐头。",
                                "您輸入的該子訂單的罐頭類型為蔬菜罐頭。",
                                "The canned food type of this sub-order you entered is vegetable can."
                        );
                        break;
                    } else {
                        OutputManager.getInstance().errorMassage(
                                "输入了错误的罐头类型！请重新输入！",
                                "輸入了錯誤的罐頭類型！請重新輸入！",
                                "The wrong type of can was entered! please enter again!"
                        );
                        continue;
                    }
                }
                OutputManager.getInstance().print(
                        "请输入该子订单罐头需要的数量:",
                        "請輸入該子訂單罐頭需要的數量:",
                        "Please enter the quantity required for this sub-order can:"
                );
                Scanner scanner = new Scanner(System.in);
                Integer canCount = scanner.nextInt();
                //获取对应的价格
                OrderCanInformation orderCanInformation = new OrderCanInformation(canName, canCount,99);
                orderCanInformationArrayList.add(orderCanInformation);
                //加入一个新的订单罐头信息
                boolean loopFlag = false;
                for(;;) {
                    OutputManager.getInstance().print(
                            "是否继续加入子订单？y表示是，n表示否：",
                            "是否繼續加入子訂單？ y表示是，n表示否：",
                            "Do you want to continue to add sub-orders? y means yes, n means no:"
                    );
                    String inputChr = scanner.next();
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
                        continue;
                    }
                }
                if(loopFlag == true){
                    continue;
                }
                else {
                    break;
                }
            }
            OutputManager.getInstance().print(
                    "请输入该订单最晚完成的时间，以'yyyy-MM-dd'的方式输入：",
                    "請輸入該訂單最晚完成的時間，以'yyyy-MM-dd'的方式輸入：",
                    "Please enter the latest completion time of the order, in the form of'yyyy-MM-dd':"
            );
            String latestDeliveryTime = new Scanner(System.in).next();

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
                    continue;
                }
            }
            if(loopFlag == false)
                break;
            else
                continue;
        }
        OrderCenter.getInstance().displayOrderData();//显示当前所有订单的数据


        //订单创建完毕，调用中介者处理订单
        //获取待处理的订单列表
        ArrayList<Order> pendingOrder = DepartmentMediator.getInstance().getPendingOrders();
        return pendingOrder;
    }
}