package Presentation.IOSystem;

public class InputGetter extends Getter
{
    private static final InputGetter instance = new InputGetter();

    public boolean isFinished = false;

    public static InputGetter getInstance() {
        return instance;
    }

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
