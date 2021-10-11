package Management.HumanResources.Staff.Driver;

/**
 * 委派模式
 * 司机接口
 *
 * @author 吴英豪
 */
public interface Driver {
    /**
     * 运输司机运送货物
     *
     * @param quantity 货运量
     */
    public void transport(Double quantity);
}
