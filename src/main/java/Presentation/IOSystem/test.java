package Presentation.IOSystem;

public class test
{
    public static void main(String[] args)
    {
        Runnable main = () ->{
            IOSystem.getInstance().init();
            for(int i = 0; i < 9; ++i)
                IOSystem.getInstance().out(String.valueOf(i) + '\n');
            String in = IOSystem.getInstance().in();
            IOSystem.getInstance().out("这是你的输入" + in + '\n');
        };
        new Thread(main).run();
    }
}
