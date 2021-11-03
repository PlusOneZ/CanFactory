package Presentation.IOSystem;

import Presentation.Protocol.IOManager;

public class HelpExpression implements AbstractExpression
{
    @Override
    public void interpret(String context) {
        String[] constructions = context.split(" ");
        for(String construction : constructions)
            switch (construction) {
                case "design_pattern":
                    IOSystem.getInstance().out("设计模式帮助信息");
                    break;
                case "language":
                    IOSystem.getInstance().out("语言帮助信息");
                    break;
                case "process":
                    IOSystem.getInstance().out("流程帮助信息");
                    break;
                default:
                    IOManager.getInstance().print("输入 'help 指令' 获取相应帮助信息\n", "輸入 'help 指令' " +
                            "獲取相應幫助信息\n", "input 'help instruction' gain information about it\n");
            }
    }
}