package Presentation.IOSystem;

//控制非终结表达式，用于解释控制符
public class ControlExpression implements AbstractExpression
{
    private final DesignPatternTerminalExpression designPatternTerminalExpression = new DesignPatternTerminalExpression();
    private final HelpTerminalExpression helpExpression = new HelpTerminalExpression();
    private final InputTerminalExpression inputTerminalExpression = new InputTerminalExpression();
    private final LanguageTerminalExpression languageExpression = new LanguageTerminalExpression();
    private final ProcessTerminalExpression processExpression = new ProcessTerminalExpression();
    //解释控制符
    @Override
    public void interpret(Instruction instruction){
        switch (instruction.handleNoLanguage())
        {
            case "sudo":
                superDo(instruction);
                break;
            case "input":
                inputTerminalExpression.interpret(instruction);
                break;
            case "design_pattern" :
                join(designPatternTerminalExpression, instruction);
                break;
            case "help":
                join(helpExpression, instruction);
                break;
            case "language":
                join(languageExpression, instruction);
                break;
            case "no_language":
                IOSystem.getInstance().SystemOut("language zh_CN\t设置语言为中文\n" +
                        "language zh_TW\t設置語言為臺灣繁體中文\nlanguage en\tset language to English\n");
            case "process":
                join(processExpression, instruction);
                break;
        }
    }
    //立即执行
    private void superDo(Instruction instruction){
        IOSystem.getInstance().setId();
        IOSystem.getInstance().updateLastThread();
        IOSystem.getInstance().resetSystem();
        Runnable newThread = () -> interpret(instruction);
        new Thread(newThread).start();
    }
    //待当前线程执行完后执行
    private void join(AbstractExpression terminalExpression, Instruction instruction) {
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
        do {
            terminalExpression.interpret(instruction.getFirstWord());
        } while (instruction.notEmpty());
    }
}
