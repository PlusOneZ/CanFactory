package Marketing;

import java.util.ArrayList;

/**
 * subject类，与观察者模式相关
 * @author 梁乔 2021/10/10
 **/
public class Observable {
    protected ArrayList<Observer> observers;
    private boolean Changed = false;

    /**
     *构造函数，产生一个Subject
     */
    public Observable(){
        observers = new ArrayList<Observer>();
    }

    /**
     * 绑定一个新的观察者
     * @param observer 观察者
     */
    public void Attach(Observer observer){
        observers.add(observer);
    }

    /**
     * 解绑一个指定观察者
     * @param o 观察者
     * @return 是否成功绑定
     */
    public boolean Detach(Observer o){
        int i = observers.indexOf(o);
        if(i>=0){
            observers.remove(i);
            return true;
        }
        return false;
    }

    /**
     * 解绑第一个观察者，构造函数
     * @return 解绑成功与否
     */
    public boolean Detach(){
        if(observers.size()>0) {
            observers.remove(0);
            return true;
        }
        return false;
    }

    /**
     * 通知观察者对象
     */
    void notifyObservers(){
        for(int i = 0;i < observers.size();i++){
            Observer ob = (Observer)observers.get(i);
            ob.update();
        }
    }

    /**
     * 数据修改，改变subject的状态
     */
    void dataChanged(){
        Changed = true;
    }

}
