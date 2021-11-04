package Presentation.IOSystem;

import Presentation.WindowsLibrary;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//输入输出系统
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
    //重置系统
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


    //输入
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
    //完成输入
    public void completeIn(String in){
        synchronized (inLock) {
            this.in = in;
            inLock.notify();
        }
    }
    //系统输出
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
    //输出
    public void out(String output){
        if(Thread.currentThread().getId() != id)
            return;
        SystemOut(output);
    }
    //开始获取输入
    private void startGetInput(){
        inputGetter = InputGetter.getInstance();
        printInputHandler = new PrintInputHandler();
        inputGetter.attach(printInputHandler);
        InterpretInputHandler interpretInputHandler = new InterpretInputHandler();
        inputGetter.attach(interpretInputHandler);
    }
    //开始刷新屏幕
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
    //复原屏幕
    private void recoveryScreen() {
        WindowsLibrary.Console.recoveryScreen();
        WindowsLibrary.Console.cls();
    }

    private IOSystem() {

    }
    //初始化
    public void init() {
        WindowsLibrary.Console.fullScreen();
        WindowsLibrary.Console.initScreen(helpInfo);
        initHelpInfo();
        startGetInput();
        startRefreshScreen();
        setId();
        updateLastThread();
        IOSystem.getInstance().out("欢迎使用罐头工厂|歡迎使用罐頭工廠|Welcome to use CanFactory\n");
    }
    //初始化帮助信息
    private void initHelpInfo() {
        final String znInfo = "请输入language选择语言";
        final String enInfo = "Please input language to select language";
        final String twInfo = "請輸入language選擇語言";
        int screenWidth = WindowsLibrary.Console.getScreenWidth();
        int width = (screenWidth - znInfo.length() - enInfo.length() - twInfo.length() - 16) / 2;
        helpInfo = "-".repeat(width) + znInfo + '|' + enInfo + '|' + twInfo + "-".repeat(width);
        if(helpInfo.length() < screenWidth)
            helpInfo += '-';
    }
    //改变帮助信息
    public void changeHelpInfo(String language) {
        String info;
        int screenWidth = WindowsLibrary.Console.getScreenWidth();
        switch (language) {
            case "zh_CN":
                info = "design_pattern 打印设计模式|help 获取帮助信息|input 与程序进行交互|language 切换语言|process 进入系统|sudo 强制执行";
                screenWidth -= 31;
                break;
            case "zh_TW":
                info = "design_pattern 打印設計模式|help 獲取幫助信息|input 與程序進行交互|language 切換語言|process 進入系統|sudo 强制执行";
                screenWidth -= 31;
                break;
            default:
                info = "design_pattern: print design pattern|help: gain help information|input: Interaction with programs|"
                +"language: change language|process: run process|sudo: force to run";
                break;
        }
        int width = (screenWidth - info.length()) / 2;
        helpInfo = "-".repeat(width) + info + "-".repeat(width);
        if(helpInfo.length() < screenWidth)
            helpInfo += '-';
    }
}
