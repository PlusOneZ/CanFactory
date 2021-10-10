package Manufacturing.CanEntity.Size;

import java.io.Serializable;


/**
 * 桥接模式（Bridge）
 * 实现不同种类的罐头
 * 罐头的大小属性
 */
public interface Size extends Serializable {

    public int getSize();

    public boolean isLarge();

}
