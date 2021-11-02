package Management.HumanResources;


import Presentation.Protocol.IOManager;

/**
 * 员工请假的请求
 * <b>实现了 Chain of Responsibility 模式</b>
 * @author 尚丙奇
 * @since 2021-10-16 14:00
 */
public class LeaveRequest {

    /**
     * 请假者
     */
    protected BaseEmployee requestee;

    /**
     * 请假天数
     */
    private Integer days;

    /**
     * 请假原因
     */
    private String reason;

    /**
     * 请假状态
     */
    private String approveStatus = "待审批";

    public String getName() {
        return requestee.getName();
    }

    public BaseEmployee getRequestee() {
        return requestee;
    }

    public void setRequestee(BaseEmployee requestee) {
        this.requestee = requestee;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(String approveStatus) {
        this.approveStatus = approveStatus;
    }

    public String toString(IOManager.Lang lang) {
        if(lang == IOManager.Lang.en){
            return "[" + requestee.getName() + "]Asked for leave for" + days + "days, because of" + reason +". The approval result is" + approveStatus;
        }
        else if(lang == IOManager.Lang.zh_CN){
            return "【" + requestee.getName() + "】请假" + days + "天，原因：" + reason + "，审批结果：" + approveStatus;
        }
        else if(lang == IOManager.Lang.zh_TW){
            return "【" + requestee.getName() + "】請假" + days + "天，原因：" + reason + "，審批結果：" + approveStatus;
        }
        else {
            return "The specific language is not supported.";
        }
    }

}
