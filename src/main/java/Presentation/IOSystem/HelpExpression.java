package Presentation.IOSystem;

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
                    IOSystem.getInstance().out("帮助信息");
            }
    }
}