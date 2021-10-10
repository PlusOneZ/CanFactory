package Mutex;

/**
 * 互斥量模式
 * 互斥锁接口
 *
 * @author 吴英豪
 */
public interface Mutex {
    /**
     * 申请使用资源
     */
    void acquire();

    /**
     * 使用完毕之后释放资源
     */
    void release();
}
