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

        if(ReportAuditHistoryList.getInstance().getSize()==0){
            OutputManager.getInstance().printPattern(
                    "# 使用了备忘录模式  当前备忘录列表为空",
                    "# 使用了備忘錄模式  當前備忘錄列表為空",
                    "# Adopted Memento pattern  Current memento list is empty."
            );
            return;
        }

        OutputManager.getInstance().printPattern(
                "# 使用了备忘录模式  公司的审核历史备忘录列表如下：",
                "# 使用了備忘錄模式  公司的審核歷史備忘錄列表如下：",
                "# Adopted Memento pattern  Can Factory report audit history: "
        );

        OutputManager.getInstance().print(
                "*----当前版本："+ReportOriginator.getInstance().toString(OutputManager.Lang.zh_CN),
                "*----當前版本："+ReportOriginator.getInstance().toString(OutputManager.Lang.zh_TW),
                "*----Latest version: "+ReportOriginator.getInstance().toString(OutputManager.Lang.en)
        );

        OutputManager.getInstance().print(
                "*----所有历史版本：",
                "*----所有歷史版本",
                "*----All previous version: "
        );

        for(int i = 0; i<ReportAuditHistoryList.getInstance().getSize(); i++){
            ReportOriginator.getInstance().getStateFromMemento(ReportAuditHistoryList.getInstance().get(i));
            OutputManager.getInstance().print(
                    "*----No."+(i+1) +"："+ReportOriginator.getInstance().toString(OutputManager.Lang.zh_CN),
                    "*----No."+(i+1) +"："+ReportOriginator.getInstance().toString(OutputManager.Lang.zh_TW),
                    "*----No."+(i+1)+":" +ReportOriginator.getInstance().toString(OutputManager.Lang.en)
            );
        }

    }

    /**
     * 经济管理部门下达命令的方法，提示输出
     * @author 陈垲昕
     * @since 2021-11-02 2:41 下午
     */
    @Override
    public void giveCommand() {

        OutputManager.getInstance().printPattern(
                "# 使用了命令模式  经济管理部门下达命令",
                "# 使用了命令模式  經濟管理部門下達命令",
                "# Adopted Command pattern  Financial department commands an task to be done."
        );

        super.giveCommand();
    }
}
