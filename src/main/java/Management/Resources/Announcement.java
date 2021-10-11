package Management.Resources;

import Management.Resources.Staff.Staff;
import Presentation.Protocol.OutputManager;

import java.util.ArrayList;

/**
 * 工厂每天的公告栏
 * 单例模式
 * @author 汪明杰
 */
public class Announcement {
    // 写状态位
    private Boolean readingState;

    //消息栏
    private ArrayList<String> news;

    //接受消息的读者
    private ArrayList<Staff> readers = null;

    //单例模式
    private static Announcement announcement;

    private Announcement(){
        System.out.println("# 使用黑板模式(Blackboard)");
        this.readingState = false;
        this.news=new ArrayList<String>();
        this.readers=new ArrayList<Staff>();
        this.news.add("[公告栏已经上线了，欢迎大家积极阅读哦~]");
    }

    public static Announcement getInstance(){
        if(Announcement.announcement == null){
            Announcement.announcement = new Announcement();
        }
        return Announcement.announcement;
    }

    public void addMessage(Staff writer, String newMessage){
        if (this.readingState){
            OutputManager.getInstance().errorMassage(
                    "当前正在推送消息！",
                    "當前正在推送消息！",
                    "Currently pushing messages!"
            );
            return;
        }
        this.readingState = true;
        this.news.add("["+newMessage+"]");

        System.out.println("[公告栏]开始推送消息："+newMessage);
        //向所有读者推送消息
        for(Staff reader:readers){
            reader.getMessage(newMessage);
        }

        //读者转换为写者
        this.readers.add(writer);
        this.readingState = false;
    }

    public static void main(String[] args) {
        Staff staff1 = new Staff("李华");
        Staff staff2 = new Staff("王平");
        Staff staff3 = new Staff("张三");
        staff1.sendMessage("今日特供午饭铁板烧");
        staff2.sendMessage("生产千万条，安全第一条");
        staff3.sendMessage("国庆快乐");
    }


}
