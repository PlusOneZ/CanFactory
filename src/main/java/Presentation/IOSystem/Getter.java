package Presentation.IOSystem;

import java.util.ArrayList;
import java.util.List;

//被观察者抽象基类
abstract class Getter
{
    protected List<InputHandler> handlers = new ArrayList<>();
    //添加观察者
    public void attach(InputHandler handler) {
        handlers.add(handler);
    }
    //通知观察者
    public void notify(char ch) {
        for(InputHandler handler : handlers)
            handler.handle(ch);
    }
}
