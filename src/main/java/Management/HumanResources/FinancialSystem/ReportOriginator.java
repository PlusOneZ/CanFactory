package Management.HumanResources.FinancialSystem;

import Management.HumanResources.Staff.Auditor;
import Presentation.Protocol.OutputManager;

import java.util.Date;

/**
 * 审阅报告历史记录器，根据审阅者信息以及审阅时间生成用于存储的memento
 * <b>备忘录模式的一部分</b>
 * @author 陈垲昕
 * @since 2021/10/29 8:40 下午
 */

public class ReportOriginator {

    /**
     * 全局单例
     */
    static private ReportOriginator instance;

    /**
     * 审阅者
     */
    private Auditor auditorState;

    /**
     * 审阅时间
     */
    private Date dateState;

    /**
     * 私有构造
     */
    private ReportOriginator(){
        auditorState=null;
        dateState=null;
    }

    /**
     * 获取全局单例
     */
    public static ReportOriginator getInstance(){
        if(instance==null){
            instance=new ReportOriginator();
        }
        return instance;
    }


    /**
     * 设置Originator当前状态
     * @param auditor :  审阅者
     * @param date :   审阅日期
     * @author 陈垲昕
     * @since 2021-10-29 9:35 下午
     */
    public void setState(Auditor auditor,Date date){
        this.auditorState=auditor;
        this.dateState=date;
    }


    /**
     * 根据审阅者信息以及审阅时间生成用于存储的memento
     * @return : Management.HumanResources.FinancialSystem.ReportMemento 生成的Memento
     * @author 陈垲昕
     * @since 2021-10-29 9:35 下午
     */
    public ReportMemento saveStateToMemento(){
        return new ReportMemento(auditorState,dateState);
    }

    /**
     * 从memento中覆写状态信息
     * @param memento :  要获取的历史记录备忘录信息
     * @author 陈垲昕
     * @since 2021-10-29 9:38 下午
     */
    public void getStateFromMemento(ReportMemento memento){
        auditorState=memento.getAuditorState();
        dateState=memento.getDateState();
    }

    /**
     * 当前状态的toString方法，可设置语言
     * @param lang :OutputManager的语言，包括简体，繁体，英文
     * @return : java.lang.String String结果，包括审阅者名字和审阅时间信息
     * @author 陈垲昕
     * @since 2021-10-29 9:37 下午
     */
    public String toString(OutputManager.Lang lang) {
        if (lang == OutputManager.Lang.en) {
            return "[Audit History: auditor " + auditorState.getName() + "'s committed version at " + dateState + " ]";
        } else if (lang == OutputManager.Lang.zh_CN) {
            return "【审计历史：审计员 " + auditorState.getName() + " 于 " + dateState.toString() + " 提交的审计版本】";
        } else if (lang == OutputManager.Lang.zh_TW) {
            return "【審計歷史：審計員 " + auditorState.getName() + " 於 " + dateState.toString() + " 提交的審計版本】";
        } else {
            return "The specific language is not supported.";
        }
    }
}
