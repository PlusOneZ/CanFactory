package Presentation;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface WindowsLibrary extends Library
{
    WindowsLibrary Console = Native.load("WinApi",WindowsLibrary.class);
    void cls();
    void fullScreen();
    void changeBackground();
    void recoveryScreen();
    void recoveryBackground();
    void printColorfulChar(int r, int g, int b, char ch);
    void initScreen(String helpInfo);
    void refreshScreen(String output, String input, String helpInfo);
    char getInput();
    int getScreenWidth();
}
