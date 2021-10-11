package Management.HumanResources.Company;

import Presentation.Protocol.OutputManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式下的部门
 * @author 陈垲昕
 * @since 2021-10-11 7:43 下午
 * TODO: 1. 加入特殊员工（指一些部门特有的，比如生产车间的工人）;2.考虑是否需要写具体的部门类,特化为开发部门，生产部门等...
 */

public class Department extends ManagementUnit {

    /**
     * 组合模式中Department类作为父类的单元列表
     * <b>使用组合模式</b>
     */
    private List<ManagementUnit> unitList = new ArrayList<>();

    /**
     * 部门经理，通过add方法添加
     */
    private Manager departmentManager;


    /**
     * 部门的构造函数
     * TODO:看后续设计，考虑需不需要将部门设计为多例模式
     * @param name : 部门名字
     * @author 陈垲昕
     * @since 2021-10-11 7:43 下午
     */
    public Department(String name){
        this.name=name;
    }

    /**
     * 获取部门经理
     * @return : Management.HumanResources.Company.Manager  部门经理
     * @author 陈垲昕
     * @since 2021-10-11 11:19 下午
     */
    public Manager getDepartmentManager(){ return this.departmentManager;}

    /**
     * 重写ManagementUnit中的showInfo方法，打印这个部门的信息
     * （包括直系员工，下属部门，部门以下各个员工等）
     * @author 陈垲昕
     * @since 2021-10-11 7:14 下午
     */
    @Override
    public void showInfo() {

        //TODO:替换为OutputManager
        System.out.println("部门名为"+this.getName());
        //遍历部门列表
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
            this.departmentManager= (Manager) unit;
            ((Manager) unit).setWorkingSector(this);
            System.out.println(this.getName()+"添加经理"+unit.getName());
        }
        else if (unit instanceof Department) {
            System.out.println(this.getName()+"添加子部门"+unit.getName());
        }
        else if (unit instanceof Staff){
            ((Staff) unit).setWorkingSector(this);
            System.out.println(this.getName()+"添加添加职员"+unit.getName());
        }
    }

}
