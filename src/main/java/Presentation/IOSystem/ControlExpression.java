package Presentation.IOSystem;

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
        if(instruction.equals("sudo"))
            superDo(context);
        else if(instruction.equals("input"))
            inputTerminalExpression.interpret(context.substring(context.indexOf(' ') + 1));
        else{
            join();
            switch (instruction) {
                case "design_pattern" -> designPatternExpression.interpret(context.substring(context.indexOf(' ') + 1));
                case "help" -> helpExpression.interpret(context.substring(context.indexOf(' ') + 1));
                case "language" -> languageExpression.interpret(context.substring(context.indexOf(' ') + 1));
                case "process" -> processExpression.interpret(context.substring(context.indexOf(' ') + 1));
                default -> helpInformation(instruction);
            }
        }
    }
    private void helpInformation(String context)
    {
        if(context.equalsIgnoreCase("help"))
            IOSystem.getInstance().SystemOut("帮助信息\n");
        else
            IOSystem.getInstance().SystemOut("错误的输入：" + context + "\n请输入help获取帮助信息。\n");
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
