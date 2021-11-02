package Presentation.AsciiVid;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface WindowsLibrary extends Library
{
    WindowsLibrary Console = Native.load("WinApi.dll", WindowsLibrary.class);
    void setCursorPos(short x, short y);
    void cls();
    void fullScreen();
    void changeBackground();
    void recoveryScreen();
    void recoveryBackground();
    void printColorfulChar(int r, int g, int b, char ch);
}
