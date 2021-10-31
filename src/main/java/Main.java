import CanFactory.CanFactory;
import Presentation.Protocol.OutputManager;

public class Main {
    public static void main(String[] args) {

        CanFactory factory = CanFactory.getInstance();
        factory.run();
    }
}
