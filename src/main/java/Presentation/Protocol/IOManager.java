package Presentation.Protocol;

import Presentation.IOSystem.IOSystem;

import java.io.PrintStream;
import java.util.*;

/**
 * 实现多语言打印的输出控制器。
 * @author 卓正一
 *
 * <b>实现了单例模式</b>
 */
public class IOManager {

    public enum OperatingSystem {
        MAC,WIN
    }

    public static OperatingSystem operatingSystem;

    /**
     * <b>私有构造函数</b>
     */
    private IOManager() {
        delay = 300;
    }

    /**
     * <b>单例获取函数</b>
     * @return 全局唯一的 OutputManager
     */
    public static IOManager getInstance() {
        return instance;
    }

    static private final IOManager instance;

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

    public void run() {
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
            if (IOManager.operatingSystem == OperatingSystem.MAC){
                addToQueue(zh_cn, zh_tw , en);
            }
            else{
                if (language == Lang.zh_CN) {
                    IOSystem.getInstance().out(zh_cn);
                } else if (language == Lang.zh_TW) {
                    IOSystem.getInstance().out(zh_tw);
                } else if (language == Lang.en) {
                    IOSystem.getInstance().out(en);
                }

            }
        }
    }


    public void printLoading(String zh_cn, String zh_tw ,String en) {
        if (mode != Mode.brief && mode != Mode.patternOnly) {
            if (IOManager.operatingSystem == OperatingSystem.MAC){
                if (language == Lang.zh_CN) {
                    System.out.print(zh_cn);
                } else if (language == Lang.zh_TW) {
                    System.out.print(zh_tw);
                } else if (language == Lang.en) {
                    System.out.print(en);
                }
            }
            else{
                return;
            }
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
        if (IOManager.operatingSystem == OperatingSystem.MAC){
            addToQueue(zh_cn + appendix, zh_tw + appendix, en + appendix);
        }
        else{
            if (language == Lang.zh_CN) {
                IOSystem.getInstance().out(zh_cn+ appendix);
            } else if (language == Lang.zh_TW) {
                IOSystem.getInstance().out(zh_tw+ appendix);
            } else if (language == Lang.en) {
                IOSystem.getInstance().out(en+ appendix);
            }

        }

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
            if (IOManager.operatingSystem == OperatingSystem.MAC){
                addToQueue(zh_cn, zh_tw , en);
            }
            else{
                if (language == Lang.zh_CN) {
                    IOSystem.getInstance().out(zh_cn);
                } else if (language == Lang.zh_TW) {
                    IOSystem.getInstance().out(zh_tw);
                } else if (language == Lang.en) {
                    IOSystem.getInstance().out(en);
                }

            }
        }
    }

    /**
     * 向标准输出打印多语言信息
     * <i>功能委托给 outputToStream 函数</i>
     * @param zh_cn 简体中文文本
     * @param zh_tw 台湾繁体中文文本
     * @param en 英文文本
     */
    public void printBrief(String zh_cn, String zh_tw ,String en, String appendix) {
        if (mode != Mode.patternOnly) {
//            outputToStream(System.out, zh_cn, zh_tw, en);
            if (IOManager.operatingSystem == OperatingSystem.MAC){
                addToQueue(zh_cn + appendix, zh_tw + appendix, en + appendix);
            }
            else{
                if (language == Lang.zh_CN) {
                    IOSystem.getInstance().out(zh_cn+ appendix);
                } else if (language == Lang.zh_TW) {
                    IOSystem.getInstance().out(zh_tw+ appendix);
                } else if (language == Lang.en) {
                    IOSystem.getInstance().out(en+ appendix);
                }

            }

        }
    }

    public void printPattern(String zh_cn, String zh_tw ,String en) {
//        outputToStream(System.out, zh_cn, zh_tw, en);
        if (IOManager.operatingSystem == OperatingSystem.MAC){
            addToQueue(zh_cn, zh_tw , en);
        }
        else{
            if (language == Lang.zh_CN) {
                IOSystem.getInstance().out(zh_cn);
            } else if (language == Lang.zh_TW) {
                IOSystem.getInstance().out(zh_tw);
            } else if (language == Lang.en) {
                IOSystem.getInstance().out(en);
            }

        }
    }

    public void printLanguageIrrelevantContent(String content) {

        if (IOManager.operatingSystem == OperatingSystem.MAC){
            addToQueue(content, content, content);
        }
        else{
            IOSystem.getInstance().out(content);

        }
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
        if (IOManager.operatingSystem == OperatingSystem.MAC){
            if (language == Lang.zh_CN) {
                System.err.println(
                        zh_cn
                );
            } else if (language == Lang.zh_TW) {
                System.err.println(
                        zh_tw
                );
            } else if (language == Lang.en) {
                System.err.println(
                        en
                );
            }
            else{
                System.err.println(
                        "未设置语言 / 未設定語言 / Output Language Not Designated"
                );
            }
        }
        else{
            if (language == Lang.zh_CN) {
                IOSystem.getInstance().out(zh_cn);
            } else if (language == Lang.zh_TW) {
                IOSystem.getInstance().out(zh_tw);
            } else if (language == Lang.en) {
                IOSystem.getInstance().out(en);
            }

        }


    }

    /**
     * 向某输出流打印多语言信息
     * @param zh_cn 简体中文文本
     * @param zh_tw 台湾繁体中文文本
     * @param en 英文文本
     */
    private void outputToStream( String zh_cn, String zh_tw , String en) {
        if (language == Lang.zh_CN) {
            System.out.println(zh_cn);
        } else if (language == Lang.zh_TW) {
            System.out.println(zh_tw);
        } else if (language == Lang.en) {
            System.out.println(en);
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

    /**
     * 接受输入
     */
    public String input(){
        if(operatingSystem == OperatingSystem.MAC){
            Scanner inputScanner = new Scanner(System.in);
            return inputScanner.nextLine();
        }
        else{
            return IOSystem.getInstance().in();
        }
    }

    static {
        instance = new IOManager();

        operatingSystem = OperatingSystem.MAC;
    }

    public static void main(String[] args) {
        IOManager.getInstance().print(
                "# 使用单例模式: 直接使用了单例输入/输出管理者",
                "# 使用單例模式: 直接使用了單例輸入/輸出管理者",
                "# Using Singleton Pattern: directly use the singleton input/output manager"
        );
    }
}