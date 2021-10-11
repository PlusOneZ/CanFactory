package Management.Resources.Staff;

import Management.Resources.Announcement;
import Presentation.Protocol.OutputManager;

/**
 * 员工基类
 * @author 汪明杰
 */
public class Staff {


    //员工姓名
    String name;


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
        Announcement.getInstance().addMessage(this,message);
    }

    //员工接受消息
    public void getMessage(String message){
        System.out.println("员工["+this.name+"]接受消息："+message);
        OutputManager.getInstance().print(
                "员工["+this.name+"]接受消息："+message,
                "員工"+"]接受消息："+message,
                "Staff["+this.name+"] receives the message:"+message
        );
    }


}
