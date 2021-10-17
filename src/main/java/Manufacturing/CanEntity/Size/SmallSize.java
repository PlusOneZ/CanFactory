package Manufacturing.CanEntity.Size;

/**
 * 小尺寸
 * 桥接模式
 * @author 汪明杰
 */
public class SmallSize implements Size{

    static private SmallSize smallSize= null;

    private SmallSize(){

    }

    public static Size getInstance(){
        if (SmallSize.smallSize == null){
            SmallSize.smallSize = new SmallSize();
        }
        return SmallSize.smallSize;
    }

    @Override
    public int getSize() {
        return 10;
    }

    @Override
    public boolean isLarge() {
        return false;
    }
}
