package Management.HumanResources.Company;


/**
 * ManagementUnit类:组合模式的单元构成基类
 * 派生有Company,Department,Manager,Staff等类
 * <b>作为 Composite模式 的一部分</b>
 * @author 陈垲昕
 * @since 2021-10-11 7:37 下午
 */

//TODO:1.加入ID？然后把ID生成器设为单例模式；2.加入繁体名字和英文名字 3.showInfo树形结构

public abstract class ManagementUnit {

    /**
     * 管理单元的名字
     */
    protected String name;


    /**
     * getter获取管理单元名字
     * @return : java.lang.String 管理单元名字
     * @author 陈垲昕
     * @since 2021-10-11 7:39 下午
     */
    public String getName(){
        return this.name;
    }


    /**
     * setter设置管理单元名字
     * @param name : 所要设的名字
     * @author 陈垲昕
     * @since 2021-10-11 7:39 下午
     */
    public void setName(String name){
        this.name=name;
    }


    /**
     * 抽象的showInfo基类，在派生类中具体实现
     * @author 陈垲昕
     * @since 2021-10-11 7:40 下午
     */
    public abstract void showInfo();


    /**
     * 基类的add方法，理论上无法调用
     * @param managementUnit : 模板
     * @author 陈垲昕
     * @since 2021-10-11 7:40 下午
     */
    public void add(ManagementUnit managementUnit){

        throw new UnsupportedOperationException();
    }
}
