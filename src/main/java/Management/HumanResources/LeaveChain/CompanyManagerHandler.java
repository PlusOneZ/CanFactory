package Management.HumanResources.LeaveChain;

/**
 * 总经理所拥有的请假处理器
 * <b>责任链模式的一部分</b>
 * @author 陈垲昕
 * @since 2021/10/11 10:19 下午
 */

public class CompanyManagerHandler extends LeaveHandler{

    /**
     * 总经理处理请假请求的等级
     * @return : int 等级
     * @author 陈垲昕
     * @since 2021-10-11 10:43 下午
     */
    @Override
    protected int getHandlerLevel() {
        return 3;
    }

    /**
     * 部门经理处理请假请求的动作，当request的等级匹配部门经理应该处理的等级
     * @param request : 所处理的请求
     * @author 陈垲昕
     * @since 2021-10-11 10:44 下午
     */
    @Override
    protected void echoRequest(LeaveRequest request) {
        System.out.println("总经理审批并同意了这个请求");
    }
}
