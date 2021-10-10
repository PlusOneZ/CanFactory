package Management.Resources.Staff;

import Management.QuantityTesting.FactoryVisitor;
import Management.Resources.Announcement;

/**
 * 员工基类
 * @author 汪明杰
 */
public class Staff {
    //公告栏
    Announcement announcement;

    //员工姓名
    String name;

    //构造函数
    public Staff(String name, Announcement announcement) {
        this.name = name;
        this.announcement=announcement;
    }

    public Staff(){

    }

    public Staff(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }


    //员工发送消息
    public void sendMessage(String message){
        this.announcement.addMessage(this,message);
    }

    //员工接受消息
    public void getMessage(String message){
        System.out.println("员工["+this.name+"]接受消息："+message);
    }

    //public abstract void accept(FactoryVisitor visitor);
}
