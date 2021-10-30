package CanFactory;

import Marketing.OrderCenterEntity.OrderPartTest;

/**
 * 所有类的驱动类
 *
 * @author 卓正一
 * @since  2021/10/29 5:16 PM
 */
public class CanFactory {

    private static CanFactory canFactory;

    static {
        canFactory = new CanFactory();
    }

    public static CanFactory getInstance() {
        return canFactory;
    }

    /**
     * 单例构造器
     * @author 卓正一
     * @since 2021-10-29 5:17 PM
     */
    private CanFactory() {

    }

    public void run() {

    }
}
