package Management.HumanResources.FinancialSystem;

import Management.HumanResources.BaseDepartment;
import Management.HumanResources.DepartmentType;
import Presentation.Protocol.OutputManager;

/**
 * 经济财政部门
 *
 * @author 陈垲昕
 * @since 2021/10/24 3:26 下午
 */

public class FinancialDepartment extends BaseDepartment {

    /**
     * 单例对象
     */
    static private final FinancialDepartment instance;

    /*
     * 单例初始化
     */
    static {
        instance = new FinancialDepartment();
    }

    /**
     * 私有构造函数
     * @author 陈垲昕
     * @since 2021-10-24 3:30 下午
     */
    private FinancialDepartment(){super.type= DepartmentType.Finance;}

    /**
     * 获取全局单例实例
     * @return : Management.HumanResources.FinancialSystem.FinancialDepartment
     * @author 陈垲昕
     * @since 2021-10-24 3:30 下午
     */
    public static FinancialDepartment getInstance(){return instance;}


    /**
     * 经济部门调取审计报告的历史表格，查看当前最新修改版本以及所有历史版本
     * @author 陈垲昕
     * @since 2021-10-29 9:40 下午
     */
    public void viewAuditHistoryList(){
        OutputManager.getInstance().print(
                "当前版本："+ReportOriginator.getInstance().toString(OutputManager.Lang.zh_CN),
                "當前版本："+ReportOriginator.getInstance().toString(OutputManager.Lang.zh_TW),
                "Latest version: "+ReportOriginator.getInstance().toString(OutputManager.Lang.en)
        );

        OutputManager.getInstance().print(
                "所有历史版本：",
                "所有歷史版本",
                "All previous version: "
        );

        for(int i = 0; i<ReportAuditHistoryList.getInstance().getSize(); i++){
            ReportOriginator.getInstance().getStateFromMemento(ReportAuditHistoryList.getInstance().get(i));
            OutputManager.getInstance().print(
                    "No."+(i+1) +"："+ReportOriginator.getInstance().toString(OutputManager.Lang.zh_CN),
                    "No."+(i+1) +"："+ReportOriginator.getInstance().toString(OutputManager.Lang.zh_TW),
                    "No."+(i+1)+":" +ReportOriginator.getInstance().toString(OutputManager.Lang.en)
            );
        }

    }

}
