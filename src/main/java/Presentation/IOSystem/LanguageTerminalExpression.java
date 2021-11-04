package Presentation.IOSystem;

import Presentation.Protocol.IOManager;
//语言终结表达式
public class LanguageTerminalExpression implements AbstractExpression
{
    @Override
    public void interpret(Instruction instruction) {
        switch (instruction.getString()) {
            case "zh_cn":
                IOManager.getInstance().setLanguage(IOManager.Lang.zh_CN);
                IOSystem.getInstance().changeHelpInfo("zh_CN");
                IOSystem.getInstance().out("当前语言为简体中文");
                break;
            case "zh_tw":
                IOManager.getInstance().setLanguage(IOManager.Lang.zh_TW);
                IOSystem.getInstance().changeHelpInfo("zh_TW");
                IOSystem.getInstance().out("當前語言為臺灣繁體中文");
                break;
            case "en":
                IOManager.getInstance().setLanguage(IOManager.Lang.en);
                IOSystem.getInstance().changeHelpInfo("en");
                IOSystem.getInstance().out("Current language is English");
                break;
            default:
                IOSystem.getInstance().out("language zh_CN\t设置语言为中文\n" +
                        "language zh_TW\t設置語言為臺灣繁體中文\nlanguage en\tset language to English\n");
        }
    }
}
