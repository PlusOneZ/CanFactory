package Mutex;

import Management.BaseWorker;
import Management.HumanResources.CannedWorker;
import Manufacturing.Machine.GeneralMachine.CleanMachine;
import Presentation.Protocol.OutputManager;

/**
 * 互斥量模式测试类
 *
 * @author 吴英豪
 * @since 2021/10/27 08:43
 */
public class MutexTest {
    public static void main(String[] args) {
        MachineMutex mutex = new MachineMutex();
        CleanMachine machine = new CleanMachine();

        OutputManager.getInstance().print(
                "工作开始了,有两个工人想要申请使用同一台机器......",
                "工作開始了,有兩個工人想要申請使用同一臺機器......",
                "Work begins and two workers wanted to apply to use the same machine......"
        );
        BaseWorker worker1 = new CannedWorker();
        BaseWorker worker2 = new CannedWorker();

        OutputManager.getInstance().print(
                "1号工人申请使用此机器......",
                "1號工人申請使用此機器......",
                "worker1 wants to use this machine......"
        );
        mutex.acquire(worker1,machine);

        OutputManager.getInstance().print(
                "2号工人申请使用此机器......",
                "2號工人申請使用此機器......",
                "worker2 wants to use this machine......"
        );
        mutex.acquire(worker2,machine);
    }
}
