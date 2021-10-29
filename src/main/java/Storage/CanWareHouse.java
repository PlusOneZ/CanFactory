package
        Storage;

import java.util.ArrayList;

/**
 *
 * 此处为库存管理模块中的仓库类,用来存储各种不同类型的罐头与数量
 * 单例模式
 * @author 王立友
 * @date 2021/10/16 16:52
 */
public class CanWareHouse {

    /**
     * 仓库中维护的罐头实体列表
     */
    private ArrayList<StockCan> stockCans;

    /**
     * 创建仓库单例
     */
    private static final CanWareHouse instance = new CanWareHouse();

    /**
     * 私有化构造函数
     */
    private CanWareHouse() {
        stockCans = new ArrayList<>();
    }

    /**
     * 获得单例
     * @return : Storage.WareHouse
     * @author "王立友"
     * @date 2021-10-16 17:01
     */
    public static CanWareHouse getInstance(){
        return instance;
    }


    public ArrayList<StockCan> getStockCans() {
        return stockCans;
    }
}