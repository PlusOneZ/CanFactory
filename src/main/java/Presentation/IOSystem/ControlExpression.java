package Presentation.IOSystem;

import Presentation.Protocol.IOManager;

public class ControlExpression implements AbstractExpression
{
    private final DesignPatternExpression designPatternExpression = new DesignPatternExpression();
    private final HelpExpression helpExpression = new HelpExpression();
    private final InputTerminalExpression inputTerminalExpression = new InputTerminalExpression();
    private final LanguageExpression languageExpression = new LanguageExpression();
    private final ProcessExpression processExpression = new ProcessExpression();
    @Override
    public void interpret(String context){
        String instruction = context.toLowerCase();
        if(instruction.indexOf(' ') > 0)
            instruction = instruction.substring(0, instruction.indexOf(' '));
        if(IOManager.getInstance().getLanguage() == null && !instruction.equals("language"))
        {
            IOSystem.getInstance().SystemOut("language zh_CN\t设置语言为中文\n" +
                    "language zh_TW\t設置語言為臺灣繁體中文\nlanguage en\tset language to English\n");
            return;
        }
        if(instruction.equals("sudo"))
            superDo(context);
        else if(instruction.equals("input"))
            inputTerminalExpression.interpret(context.substring(context.indexOf(' ') + 1));
        else{
            join();
            switch (instruction) {
                case "design_pattern" :
                    designPatternExpression.interpret(context.substring(context.indexOf(' ') + 1));
                    break;
                case "help":
                    helpExpression.interpret(context.substring(context.indexOf(' ') + 1));
                    break;
                case "language":
                    languageExpression.interpret(context.substring(context.indexOf(' ') + 1));
                    break;
                case "process":
                    processExpression.interpret(context.substring(context.indexOf(' ') + 1));
                    break;
            }
        }
    }
    private void superDo(String instruction){
        IOSystem.getInstance().setId();
        IOSystem.getInstance().updateLastThread();
        IOSystem.getInstance().resetSystem();
        Runnable newThread = () ->
        {
            if(instruction.indexOf(' ') > 0)
                interpret(instruction.substring(instruction.indexOf(' ') + 1));
        };
        new Thread(newThread).start();
    }

    private void join() {
        Thread waitThread = IOSystem.getInstance().getLastThread();
        IOSystem.getInstance().updateLastThread();
        try {
            waitThread.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(waitThread.getId() == IOSystem.getInstance().getId())
            IOSystem.getInstance().setId();
    }
}
