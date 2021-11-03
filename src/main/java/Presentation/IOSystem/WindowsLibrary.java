package Presentation.IOSystem;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface WindowsLibrary extends Library
{
    WindowsLibrary Console = Native.load("WinApi.dll", WindowsLibrary.class);
    void fullScreen();
    void recoveryScreen();
    void cls();
    void initScreen(String helpInfo);
    void refreshScreen(String output, String input, String helpInfo);
    char getInput();
    int getScreenWidth();
}
