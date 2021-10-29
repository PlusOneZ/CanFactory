package Management.HumanResources.FinancialSystem;

import Presentation.Protocol.OutputManager;

import java.sql.Array;
import java.util.ArrayList;

/**
 * 审阅报告历史版本的存储列表
 * <b>使用单例模式，同时是备忘录模式的组分</b>
 * @author 陈垲昕
 * @since 2021/10/29 3:56 下午
 */

public class ReportAuditHistoryList {

    /**
     * 全局单例
     */
    static private ReportAuditHistoryList instance;

    /**
     * 存储审阅报告的备忘录的列表
     */
    private ArrayList<ReportMemento> historyList;

    /**
     * 私有构造函数
     * @author 陈垲昕
     * @since 2021-10-29 9:25 下午
     */


    private ReportAuditHistoryList(){
        this.historyList=new ArrayList<ReportMemento>();
    }

    /**
     * 获取全局单例
     * @return : Management.HumanResources.FinancialSystem.ReportAuditHistoryList
     * @author 陈垲昕
     * @since 2021-10-29 9:25 下午
     */
    public static ReportAuditHistoryList getInstance(){
        if(instance==null){
            instance=new ReportAuditHistoryList();
        }
        return instance;
    }


    /**
     * 获取列表大小
     */
    public int getSize(){return historyList.size();}

    /**
     * 列表中添加新的审计报告记录
     * @param historyVersion :  要添加的新审计报告备忘录
     * @author 陈垲昕
     * @since 2021-10-29 9:26 下午
     */
    public void add(ReportMemento historyVersion){
        historyList.add(historyVersion);
    }


    /**
     * 根据索引获取历史记录中的备忘录
     * @param index :  索引
     * @return : Management.HumanResources.FinancialSystem.ReportMemento
     * @author 陈垲昕
     * @since 2021-10-29 9:27 下午
     */
    public ReportMemento get(int index){

        return historyList.get(index);
    }



}
