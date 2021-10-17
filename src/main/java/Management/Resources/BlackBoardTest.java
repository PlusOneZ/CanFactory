package Management.Resources;

import Management.Resources.Staff.Staff;
import Presentation.Protocol.OutputManager;

/**
 *
 * 黑板模式测试类
 * @author 汪明杰
 * @date 2021/10/11 23:29
 */
public class BlackBoardTest {
    public static void main(String[] args) {
        OutputManager.getInstance().setLanguage(OutputManager.Lang.zh_CN);
        Staff staff1 = new Staff("李华");
        Staff staff2 = new Staff("王平");
        Staff staff3 = new Staff("张三");
        staff1.sendMessage("今日特供午饭铁板烧");
        staff2.sendMessage("生产千万条，安全第一条");
        staff3.sendMessage("国庆快乐");
    }
}
