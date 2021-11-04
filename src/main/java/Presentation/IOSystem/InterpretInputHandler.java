package Presentation.IOSystem;

//观察者，处理交互信息
public class InterpretInputHandler implements InputHandler
{
    ControlExpression controlExpression = new ControlExpression();
    String input = "";
    //处理交互信息
    public void handle(char ch) {
        if(ch == '\r')
        {
            Instruction instruction = new Instruction(input);
            Runnable controlTask = () -> controlExpression.interpret(instruction);
            new Thread(controlTask).start();
            input = "";
        }
        else if (ch != 8)
            input += ch;
        else if (input.length() > 0)
            input = input.substring(0, input.length() - 1);
    }
}
