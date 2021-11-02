package Presentation.IOSystem;

public class InterpretInputHandler implements InputHandler
{
    ControlExpression controlExpression = new ControlExpression();
    String input = "";
    public void handle(char ch) {
        if(ch == '\r')
        {
            String expression = input;
            Runnable controlTask = () ->
            {
                controlExpression.interpret(expression);
            };
            new Thread(controlTask).start();
            input = "";
        }
        else if (ch != 8)
            input += ch;
        else if (input.length() > 0)
            input = input.substring(0, input.length() - 1);
    }
}
