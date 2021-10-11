package Manufacturing.CanEntity.Size;

/**
 * 大尺寸
 * 桥接模式
 * @author 汪明杰
 */
public class BigSize implements Size {

    @Override
    public int getSize() {
        return 100;
    }

    @Override
    public boolean isLarge() {
        return true;
    }
}
