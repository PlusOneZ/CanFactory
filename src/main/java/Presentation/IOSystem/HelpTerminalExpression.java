package Presentation.IOSystem;

import Presentation.Protocol.IOManager;

//帮助信息终结表达式子
public class HelpTerminalExpression implements AbstractExpression
{
    //显示相应帮助信息
    @Override
    public void interpret(Instruction instruction) {
        String language_zh_CN = "language zh_CN\t设置语言为中文\n" +
                "language zh_TW\t设置语言为繁体中文\nlanguage en\t设置语言为英文\n";
        String language_zh_TW = "language zh_CN\t設置語言為中文\n" +
                "language zh_TW\t設置語言為繁體中文\nlanguage en\t設置語言為英文\n";
        String language_en = "language zh_CN\tset language to Chinese\n" +
                "language zh_TW\tset language to traditional Chinese\nlanguage en\tset language to English\n";
        String process_zh_CN = "process orderManage\t进入订单系统\n" +
                "process companyManage\t进入管理系统\n";
        String process_zh_TW = "process orderManage\t進入訂單系統\n" +
                "process companyManage\t進入管理系統\n";
        String process_en = "process orderManage\t run order process\n" +
                "process companyManage\t run company process";
        String design_pattern_zh_CN = "design_pattern abstract_factory\t抽象工厂模式\t\t" +
                "design_pattern builder\t\t建造者模式\n" + "design_pattern factory_method\t工厂方法模式\t\t" +
                "design_pattern prototype\t原型模式\n" + "design_pattern singleton\t单例模式\t\t" +
                "design_pattern converter\t转换器模式\n" + "design_pattern multiton\t\t多例模式\t\t" +
                "design_pattern adapter\t\t适配器模式\n" + "design_pattern bridge\t\t桥接模式\t\t" +
                "design_pattern composite\t组合模式\n" + "design_pattern decorator\t装饰器模式\t\t" +
                "design_pattern facade\t\t外观模式\n" + "design_pattern flyweight\t享元模式\t\t" +
                "design_pattern proxy\t\t代理模式\n" + "design_pattern dao\t\t数据访问对象模式\t" +
                "design_pattern dirty_flag\t脏标记模式\n" + "design_pattern command\t\t命令模式\t\t" +
                "design_pattern filter\t\t过滤器模式\n" + "design_pattern interpreter\t解释器模式\t\t" +
                "design_pattern iterator\t\t迭代器模式\n" + "design_pattern mediator\t\t中介者模式\t\t" +
                "design_pattern memento\t\t备忘录模式\n" + "design_pattern observer\t\t观察者模式\t\t" +
                "design_pattern state\t\t状态模式\n" + "design_pattern strategy\t\t策略模式\t\t" +
                "design_pattern template\t\t模板方法模式\n" + "design_pattern visitor\t\t访问者模式\t\t" +
                "design_pattern black_board\t黑板模式\n" + "design_pattern delegate\t\t委派模式\t\t" +
                "design_pattern chain_of_responsibility\t责任链模式\n";
        String design_pattern_zh_TW = "design_pattern abstract_factory\t抽象工廠模式\t\t" +
                "design_pattern builder\t\t建造者模式\n" + "design_pattern factory_method\t工廠方法模式\t\t" +
                "design_pattern prototype\t原型模式\n" + "design_pattern singleton\t單例模式\t\t" +
                "design_pattern converter\t轉換器模式\n" + "design_pattern multiton\t\t多例模式\t\t" +
                "design_pattern adapter\t\t適配器模式\n" + "design_pattern bridge\t\t橋接模式\t\t" +
                "design_pattern composite\t組合模式\n" + "design_pattern decorator\t裝飾器模式\t\t" +
                "design_pattern facade\t\t外觀模式\n" + "design_pattern flyweight\t享元模式\t\t" +
                "design_pattern proxy\t\t代理模式\n" + "design_pattern dao\t\t數據訪問對象模式\t" +
                "design_pattern dirty_flag\t臟標記模式\n" + "design_pattern command\t\t命令模式\t\t" +
                "design_pattern filter\t\t過濾器模式\n" + "design_pattern interpreter\t解釋器模式\t\t" +
                "design_pattern iterator\t\t叠代器模式\n" + "design_pattern mediator\t\t中介者模式\t\t" +
                "design_pattern memento\t\t備忘錄模式\n" + "design_pattern observer\t\t觀察者模式\t\t" +
                "design_pattern state\t\t狀態模式\n" + "design_pattern strategy\t\t策略模式\t\t" +
                "design_pattern template\t\t模板方法模式\n" + "design_pattern visitor\t\t訪問者模式\t\t" +
                "design_pattern black_board\t黑板模式\n" + "design_pattern delegate\t\t委派模式\t\t" +
                "design_pattern chain_of_responsibility\t責任鏈模式\n";
        String design_pattern_en = "design_pattern abstract_factory\t\t\t" +
                "design_pattern builder\t\n" + "design_pattern factory_method\t\t\t" +
                "design_pattern prototype\t\n" + "design_pattern singleton\t\t\t" +
                "design_pattern converter\t\n" + "design_pattern multiton\t\t\t\t" +
                "design_pattern adapter\t\n" + "design_pattern bridge\t\t\t\t" +
                "design_pattern composite\t\n" + "design_pattern decorator\t\t\t" +
                "design_pattern facade\t\n" + "design_pattern flyweight\t\t\t" +
                "design_pattern proxy\t\n" + "design_pattern dao\t\t\t\t" +
                "design_pattern dirty_flag\t\n" + "design_pattern chain_of_responsibility\t\t" +
                "design_pattern command\t\n" + "design_pattern interpreter\t\t\t" +
                "design_pattern iterator\t\n" + "design_pattern mediator\t\t\t\t" +
                "design_pattern memento\t\n" + "design_pattern observer\t\t\t\t" +
                "design_pattern state\t\n" + "design_pattern strategy\t\t\t\t" +
                "design_pattern template\t\n" + "design_pattern visitor\t\t\t\t" +
                "design_pattern black_board\t\n" + "design_pattern delegate\t\t\t\t" +
                "design_pattern filter\t\n";
        switch (instruction.getString()) {
            case "design_pattern":
                IOManager.getInstance().print(design_pattern_zh_CN, design_pattern_zh_TW, design_pattern_en);
                break;
            case "language":
                IOManager.getInstance().print(language_zh_CN, language_zh_TW, language_en);
                break;
            case "process":
                IOManager.getInstance().print(process_zh_CN, process_zh_TW, process_en);
                break;
            default:
                IOManager.getInstance().print("输入 'help 指令' 获取相应帮助信息\n", "輸入 'help 指令' " +
                        "獲取相應幫助信息\n", "input 'help instruction' gain information about it\n");
        }
    }
}