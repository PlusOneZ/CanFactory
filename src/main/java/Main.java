import CanFactory.CanFactory;
import Presentation.Protocol.OutputManager;

public class Main {
    public static void main(String[] args) {

        // 操作系统选择
        OutputManager.IOsystem = OutputManager.IOSystem.MAC;

        if(OutputManager.IOsystem == OutputManager.IOSystem.MAC){
            CanFactory factory = CanFactory.getInstance();
            factory.run();
        }
        else{
            //
        }
    }
}
