package Management.HumanResources.Company;

import Presentation.Protocol.OutputManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式下的部门
 * @author 陈垲昕
 *
 * TODO: 1. 加入特殊员工（指一些部门特有的，比如生产车间的工人）;2.考虑是否需要写具体的部门类,特化为开发部门，生产部门等...
 */

public class Department extends BaseComponent{

    /*
     * @description: 包含部门下每个员工的链表
     */
    private List<BaseComponent> components = new ArrayList<>();
    /* 
     * @description: 部门的经理
     */
    private Manager manager;


    public Department(String name){
        this.name=name;
    }

    

    @Override
    public void showInfo() {

        OutputManager.getInstance().print(
                "部门名为:"+this.getName(),
                "部門名為"+this.getName(),
                "The name of the department is:"+this.getName()
        );

        for(BaseComponent component:components){
            component.showInfo();
        }
    }

    //TODO:考虑是否要将add特化为addManager,addStaff,add之类的
    @Override
    public void add(BaseComponent component){
        this.components.add(component);
    }

}
