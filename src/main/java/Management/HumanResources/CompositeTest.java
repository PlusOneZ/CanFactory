package
        Management.HumanResources;

import Presentation.Protocol.OutputManager;

/**
 * TODO:组合模式测试类
 *
 * @author 孟繁霖
 * @date 2021/10/12 9:07
 */
public class CompositeTest {

    public static void main(String[] args) {
        Employee CEO = new Employee("John","CEO", 30000);

        Employee saleHeader = new Employee("Robert","sale", 20000);

        Employee marketHeader = new Employee("Michel","market", 20000);

        Employee market1 = new Employee("Laura","market", 10000);
        Employee market2 = new Employee("Bob","market", 10000);

        Employee sale1 = new Employee("Richard","sale", 10000);
        Employee sale2= new Employee("Rob","sale", 10000);

        CEO.add(saleHeader);
        CEO.add(marketHeader);

        saleHeader.add(sale1);
        saleHeader.add(sale2);

        marketHeader.add(market1);
        marketHeader.add(market2);

        OutputManager.getInstance().setLanguage(OutputManager.Lang.zh_CN);
        OutputManager.getInstance().errorMassage(
                CEO.toString(),
                CEO.toString(),
                CEO.toString());
        for (Employee header : CEO.getSubordinates()) {
            OutputManager.getInstance().errorMassage(
                    header.toString(),
                    header.toString(),
                    header.toString());
            for (Employee employee : header.getSubordinates()) {
                OutputManager.getInstance().errorMassage(
                        employee.toString(),
                        employee.toString(),
                        employee.toString());
            }
        }
    }

}
