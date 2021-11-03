package Management.Assets.Announcement;

import Management.HumanResources.BaseEmployee;
import Presentation.Protocol.IOManager;

/**
 * 公告栏管理
 * 代理模式（Proxy）、黑板模式（BlackBoard)
 */
public interface AnnouncementManager {
    default void addMessage(String newMessage){
        IOManager.getInstance().print(
                "# 使用代理模式",
                "# 使用代理模式",
                "# Using Proxy Pattern"
        );

        IOManager.getInstance().errorMassage(
                "该员工没有权限发送公告！",
                "該員工沒有許可權發送公告！",
                "This employee does not have permission to send announcement!"
        );
    }

    /**
     * 该get函数为员工.getMessage()
     * @param message
     */
    void getMessage(String message);

    /**
     * 该函数为员工所执行函数
     */
    void subscribe();

    default void addSubscriber(BaseEmployee baseEmployee){
        IOManager.getInstance().print(
                "# 使用代理模式",
                "# 使用代理模式",
                "# Using Proxy Pattern"
        );

        IOManager.getInstance().errorMassage(
                "该员工没有权限添加订阅者！",
                "該員工沒有許可權添加訂閱者！",
                "This employee does not have permission to add subscribers!"
        );
    }
}
