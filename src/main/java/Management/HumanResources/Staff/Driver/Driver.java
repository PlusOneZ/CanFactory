package Management.HumanResources.Staff.Driver;

import Management.HumanResources.Staff.Staff;
import Storage.TransportationCan;

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
     * @param transportationCan 需要运输的罐头
     */
    public abstract void transport(TransportationCan transportationCan);
}
