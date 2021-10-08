package Management.HumanResources.Company;

/**
 * 组合模式的单元构成基类
 * <b>作为 Composite模式 的一部分</b>
 * @author 陈垲昕
 */

//TODO:1.加入ID？然后把ID生成器设为单例模式；2.加入繁体名字和英文名字 3.showInfo树形结构
public abstract class BaseComponent {
    /*
     * @description: 组件名字:对公司，为公司名；对部门，为部门名；对员工，为员工名
     */
    protected String name;

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name=name;
    }



    public abstract void showInfo();

    public void add(BaseComponent baseComponent){
        throw new UnsupportedOperationException();
    }
}
