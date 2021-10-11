package Manufacturing.CanEntity.Size;

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
