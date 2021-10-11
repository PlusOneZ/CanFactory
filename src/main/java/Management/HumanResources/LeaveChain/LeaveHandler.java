package Management.HumanResources.LeaveChain;

/**
 * LeaveHandler类：所有处理者类的基类，实现了责任链模式的处理请求机制
 * <b>责任链模式的一部分</b>
 * @author 陈垲昕
 * @since 2021/10/11 9:37 下午
 */

public abstract class LeaveHandler {
    /**
     * 请假请求处理者的下一个处理者，当本处理者没有权限处理该请求时，呈递给下一个
     */
    private LeaveHandler nextHandler;


    /**
     * 设置下一个处理者，在责任链建立时调用该方法以建立完整的责任链
     * @param handler :  下一个处理者
     * @author 陈垲昕
     * @since 2021-10-11 10:22 下午
     */
    public void setNextHandler(LeaveHandler handler){this.nextHandler=handler;}

    /**
     * 获取当前处理者所能处理的请求等级
     * @return : int 处理者所能处理的请求等级
     * @author 陈垲昕
     * @since 2021-10-11 10:23 下午
     */
    protected abstract int getHandlerLevel();

    /**
     * 响应请求的方法，每个调用者必须实现不同的响应请求的方法
     * @param request : 处理的请求
     * @author 陈垲昕
     * @since 2021-10-11 10:24 下午
     */
    protected abstract void echoRequest(LeaveRequest request);


    /**
     * 核心方法：处理请假请求，调用时从责任链第一个处理者开始调用，如果处理等级不匹配便递归调用
     * @param request : 待处理的请求
     * @author 陈垲昕
     * @since 2021-10-11 10:25 下午
     */
    public final void handleLeaveRequest(LeaveRequest request){

        //如果处理级别匹配
        if(this.getHandlerLevel()==request.getLeaveRequestLevel()){
            //执行request获取数据
            this.echoRequest(request);
        }else{
            //处理级别不匹配，判断是否有下一个处理者
            if(this.nextHandler!=null){
                this.nextHandler.handleLeaveRequest(request);
            }else{
                //没有处理者，这里执行自定义操作
                System.out.println("没有可以处理该请假等级的处理者");
            }

        }
    }

}
