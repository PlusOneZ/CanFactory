package Presentation.IOSystem;

public class InputTerminalExpression implements AbstractExpression
{
    @Override
    public void interpret(String context) {
        IOSystem.getInstance().completeIn(context);
    }
}
