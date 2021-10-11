package Observer;

import java.util.ArrayList;

public interface Observable {

    public boolean registerObserver(Observer o);
    public boolean removeObserver(Observer o);
    public void notifyObservers();
}
