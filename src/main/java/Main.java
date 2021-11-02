import CanFactory.CanFactory;
import Presentation.Protocol.IOManager;

public class Main {
    public static void main(String[] args) {

        // 操作系统选择
        IOManager.IOsystem = IOManager.IOSystem.MAC;

        if(IOManager.IOsystem == IOManager.IOSystem.MAC){
            CanFactory factory = CanFactory.getInstance();
            factory.run();
        }
        else{
            //
        }
    }
}
