package Management.HumanResources.FinancialSystem;

import Management.HumanResources.BaseDepartment;
import Management.HumanResources.DepartmentType;

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

}
