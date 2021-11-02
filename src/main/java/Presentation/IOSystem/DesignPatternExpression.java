package Presentation.IOSystem;

public class DesignPatternExpression implements AbstractExpression
{
    @Override
    public void interpret(String context) {
        String[] constructions = context.split(" ");
        for(String construction : constructions)
            switch (construction) {
                default -> IOSystem.getInstance().SystemOut("设计模式");
            }
    }
}
