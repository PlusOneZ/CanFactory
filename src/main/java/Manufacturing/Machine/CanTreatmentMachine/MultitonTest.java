package Manufacturing.Machine.CanTreatmentMachine;

import Manufacturing.Machine.CanMachine;
import Presentation.Protocol.IOManager;

/**
 * 多例模式测试类
 *
 * @author 卓正一
 * @since 2021/11/2 3:14 PM
 */
public class MultitonTest {

    /**
     * 多例测试
     *
     * @author 卓正一
     * @since 2021-10-31 1:49 AM
     */
    public static void main(String[] args) {
        IOManager.getInstance().printBrief(
                "---多例模式测试---",
                "---多例模式測試---",
                "---Multiton Pattern Test---"
        );
        IOManager.getInstance().printBrief(
                "尝试获取两次铁罐头处理机器。",
                "嘗試獲取兩次鐵罐頭處理機器。",
                "Trying to fetch iron can processing machine twice."
        );
        CanMachine machine = IronCanProducingMachine.getInstance();
        CanMachine machine1 = IronCanProducingMachine.getInstance();
        IOManager.getInstance().printBrief(
                "判断两个机器是否是同一个：",
                "判斷兩個機器是否是同一個：",
                "Determine whether the two machines are the same: "
        );
        IOManager.getInstance().printLanguageIrrelevantContent(Boolean.toString(machine == machine1));
        IOManager.getInstance().printBrief(
                "---多例模式测试结束---",
                "---多例模式測試結束---",
                "---Multiton Pattern Test End---"
        );
    }
}
