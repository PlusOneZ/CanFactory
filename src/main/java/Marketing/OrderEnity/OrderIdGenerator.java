package Marketing.OrderEnity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
* 订单编号的ID生成器
* @author 梁乔
* @date 2021-10-15 11:00
*/
public class OrderIdGenerator {

    /**
    * 获取当前时间的字符串
     * @param sformat : 获取时间的格式
     * @return : java.lang.String
    * @author 梁乔
    * @date 11:03 2021-10-15
    */
    public static String getDate(String sformat) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(sformat);
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
    * 获取随机数
     * @param num : 随机数的位数
     * @return : java.lang.String
    * @author 梁乔
    * @date 11:03 2021-10-15
    */
    public static String getRandomNum(int num){
        String numStr = "";
        for(int i = 0; i < num; i++){
            numStr += (int)(10*(Math.random()));
        }
        return numStr;
    }

    /**
    * 生成订单的ID
     * @return : java.lang.Long
    * @author 梁乔
    * @date 11:04 2021-10-15
    */
    public static Long getGeneratID(){
        String sformat = "MMddhhss";
        int num = 3;
        String idStr = getDate(sformat) + getRandomNum(num);
        Long id = Long.valueOf(idStr);
        return id;
    }
}