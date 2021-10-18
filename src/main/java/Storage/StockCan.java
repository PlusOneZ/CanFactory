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

    /**
     * 构造函数;
     * @param can :
     * @param count :
     * @return : null
     * @author "王立友"
     * @date 2021-10-17 18:39
     */
    public StockCan(Can can, int count){
        this.can = can;
        this.count = count;
    }

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