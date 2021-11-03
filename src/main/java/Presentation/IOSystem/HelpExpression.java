package Presentation.IOSystem;

import Presentation.Protocol.IOManager;

public class HelpExpression implements AbstractExpression
{
    final private String language_zh_CN = "language zh_CN\t设置语言为中文\n" +
            "language zh_TW\t设置语言为繁体中文\nlanguage en\t设置语言为英文\n";
    final private String language_zh_TW = "language zh_CN\t設置語言為中文\n" +
            "language zh_TW\t設置語言為繁體中文\nlanguage en\t設置語言為英文\n";
    final private String language_en = "language zh_CN\tset language to Chinese\n" +
            "language zh_TW\tset language to traditional Chinese\nlanguage en\tset language to English\n";
    final private String process_zh_CN = "process orderManage\t进入订单系统\n" +
            "process companyManage\t进入管理系统\n";
    final private String process_zh_TW = "process orderManage\t進入訂單系統\n" +
            "process companyManage\t進入管理系統\n";
    final private String process_en = "process orderManage\t run order process\n" +
            "process companyManage\t run company process";

    @Override
    public void interpret(String context) {
        String[] constructions = context.split(" ");
        for(String construction : constructions)
            switch (construction) {
                case "design_pattern":
                    IOSystem.getInstance().out("设计模式帮助信息(待补充)");
                    break;
                case "language":
                    IOManager.getInstance().print(language_zh_CN,language_zh_TW,language_en);
                    break;
                case "process":
                    IOManager.getInstance().print(process_zh_CN,process_zh_TW,process_en);
                    break;
                default:
                    IOManager.getInstance().print("输入 'help 指令' 获取相应帮助信息\n", "輸入 'help 指令' " +
                            "獲取相應幫助信息\n", "input 'help instruction' gain information about it\n");
            }
    }
}