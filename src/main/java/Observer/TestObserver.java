package Observer;

import Marketing.Order;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;

public class TestObserver {

    public static void main(String[] args) throws ParseException {
        OrderData orderData = new OrderData();
        OrderDisplayCenter oD1 = new OrderDisplayCenter(orderData,"订单中心1号");

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd/HH:mm:ss");
        Date comDate = dateFormat.parse("2021/12/12/12:23:53");
        Order order = new Order("水果罐头",199,comDate);
        orderData.getNewOrderData(order);

    }}
