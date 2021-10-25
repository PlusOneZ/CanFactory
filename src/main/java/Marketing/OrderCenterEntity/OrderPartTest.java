package Marketing.OrderCenterEntity;

import Marketing.OrderEnity.Order;
import Marketing.OrderEnity.OrderAmount;
import Marketing.OrderEnity.OrderCanInformation;
import Marketing.Promotion.Coupon;
import Marketing.Promotion.Sale.TwentyPercentOff;
import Presentation.Protocol.OutputManager;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * 从下单到订单中心到订单处理中心的测试类
 * @author 梁乔
 * @date 2021/10/24 10:38 
 */
public class OrderPartTest {
    //首先，创建若干订单
    public static void main(String[] args) throws ParseException {
        OutputManager.getInstance().setLanguage(OutputManager.Lang.zh_CN);
        System.out.println("请输入创建订单相关信息。");
        for(;;) {
            ArrayList<OrderCanInformation> orderCanInformationArrayList = new ArrayList<OrderCanInformation>();
            for (; ; ) {
                String canName = new String();
                for (; ; ) {
                    System.out.println("输入需要的订单罐头类型，1表示水果罐头，2表示蔬菜罐头。");
                    Scanner inputScanner = new Scanner(System.in);
                    Integer canType = inputScanner.nextInt();
                    if (canType == 1) {
                        canName = "水果罐头";
                        System.out.println("您输入的该子订单的罐头类型为水果罐头");
                        break;
                    } else if (canType == 2) {
                        canName = "蔬菜罐头";
                        System.out.println("您输入的该子订单的罐头类型为蔬菜罐头");
                        break;
                    } else {
                        System.out.println("输入了错误的罐头类型！请重新输入！");
                        continue;
                    }
                }
                System.out.println("请输入该子订单罐头需要的数量:");
                Scanner scanner = new Scanner(System.in);
                Integer canCount = scanner.nextInt();
                //获取对应的价格
                OrderCanInformation orderCanInformation = new OrderCanInformation(canName, canCount,99);
                orderCanInformationArrayList.add(orderCanInformation);
                //加入一个新的订单罐头信息
                System.out.println("是否继续加入子订单？y表示是，n表示否：");
                String inputChr = scanner.next();
                if (inputChr.equals("y")) {
                    continue;
                } else if (inputChr.equals("n")) {
                    System.out.println("该订单创建完成");
                    break;
                } else {
                    System.out.println("输入错误。订单创建完成");
                    break;
                }
            }
            System.out.println("请输入该订单最晚完成的时间，以'yyyy-MM-dd'的方式输入：");
            String latestDeliveryTime = new Scanner(System.in).next();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(latestDeliveryTime);
            System.out.println("请输入该订单的运送地址：");
            String customerAddress = new Scanner(System.in).next();

            Coupon coupon = new Coupon(new TwentyPercentOff());
            OrderCenter.getInstance().createOneOrder(orderCanInformationArrayList, coupon, date, customerAddress);

            System.out.println("是否继续创建新的订单？y表示是，n表示n");
            String inputChoice = new Scanner(System.in).next();
            if(inputChoice.equals("y")){
                System.out.println("继续创建订单。");
                continue;
            }
            else if(inputChoice.equals("n")){
                System.out.println("订单创建结束");
                break;
            }
            else {
                System.out.println("输入错误。订单创建结束");
            }
        }
        OrderCenter.getInstance().displayOrderData();//显示当前所有订单的数据
        }




    }

