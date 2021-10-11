package Observer;

import Marketing.Order;
import java.util.ArrayList;


public class OrderData implements Observable {

    public    Order RelatedOrder;

    private ArrayList observers;
    public OrderData(){
        observers = new ArrayList();
    }
    public boolean registerObserver(Observer o)
    {
        return observers.add(o);
    }

    public boolean removeObserver(Observer o){
        int i = observers.indexOf(o);
        if(i>=0) {
            observers.remove(i);
            return true;
        }
        return false;
    }

    public void notifyObservers(){
        for(int i=0;i<observers.size();i++){
            Observer ob = (Observer)observers.get(i);
            ob.update();
        }
    }

    public void measurementsChanged(){
        notifyObservers();
    }
    public void getNewOrderData(Order newOrder)
    {
        this.RelatedOrder = newOrder;
        measurementsChanged();
    }




}
