package Presentation.IOSystem;

import Presentation.Protocol.IOManager;

public class LanguageExpression implements AbstractExpression
{
    @Override
    public void interpret(String context) {
        String[] constructions = context.split(" ");
        for(String construction : constructions)
            switch (construction) {
                case "zh_CN":
                    IOManager.getInstance().setLanguage(IOManager.Lang.zh_CN);
                    break;
                case "zh_TW":
                    IOManager.getInstance().setLanguage(IOManager.Lang.zh_TW);
                    break;
                case "en":
                    IOManager.getInstance().setLanguage(IOManager.Lang.en);
                    break;
                default:
                    IOSystem.getInstance().out("输入help language以获取帮助信息");
            }
    }
}
