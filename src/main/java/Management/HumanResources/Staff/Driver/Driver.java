package Management.HumanResources.Staff.Driver;

import Management.HumanResources.Staff.Staff;

/**
 * 委派模式
 * 司机接口
 *
 * @author 吴英豪
 */
public  abstract class Driver extends Staff {
    /**
     * 运输司机运送货物
     *
     * @param quantity 货运量
     */
    public abstract void transport(Double quantity);
}
