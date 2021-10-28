package
        Storage;

import Marketing.Wrapping.WrappedCan;

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
    private WrappedCan wrappedCan;
    /**
     * 该类罐头数量
     */
    private int count;

    /**
     * 构造函数;
     * @param wrappedCan : 包装好的罐头
     * @param count :      对应罐头的数量
     * @return : null 无返回值
     * @author "王立友"
     * @date 2021-10-17 18:39
     */
    public StockCan(WrappedCan wrappedCan, int count){
        this.wrappedCan = wrappedCan;
        this.count = count;
    }

    /** setter and getter **/
    public int getCount() {
        return count;
    }


    public void setCount(int count) {
        this.count = count;
    }


    public WrappedCan getWrappedCan() {
        return wrappedCan;
    }

    public void setWrappedCan(WrappedCan wrappedCan) {
        this.wrappedCan = wrappedCan;
    }
}