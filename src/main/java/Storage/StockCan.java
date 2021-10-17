package
        Storage;

import Manufacturing.CanEntity.Can;

/**
 * 存储在仓库中的一类Can的信息
 *
 * @author 王立友
 * @date 2021/10/16 21:57
 */
public class StockCan {
    /**
     * 罐头
     */
    private Can can;
    /**
     * 该类罐头数量
     */
    private int count;

    /** setter and getter **/
    public int getCount() {
        return count;
    }

    public Can getCan() {
        return can;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setCan(Can can) {
        this.can = can;
    }
}