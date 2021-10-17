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
        OutputManager.getInstance().print(
                "# 使用黑板模式",
                "# 使用黑板模式",
                "# Using Blackboard mode"
        );
        this.readingState = false;
        this.news= new ArrayList<>();
        this.readers= new ArrayList<>();
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

        OutputManager.getInstance().print(
                "[公告栏]开始推送消息："+newMessage,
                "[公告欄]開始推送消息："+newMessage,
                "[Blackboard] Start to push the message:"+newMessage
        );
        
        //向所有读者推送消息
        for(Staff reader:readers){
            reader.getMessage(newMessage);
        }

        //读者转换为写者
        this.readers.add(writer);
        this.readingState = false;
    }




}
