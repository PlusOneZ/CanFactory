package Management.HumanResources;


import Presentation.Protocol.OutputManager;

/**
 * 员工请假的请求
 * <b>实现了 Chain of Responsibility 模式</b>
 * @author 尚丙奇
 * @date 2021-10-16 14:00
 */
public class LeaveRequest {

    /**
     * 请假者的姓名
     */
    private String name;

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
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String toString(OutputManager.Lang lang) {
        if(lang == OutputManager.Lang.en){
            return "[" + name + "]Asked for leave for" + days + "days, because of" + reason +". The approval result is" + approveStatus;
        }
        else if(lang == OutputManager.Lang.zh_CN){
            return "【" + name + "】请假" + days + "天，原因：" + reason + "，审批结果：" + approveStatus;
        }
        else if(lang == OutputManager.Lang.zh_TW){
            return "【" + name + "】請假" + days + "天，原因：" + reason + "，審批結果：" + approveStatus;
        }
        else {
            return "The specific language is not supported.";
        }
    }

}
