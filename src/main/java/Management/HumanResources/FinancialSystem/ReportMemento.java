package Management.HumanResources.FinancialSystem;

import Management.HumanResources.Staff.Auditor;

import java.util.Date;

/**
 * 审阅历史备忘录record，包含审阅人以及审阅时间
 *
 * @author mount_potato
 * @since 2021/10/28 11:02 下午
 */

public record ReportMemento(Auditor auditorState, Date dateState) {

    /**
     * 获取审阅者状态
     */
    public Auditor getAuditorState() {
        return auditorState;
    }

    /**
     * 获取日期状态
     */
    public Date getDateState() {
        return dateState;
    }


}