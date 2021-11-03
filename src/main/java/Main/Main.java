package Main;
import CanFactory.CanFactory;
import Presentation.AsciiVid.AsciiPic;
import Presentation.IOSystem.IOSystem;
import Presentation.Protocol.IOManager;

public class Main {
    public static void main(String[] args) {

        System.out.println("请选择使用系統 / 請選擇使用系统 / Please select the system");
        System.out.println("[1 - Mac]\t[2 - Win]");

        int selectedLanguage = -1;
        while ((selectedLanguage = CanFactory.getInstance().intputInteger()) == -1 || selectedLanguage < 1 || selectedLanguage > 2) {
            System.out.println("无效输入，请重新输入 / 無效輸入，请重新輸入 / Invalid input, please input again");
        }
        if(selectedLanguage == 2)
            IOManager.operatingSystem = IOManager.OperatingSystem.WIN;
        else {
            IOManager.getInstance().run();
        }

        if(IOManager.operatingSystem == IOManager.OperatingSystem.MAC){
            CanFactory factory = CanFactory.getInstance();
            factory.run();
        }
        else{
            AsciiPic.winHelloPic();
            Runnable main = () ->{
                IOSystem.getInstance().init();
            };
            new Thread(main).start();
        }


    }
}
