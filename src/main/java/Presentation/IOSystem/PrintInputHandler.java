package Presentation.IOSystem;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;
//打印输出处理
public class PrintInputHandler implements InputHandler
{
    boolean isLasted = false;

    String printString = ">";
    private final SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss ");
    private int lineNum = 0;
    //处理要打印的信息
    @Override
    public void handle(char ch) {
        final int maxLineNum = 3;
        if (ch != 8)
        {
            printString += ch;
            if(ch == '\r')
            {
                if(lineNum < maxLineNum)
                    ++lineNum;
                else
                    printString = printString.substring(printString.indexOf('\n') + 1);
                Date now = new Date();
                printString = printString.substring(0, printString.lastIndexOf('\n') + 1) + " "
                        + ft.format(now) + printString.substring(printString.lastIndexOf('\n') + 2) + "\n>";
            }
        }
        else if(printString.length() - printString.lastIndexOf('\n') > 2)
            printString = printString.substring(0, printString.length() - 1);
        setIsLasted(false);
    }
    //获取要打印的信息
    public String getPrintString() {
        return printString;
    }

    public boolean getIsLasted() {
        return isLasted;
    }

    public synchronized void setIsLasted(boolean isLasted) {
        this.isLasted = isLasted;
    }
}
