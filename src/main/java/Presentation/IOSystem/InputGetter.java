package Presentation.IOSystem;

import Presentation.WindowsLibrary;

//被观察者，获取键盘输入
public class InputGetter extends Getter
{
    private static final InputGetter instance = new InputGetter();

    public boolean isFinished = false;

    public static InputGetter getInstance() {
        return instance;
    }
    //读取键盘输入
    private InputGetter() {
        Runnable getInputTask = () ->
        {
            char ch;
            while ((ch = WindowsLibrary.Console.getInput()) != 27)
                notify(ch);
            isFinished = true;
        };
        new Thread(getInputTask).start();
    }
}
