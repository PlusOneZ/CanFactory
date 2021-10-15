package Manufacturing.CanEntity.Size;

/**
 * 大尺寸
 * 桥接模式、单例模式
 * @author 汪明杰
 */
public class BigSize implements Size {

    static private BigSize bigSize= null;

    private BigSize(){

    }

    public static Size getInstance(){
        if (BigSize.bigSize == null){
            BigSize.bigSize = new BigSize();
        }
        return BigSize.bigSize;
    }

    @Override
    public int getSize() {
        return 100;
    }

    @Override
    public boolean isLarge() {
        return true;
    }
}
