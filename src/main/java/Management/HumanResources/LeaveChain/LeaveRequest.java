package Management.HumanResources.LeaveChain;

/**
 * LeaveRequest类：请假请求，由要请假的人员提起
 * <b>责任链模式的一部分</b>
 * @author 陈垲昕
 * @since 2021/10/11 10:07 下午
 */

public class LeaveRequest {

    /**
     * 处理等级
     */
    int level;

    /**
     * level的构造函数
     * @param level : 所想要设置的处理等级
     * @author 陈垲昕
     * @since 2021-10-11 10:40 下午
     */
    public LeaveRequest(int level){this.level=level;}

    /**
     * 获取当前请求的处理等级
     * @return : int 当前处理登记
     * @author 陈垲昕
     * @since 2021-10-11 10:41 下午
     */
    public int getLeaveRequestLevel(){return this.level;}

    /**
     * 设置当前请求的处理等级
     * @param level :  等级
     * @author 陈垲昕
     * @since 2021-10-11 11:26 下午
     */
    public void setLeaveRequestLevel(int level){this.level=level;}

}
