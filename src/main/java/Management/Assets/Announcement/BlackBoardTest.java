package Management.Assets.Announcement;

import Management.HumanResources.Staff.Announcer;
import Management.HumanResources.Staff.Cleaner;
import Management.HumanResources.Staff.SecurityStaff;

/**
 * 黑板模式测试类
 * @author 汪明杰
 * @date 2021/10/24 23:29
 */
public class BlackBoardTest {
    public static void main(String[] args) {
        Cleaner staff1 = new Cleaner("李华");
        staff1.subscribe();
        Announcer.getInstance().addMessage("今日特供午饭铁板烧");

        SecurityStaff staff2 = new SecurityStaff("王平");
        staff2.subscribe();
        Announcer.getInstance().addMessage("生产千万条，安全第一条");

        Cleaner staff3 = new Cleaner("张三");
        staff3.subscribe();
        Announcer.getInstance().addMessage("国庆快乐");

    }
}
