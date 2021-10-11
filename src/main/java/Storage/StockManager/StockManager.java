package Storage.StockManager;

/**
 * 库存
 * 单例模式
 *
 * @author 吴英豪
 */
public class StockManager {
    /**
     * <b>私有构造函数</b>
     */
    private StockManager() {
    }

    /**
     * <b>单例获取函数</b>
     *
     * @return 全局唯一的 Stock
     */
    public static StockManager getInstance() {
        if (instance == null) {
            instance = new StockManager();
        }
        return instance;
    }

    /**
     * 设置当前库存
     *
     * @param stock 库存量
     */
    public void setStockAmount(Double stock) {
        stockAmount = stock;
    }

    /**
     * 获取当前库存量
     *
     * @return 库存量
     */
    public Double getStockAmount() {
        return stockAmount;
    }

    //库存量
    private Double stockAmount;

    //实例
    static private StockManager instance;
}
