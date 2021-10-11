package Management.HumanResources.Company;

import java.util.ArrayList;
import java.util.List;


/**
 * Company:公司实体，管理单元基类的一个实体类，
 * <b>使用了单例模式</b>
 * @author 陈垲昕
 * @since 2021-10-11 7:02 下午
 */
public class Company extends ManagementUnit {

    /**
     * Company的单例模式实体，全局唯一
     */
    static private Company instance;

    /**
     * 公司的总经理，通过add方法添加
     */
    private Manager chiefManager;
    
    /**
     * 组合模式中Company作为父类的单元列表
     * <b>使用组合模式</b>
     */
    private List<ManagementUnit> unitList = new ArrayList<>();

    /**
     * 构造函数
     * @param name : 公司名字
     * @author 陈垲昕
     * @since 2021-10-11 7:12 下午
     */
    private Company(String name){
        this.name=name;
    }


    /**
     * 获取Company类唯一实例的方法，供外部类调用
     * <b>单例模式相关</b>
     * @return : Management.HumanResources.Company.Company 公司类的唯一实例
     * @author 陈垲昕
     * @since 2021-10-11 7:13 下午
     */
    public static Company getInstance(){
        if(instance==null){
            //如果没有这个实例，进行内部的构造函数
            //TODO: 允许创建公司名
            instance=new Company("default name");
        }
        return instance;
    }

    /**
     * 获取公司的总经理
     * @return : Management.HumanResources.Company.Manager 总经理
     * @author 陈垲昕
     * @since 2021-10-11 7:57 下午
     */
    public Manager getChiefManagerfManager(){return this.chiefManager;}


    /**
     * 重写ManagementUnit中的showInfo方法，打印这个公司的信息
     * （包括直系员工，下属部门，部门以下各个员工等）
     * @author 陈垲昕
     * @date 2021-10-11 7:14 下午
     */
    @Override
    public void showInfo() {
        //TODO:添加OutputManager
        System.out.println("公司名为"+this.getName());

        //遍历公司列表，递归showInfo()
        for(ManagementUnit unit: unitList){
            unit.showInfo();
        }

    }


    /**
     * 重写列表中添加元素的方法，一般为公司员工或下属部门
     * @param unit : 要添加的ManagementUnit，包括部门，员工等
     * @author 陈垲昕
     * @since 2021-10-11 7:15 下午
     */
    @Override
    public void add(ManagementUnit unit){
        this.unitList.add(unit);
        if(unit instanceof Manager){
            this.chiefManager = (Manager) unit;
            this.chiefManager.setWorkingSector(this);
            System.out.println("公司添加总经理"+unit.getName());
        }
        else if (unit instanceof Department) {
            System.out.println("公司添加部门" + unit.getName());
        }
        else if (unit instanceof Staff){
            ((Staff) unit).setWorkingSector(this);
            System.out.println("公司添加职员"+unit.getName());
        }
    }
}
