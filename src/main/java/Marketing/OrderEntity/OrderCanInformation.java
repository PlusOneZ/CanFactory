package Marketing.OrderEntity;

/**
 * @Author 王立友
 * 该类为订单中关于罐头的部分信息内容设计
 * 订单中的罐头信息不能通过CanEntity来直接表示
 * 用户在选择罐头的种类后，应当构建一份OrderCanInformation
 * 包含对应罐头的id,name,count
 */

public class OrderCanInformation {

    //建立orderCanInformation与can之间联系的罐头种类
    private String canType;

    //订单中描述罐头的名称信息
    private String canName;

    //订单中该罐头的数量
    private int count;

    public OrderCanInformation(String canType, String canName, int count){
        this.canType = canType;
        this.canName = canName;
        this.count = count;
    }

    public String getCanType() {
        return canType;
    }
    public String getCanName(){
        return canName;
    }
    public int getCount() {
        return count;
    }

    public void setCanName(String canName) {
        this.canName = canName;
    }

    public void setCanType(String canType) {
        this.canType = canType;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
