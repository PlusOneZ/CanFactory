package Management.HumanResources.Staff;

import Management.HumanResources.BaseEmployee;
import Management.HumanResources.DepartmentType;
import Presentation.Protocol.IOManager;

import java.util.ArrayList;

/**
 * 广播员
 * 单例模式（Singleton)
 * @author 汪明杰
 * @date 2021/10/24 15:02
 */
public class Announcer extends Staff{

    // 发送消息状态
    private Boolean sendingState = false;

    // 消息栏
    private ArrayList<String> news;

    //接受消息的读者
    private ArrayList<BaseEmployee> readers = null;

    //单例模式广播员
    private static Announcer announcer = null;

    /**
     * 构造函数
     * @author 汪明杰
     * @since 2021-10-21 9:03 上午
     */
    private Announcer(){
        super.department= DepartmentType.Backup;
        this.readers = new ArrayList<>();
        this.news = new ArrayList<>();
    }


    /**
     * 单例模式获取实例
     * @return Announcer
     */
    public static Announcer getInstance(){
        if (Announcer.announcer == null){
            Announcer.announcer = new Announcer();
        }
        return Announcer.announcer;
    }

    @Override
    public void addSubscriber(BaseEmployee baseEmployee){
        IOManager.getInstance().print(
                "# 使用代理模式",
                "# 使用代理模式",
                "# Using Proxy Pattern"
        );


        if(this.readers.contains(baseEmployee)){
            IOManager.getInstance().errorMassage(
                    "该员工已订阅公告！",
                    "該員工已訂閱公告！",
                    "This employee has subscribed to the announcement!"
            );
        }
        else{
            this.readers.add(baseEmployee);
        }
    }


    /**
     * 广播员发送消息
     * @param newMessage
     */
    @Override
    public void addMessage(String newMessage) {
        IOManager.getInstance().print(
                "# 使用代理模式",
                "# 使用代理模式",
                "# Using Proxy Pattern"
        );

        IOManager.getInstance().print(
                "# 使用黑板模式",
                "# 使用黑板模式",
                "# Using Blackboard Pattern"
        );

        if (this.sendingState){
            IOManager.getInstance().errorMassage(
                    "当前正在推送消息！",
                    "當前正在推送消息！",
                    "Currently pushing messages!"
            );
            return;
        }
        this.sendingState = true;
        this.news.add("["+newMessage+"]");

        IOManager.getInstance().print(
                "[公告栏]开始推送消息："+newMessage,
                "[公告欄]開始推送消息："+newMessage,
                "[Blackboard] Start to push the message:"+newMessage
        );

        //向所有读者推送消息
        for(BaseEmployee reader:readers){
            reader.getMessage(newMessage);
        }

        this.sendingState = false;

    }
}
