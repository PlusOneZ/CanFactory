package Mutex;


import Management.BaseWorker;
import Management.HumanResources.Staff.Worker;
import Manufacturing.Machine.Machine;
import Presentation.Protocol.OutputManager;

/**
 * 互斥量模式
 * 机器互斥锁
 * 对于某些机器，同一时间只有一批工人可以使用，使用结束之后才能换下一批
 *
 * @author 吴英豪
 */
public class MachineMutex implements Mutex {

    public MachineMutex() {
    }

    /**
     * 工人申请机器
     *
     * @param applicant 申请者
     * @param machine   正在申请的机器
     * @return 是否有资格使用此机器
     */
    public boolean acquire(BaseWorker applicant, Machine machine) {
        if ((machineOwner == null) || (lockedMachine == null)) {
            machineOwner = applicant;
            lockedMachine = machine;
            OutputManager.getInstance().print(
                    "申请成功!",
                    "申請成功!",
                    "application approved!");
            return true;
        }
        OutputManager.getInstance().print(
                "此机器正在使用中，无法申请。",
                "此機器正在使用中，無法申請。",
                "This machine is in use and cannot be applied for.");
        return false;
    }

    @Override
    public void release() {
        machineOwner = null;
        lockedMachine = null;
    }

    /**
     * 获取当前锁的拥有者
     *
     * @return 锁的拥有者
     */
    public BaseWorker getOwner() {
        return machineOwner;
    }

    /**
     * 获取当前正在使用中的机器
     *
     * @return 被使用的机器
     */
    public Machine getMachine() {
        return lockedMachine;
    }

    // 锁的拥有者
    private BaseWorker machineOwner;

    // 被锁住的机器
    private Machine lockedMachine;

}
