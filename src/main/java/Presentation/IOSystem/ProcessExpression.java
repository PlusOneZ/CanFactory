package Presentation.IOSystem;

import CanFactory.CanFactory;
import Presentation.Protocol.IOManager;

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
                    IOManager.getInstance().print("输入 'help process' 以获取帮助信息\n",
                            "輸入 'help process' 獲取幫助\n",
                            "input 'help process' gain help\n");
            }
    }
}
