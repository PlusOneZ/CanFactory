package Presentation.IOSystem;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class IOSystem
{
    private static final IOSystem instance = new IOSystem();
    private String output = "";
    private PrintInputHandler printInputHandler;
    private InputGetter inputGetter;
    private final ReentrantLock outputLock = new ReentrantLock(true);
    private final Condition canOutput = outputLock.newCondition();
    private final Object inLock = new Object();
    private String helpInfo = "\n";
    private String in = "";
    private Thread lastThread;
    private long id;

    public static IOSystem getInstance() {
        return instance;
    }

    public Thread getLastThread() {
        return lastThread;
    }

    public void updateLastThread() {
        lastThread = Thread.currentThread();
    }

    public long getId() {
        return id;
    }

    public void setId() {
        id = Thread.currentThread().getId();
    }

    public void resetSystem() {
        outputLock.lock();
        try{
            while (this.output.length() != 0)
                canOutput.await();
            WindowsLibrary.Console.cls();
            WindowsLibrary.Console.initScreen(helpInfo);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            outputLock.unlock();
        }
    }



    public String in() {
        synchronized (inLock)
        {
            try {
                inLock.wait();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            this.SystemOut(in);
            return in;
        }
    }

    public void completeIn(String in){
        synchronized (inLock) {
            this.in = in;
            inLock.notify();
        }
    }

    public void SystemOut(String output){
        outputLock.lock();
        try{
            while (this.output.length() != 0)
                canOutput.await();
            if(!inputGetter.isFinished)
                this.output = output+"\n";
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            outputLock.unlock();
        }
    }

    public void out(String output){
        if(Thread.currentThread().getId() != id)
            return;
        SystemOut(output);
    }

    private void startGetInput(){
        inputGetter = InputGetter.getInstance();
        printInputHandler = new PrintInputHandler();
        inputGetter.attach(printInputHandler);
        InterpretInputHandler interpretInputHandler = new InterpretInputHandler();
        inputGetter.attach(interpretInputHandler);
    }

    private void startRefreshScreen() {
        Runnable refreshScreenTask = () ->
        {
            while (!inputGetter.isFinished)
            {
                if(output.length() != 0 || !printInputHandler.getIsLasted())
                {
                    printInputHandler.setIsLasted(true);
                    outputLock.lock();
                    try{
                        WindowsLibrary.Console.refreshScreen(output,printInputHandler.getPrintString(),helpInfo);
                        output = "";
                        canOutput.signalAll();
                    }
                    finally {
                        outputLock.unlock();
                    }
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            recoveryScreen();
        };
        new Thread(refreshScreenTask).start();
    }

    private void recoveryScreen() {
        WindowsLibrary.Console.recoveryScreen();
        WindowsLibrary.Console.cls();
    }

    private IOSystem() {

    }

    public void init() {
        WindowsLibrary.Console.fullScreen();
        WindowsLibrary.Console.initScreen(helpInfo);
        initHelpInfo();
        startGetInput();
        startRefreshScreen();
        setId();
        updateLastThread();
    }

    private void initHelpInfo() {
        final String znInfo = "请输入language选择语言";
        final String enInfo = "Please input language to select language";
        final String twInfo = "請輸入language選擇語言";
        int width = WindowsLibrary.Console.getScreenWidth();
        width = (width - znInfo.length() - enInfo.length() - twInfo.length() - 16) / 2;
        helpInfo = "-".repeat(width) + znInfo + '|' + enInfo + '|' + twInfo + "-".repeat(width) + "\n";
    }
}
