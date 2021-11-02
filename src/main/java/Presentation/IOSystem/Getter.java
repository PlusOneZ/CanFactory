package Presentation.IOSystem;

import java.util.ArrayList;
import java.util.List;

abstract class Getter
{
    protected List<InputHandler> handlers = new ArrayList<>();

    public void attach(InputHandler handler) {
        handlers.add(handler);
    }

    public void notify(char ch) {
        for(InputHandler handler : handlers)
            handler.handle(ch);
    }
}
