package Presentation.IOSystem;

import Management.Assets.Announcement.BlackBoardTest;
import Management.Assets.ClothingDecoraor.DecoratorTest;
import Management.HumanResources.test.AuditTest;
import Management.HumanResources.test.ChainOfResponsibilityTest;
import Management.HumanResources.test.FinancialDepartmentTest;
import Management.HumanResources.test.TransportDepartmentTest;
import Management.QuantityTesting.VisitorTest;
import Manufacturing.CanEntity.CanTest;
import Manufacturing.CanEntity.ConcreteCan.PrototypeTest;
import Manufacturing.Ingredient.CompositeTest;
import Manufacturing.Machine.CanTreatmentMachine.MultitonTest;
import Manufacturing.ProductLine.Producer.Test.AdapterTest;
import Manufacturing.ProductLine.PurchaseDepartment;
import Manufacturing.ProductLine.test.ProductDepartment;
import Marketing.IteratorPatternTest;
import Marketing.OrderEnity.StatePatternTest;
import Marketing.Promotion.SaleTest;
import Marketing.Wrapping.WrappingDriver;
import Presentation.Protocol.IOManager;
import Storage.InventoryDriver;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
//设计模式终结表达式
public class DesignPatternTerminalExpression implements AbstractExpression
{
    //执行对应的设计模式
    @Override
    public void interpret(Instruction instruction) {
        String[] args = {"test"};
        switch (instruction.getString()) {
            case "abstract_factory":
            case "factory_method":
            case "flyweight":
            case "template":
                ProductDepartment.main(args);
                break;
            case "builder":
            case "converter":
                try {
                    WrappingDriver.main(args);
                } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
                break;
            case "prototype":
                PrototypeTest.main(args);
                break;
            case "singleton":
                IOManager.main(args);
                break;
            case "multiton":
                MultitonTest.main(args);
                break;
            case "adapter":
                AdapterTest.main(args);
                break;
            case "bridge":
                CanTest.main(args);
                break;
            case "composite":
                CompositeTest.main(args);
            case "decorator":
                DecoratorTest.main(args);
                break;
            case "facade":
                Manufacturing.ProductLine.Pretreatment.Test.FacadeTest.main(args);
                break;
            case "proxy":
            case "black_board":
                BlackBoardTest.main(args);
                break;
            case "dao":
                try {
                    FinancialDepartmentTest.main(args);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "dirty_flag":
            case "command":
            case "memento":
                AuditTest.main(args);
                break;
            case "chain_of_responsibility":
                ChainOfResponsibilityTest.main(args);
                break;
            case "interpreter":
                IOManager.getInstance().print(
                        "# 使用解释器模式： 当您输入并得到这条输出的时候，您就已经使用了解释器模式",
                        "# 使用解譯器模式：當您輸入並得到這條輸出的時候，您就已經使用了解譯器模式",
                        "# Using Interpreter Pattern: when you input and get this output, you have already used interpreter pattern"
                );
                break;
            case "Iterator":
                IteratorPatternTest.main(args);
                break;
            case "Mediator":
                InventoryDriver.main(args);
                break;
            case "observer":
            case "filter":
                PurchaseDepartment.main(args);
                break;
            case "state":
                StatePatternTest.main(args);
                break;
            case "strategy":
                SaleTest.main(args);
                break;
            case "visitor":
                VisitorTest.main(args);
                break;
            case "delegate":
                TransportDepartmentTest.main(args);
                break;
            default:
                IOManager.getInstance().print("输入 'help design_pattern' 获取帮助\n",
                        "輸入 'help design_pattern' 獲取幫助\n",
                        "input 'help design_pattern' gain help\n");
        }
    }
}
