package Presentation.Protocol;

/**
 * 需要通过此接口提供一个类的多语言描述。
 * <b>虽然没有模式，但是是一种设计</b>
 * @author 卓正一
 * @since 2021-10-11 9:47 PM
 */
public interface MultiLanguageDescription {

    /**
     * @return : java.lang.String 中文描述
     * @author 卓正一
     * @since 2021-10-11 9:48 PM
     */
    String zhCnDescription();

    /**
     * @return : java.lang.String 繁体描述
     * @author 卓正一
     * @since 2021-10-11 9:49 PM
     */
    String zhTwDescription();

    /**
     * @return : java.lang.String 英文描述
     * @author 卓正一
     * @since 2021-10-11 9:49 PM
     */
    String enDescription();

}
