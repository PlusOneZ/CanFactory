package Presentation.Protocol;

import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 实现多语言打印的输出控制器。
 * @author 卓正一
 *
 * <b>实现了单例模式</b>
 */
public class OutputManager {

    public enum IOSystem{
        MAC,WIN
    }

    public static IOSystem system;

    /**
     * <b>私有构造函数</b>
     */
    private OutputManager() {
        delay = 300;
    }

    /**
     * <b>单例获取函数</b>
     * @return 全局唯一的 OutputManager
     */
    public static OutputManager getInstance() {
        return instance;
    }

    static private final OutputManager instance;

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

    private Lang language = Lang.zh_CN;

    /**
     * 输出模式，可以选择详细、简单和只有设计模式输出。
     * @since 2021-10-25 7:41 PM
     */
    public enum Mode {
        detailed, brief, patternOnly
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    private Mode mode = Mode.detailed;

    private final PrintStream ps = System.out;

    private Queue<String> outputQueue = new ArrayDeque<>();

    private int delay;

    private Timer timer;

    public void setDelay(int delay) {
        this.delay = delay;
    }

    private void run() {
        timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (outputQueue.isEmpty()) {
                    return;
                }
                ps.println(outputQueue.poll());
            }
        }, 0, delay);
    }

    public void stop() {
        timer.cancel();
    }

    /**
     * 向标准输出打印多语言信息
     * <i>功能委托给 outputToStream 函数</i>
     * @param zh_cn 简体中文文本
     * @param zh_tw 台湾繁体中文文本
     * @param en 英文文本
     */
    public void print(String zh_cn, String zh_tw ,String en) {
        // TODO: 增加条件
        if (mode != Mode.brief && mode != Mode.patternOnly) {
//            outputToStream(System.out, zh_cn, zh_tw, en);
            addToQueue(zh_cn, zh_tw, en);
        }
    }

    /**
     * 向标准输出打印多语言信息
     * <i>功能委托给 outputToStream 函数</i>
     * @param zh_cn 简体中文文本
     * @param zh_tw 台湾繁体中文文本
     * @param en 英文文本
     * @param appendix 附加的文本
     */
    public void print(String zh_cn, String zh_tw ,String en, String appendix) {
//        outputToStream(
//                System.out,
//                zh_cn + appendix,
//                zh_tw + appendix,
//                en + appendix
//        );
        addToQueue(zh_cn + appendix, zh_tw + appendix, en + appendix);
    }

    /**
     * 向标准输出打印多语言信息
     * <i>功能委托给 outputToStream 函数</i>
     * @param zh_cn 简体中文文本
     * @param zh_tw 台湾繁体中文文本
     * @param en 英文文本
     */
    public void printBrief(String zh_cn, String zh_tw ,String en) {
        if (mode != Mode.patternOnly) {
//            outputToStream(System.out, zh_cn, zh_tw, en);
            addToQueue(zh_cn, zh_tw, en);
        }
    }

    public void printPattern(String zh_cn, String zh_tw ,String en) {
//        outputToStream(System.out, zh_cn, zh_tw, en);
        addToQueue(zh_cn, zh_tw, en);
    }

    public void printLanguageIrrelevantContent(String content) {
        addToQueue(content, content, content);
    }

    private void addToQueue(String zh_cn, String zh_tw, String en) {
        outputQueue.add(
                selectStringForCurrentLanguage(
                        zh_cn,
                        zh_tw,
                        en
                )
        );
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

    public String selectStringForCurrentLanguage(String zh_cn, String zh_tw ,String en) {
        switch (language) {
            case en: return en;
            case zh_CN: return zh_cn;
            case zh_TW: return zh_tw;
        }
        return "";
    }

    static {
        instance = new OutputManager();
        instance.run();
        system = IOSystem.MAC;
    }
}
