package Manufacturing.CanEntity.Size;

/**
 * 小尺寸
 * 桥接模式
 * @author 汪明杰
 */
public class SmallSize implements Size{

    @Override
    public int getSize() {
        return 10;
    }

    @Override
    public boolean isLarge() {
        return false;
    }
}
