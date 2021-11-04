package Presentation.IOSystem;

//输入终结表达式
public class InputTerminalExpression implements AbstractExpression
{
    //处理输入
    @Override
    public void interpret(Instruction instruction) {
        IOSystem.getInstance().completeIn(instruction.getString());
    }
}
