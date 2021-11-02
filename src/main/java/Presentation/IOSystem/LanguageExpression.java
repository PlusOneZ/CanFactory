package Presentation.IOSystem;

public class LanguageExpression implements AbstractExpression
{
    @Override
    public void interpret(String context) {
        String[] constructions = context.split(" ");
        for(String construction : constructions)
            switch (construction) {
                default -> IOSystem.getInstance().SystemOut("语言");
            }
    }
}
