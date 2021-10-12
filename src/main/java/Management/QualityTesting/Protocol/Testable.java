package Management.QualityTesting.Protocol;

import Presentation.Protocol.MultiLanguageDescription;

/**
 * 描述可以被测试的物件，需要实现被测试的方法。
 * TODO: 构想一种在测试函数中真正被测试的方法。
 * <b>实现了 Servant 模式</b>
 * @author 卓正一
 * @since 2021-10-11 9:41 PM
 */
public interface Testable extends MultiLanguageDescription {

    /**
     * 接受质量检测
     * @return boolean 是否通过测试
     * @author 卓正一
     * @since 2021-10-11 9:43 PM
     */
    boolean getQualityTest();

    /**
     * 接受安全检测
     * @return : boolean 是否通过测试
     * @author 卓正一
     * @since 2021-10-11 9:47 PM
     */
    boolean getSafetyTest();

}
