package Management.HumanResources.Company;

import Presentation.Protocol.OutputManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式下的公司单例，下分为不同部门
 * @author 陈垲昕
 *
 * <b>实现了单例模式</b>
 *
 * TODO: 1. 公司实例更多方法的实现(比如：查找部门;删除部门（可以以后再实现）)
 */

public class Company extends BaseComponent{

    /*
     * @description: 全局唯一的实例
     */
    static private Company instance;
    
    /* 
     * @description: 含有公司各个部门的列表
     */
    private List<BaseComponent> components = new ArrayList<>();

    /**
     * <b>单例获取函数</b>
     * @param: 公司名 name
     * @return: 全局唯一的 Company
     */
    private Company(String name){
        this.name=name;
    }



    /**
     * <b>单例获取函数</b>
     * @return 全局唯一的 Company
     */
    public static Company getInstance(){
        if(instance==null){
            instance=new Company("default name");
        }
        return instance;
    }

    /**
     * <b>信息展示函数函数，遍历了公司下的各个组分</b>
     */
    @Override
    public void showInfo() {

        OutputManager.getInstance().print(
                "公司名为:"+this.getName(),
                "公司名為"+this.getName(),
                "The name of the company is:"+this.getName()
        );

        for(BaseComponent component:components){
            component.showInfo();
        }

    }

    /**
     * <b>重写添加方法，公司添加部门</b>
     * @param:  待添加的Component，也就是部门
     */
    @Override
    public void add(BaseComponent component){
        this.components.add(component);
    }
}
