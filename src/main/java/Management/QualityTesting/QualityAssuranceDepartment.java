package Management.QualityTesting;

import Management.HumanResources.BaseDepartment;
import Management.HumanResources.DepartmentType;
import Management.QualityTesting.Protocol.Testable;
import Presentation.Protocol.OutputManager;

/**
 * 管控罐头或原材料（Testable 接口）的质量与安全，有质量检测和安全检测两个方法。
 * TODO: 增加对于一个迭代器的函数，一次性检测多个内容。
 *
 * @author 卓正一
 * @since   2021-10-11 8:14 PM
 */
public class QualityAssuranceDepartment extends BaseDepartment {


    /*
     * 单例初始化
     */
    static {
        instance = new QualityAssuranceDepartment();
    }

    /**
     * 私有构造函数
     * @author 卓正一
     * @since 2021-10-11 10:03 PM
     *
     * 改动了私有构造函数，设定了type为DepartmentType=QualityTesting
     * @author 陈垲昕
     * @since 2021-10-17 8:58 下午
     */
    private QualityAssuranceDepartment() {
        super.type=DepartmentType.QualityAssurance;
    }

    /**
     * 单例对象
     * @since 2021-10-11 10:03 PM
     */
    static private final QualityAssuranceDepartment instance;

    /**
     * 获取单例
     * @return : Management.QualityTesting.QualityAssuranceDepartment 全局唯一对象
     * @author 卓正一
     * @since 2021-10-11 10:04 PM
     */
    public static QualityAssuranceDepartment getInstance(){
        return instance;
    };

    /**
     * 测试质量函数，当前还是通过<b>委托于被测试对象</b>本身实现。
     * @param testable 可被测试的对象
     * @author 卓正一
     * @since 2021-10-11 10:04 PM
     */
    public boolean testQuality(Testable testable) {

        if (testable.getQualityTest()) {
            OutputManager.getInstance().print(
                    testable.zhCnDescription() + " 通过质量测试。",
                    testable.zhTwDescription() + " 通過質量測試。",
                    testable.enDescription() + " has passed quality test."
            );
            return true;
        } else {
            OutputManager.getInstance().errorMassage(
                    testable.zhCnDescription() + " 未通过质量测试。",
                    testable.zhTwDescription() + " 未通過質量測試。",
                    testable.enDescription() + " didn't pass safety test."
            );
            return false;
        }

    }

    /**
     * 测试安全函数，当前还是通过<b>委托于被测试对象</b>本身实现。
     * @param testable 可被测试的对象
     * @author 卓正一
     * @since 2021-10-11 10:04 PM
     */
    public boolean testSafety(Testable testable) {

        if (testable.getSafetyTest()) {
            OutputManager.getInstance().print(
                    testable.zhCnDescription() + " 通过安全测试。",
                    testable.zhTwDescription() + " 通過質量測試。",
                    testable.enDescription() + " has passed quality test."
            );
            return true;
        } else {
            OutputManager.getInstance().errorMassage(
                    testable.zhCnDescription() + " 未通过安全测试。",
                    testable.zhTwDescription() + " 未通過質量測試。",
                    testable.enDescription() + " didn't pass safety test."
            );
            return false;
        }

    }


}