package Mutex;

/**
 * 互斥量模式
 * 机器互斥锁
 * 对于某些机器，同一时间只有一批工人可以使用，使用结束之后才能换下一批
 *
 * @author 吴英豪
 */
public class MachineMutex implements Mutex {
    @Override
    public void acquire() {
    }

    @Override
    public void release() {

    }
}
