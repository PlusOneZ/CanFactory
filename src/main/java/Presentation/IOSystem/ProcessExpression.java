package Presentation.IOSystem;

import CanFactory.CanFactory;

public class ProcessExpression implements AbstractExpression
{
    @Override
    public void interpret(String context) {
        String[] constructions = context.split(" ");
        for(String construction : constructions)
            switch (construction) {
                case "orderManage":
                    CanFactory.getInstance().orderManage();
                    break;
                case "companyManage":
                    CanFactory.getInstance().companyManage();
                    break;
                default:
                    IOSystem.getInstance().out("输入help process以获取帮助信息");

            }
    }
}
