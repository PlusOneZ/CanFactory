package Main;
import CanFactory.CanFactory;
import Presentation.AsciiVid.AsciiPic;
import Presentation.IOSystem.IOSystem;
import Presentation.Protocol.IOManager;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {

        System.out.println("请选择使用系統 / 請選擇使用系统 / Please select the system");
        System.out.println("[1 - Mac]");

        int selectedSystem;
        while ((selectedSystem = CanFactory.getInstance().inputInteger()) == -1 || selectedSystem < 1 || selectedSystem > 1) {
            System.out.println("无效输入，请重新输入 / 無效輸入，请重新輸入 / Invalid input, please input again");
        }
//        if (selectedSystem == 2){
//            IOManager.getInstance().stop();
//            IOManager.operatingSystem = IOManager.OperatingSystem.WIN;
//        }


        if (IOManager.operatingSystem == IOManager.OperatingSystem.MAC) {
            CanFactory factory = CanFactory.getInstance();
            factory.run();
        }
//        } else {
////            String fileName = System.getProperty("exe.path") + "WinApi.dll";
////            String fileName;
////            fileName = URLDecoder.decode(Main.class.getProtectionDomain().getCodeSource().getLocation().getFile(),
////                    StandardCharsets.UTF_8);
////            fileName = fileName.substring(0,fileName.lastIndexOf('/'));
//            String fileName = "src/main/resources";
//            System.setProperty("jna.library.path", fileName);
//
//            AsciiPic.winHelloPic();
//            Runnable main = () -> IOSystem.getInstance().init();
//            new Thread(main).start();
//        }
    }
}