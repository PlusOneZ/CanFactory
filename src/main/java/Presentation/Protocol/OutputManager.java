package Presentation.Protocol;

import java.io.PrintStream;

/**
 * 实现多语言打印的输出控制器。
 * @author 卓正一
 *
 * <b>实现了单例模式</b>
 */
public class OutputManager {

    /**
     * <b>私有构造函数</b>
     */
    private OutputManager() { }

    /**
     * <b>单例获取函数</b>
     * @return 全局唯一的 OutputManager
     */
    public static OutputManager getInstance() {
        if (instance == null) {
            instance = new OutputManager();
        }
        return instance;
    }

    static private OutputManager instance;

    /**
     * 语言类型枚举器，支持 简体中文，台湾繁体中文，英文。
     */
    public enum Lang {
        zh_CN, zh_TW, en
    }

    /**
     * 设置当前语言
     * @param lang 当前语言类型，需要用 OutputManager.Lang 访问
     */
    public void setLanguage(Lang lang) {
        language = lang;
    }

    public Lang getLanguage() { return language; }

    private Lang language;

    /**
     * 向标准输出打印多语言信息
     * <i>功能委托给 outputToStream 函数</i>
     * @param zh_cn 简体中文文本
     * @param zh_tw 台湾繁体中文文本
     * @param en 英文文本
     */
    public void print(String zh_cn, String zh_tw ,String en) {
        outputToStream(System.out, zh_cn, zh_tw, en);
    }

    /**
     * 向错误输出打印多语言信息
     * <i>功能委托给 outputToStream 函数</i>
     * @param zh_cn 简体中文文本
     * @param zh_tw 台湾繁体中文文本
     * @param en 英文文本
     */
    public void errorMassage(String zh_cn, String zh_tw ,String en) {
        outputToStream(System.err, zh_cn, zh_tw, en);
    }

    /**
     * 向某输出流打印多语言信息
     * @param ps 输出流
     * @param zh_cn 简体中文文本
     * @param zh_tw 台湾繁体中文文本
     * @param en 英文文本
     */
    private void outputToStream(PrintStream ps, String zh_cn, String zh_tw , String en) {
        if (language == Lang.zh_CN) {
            ps.println(zh_cn);
        } else if (language == Lang.zh_TW) {
            ps.println(zh_tw);
        } else if (language == Lang.en) {
            ps.println(en);
        } else {
            System.err.println(
                    "未设置语言 / 未設定語言 / Output Language Not Designated"
            );
        }
    }

}
