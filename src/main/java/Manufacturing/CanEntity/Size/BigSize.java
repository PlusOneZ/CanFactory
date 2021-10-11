package Manufacturing.CanEntity.Size;

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
