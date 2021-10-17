package Manufacturing.ProductLine;


/**
 * 生产线迭代器类.
 *
 * <b>实现了迭代器模式</b>
 *
 * @author 孟繁霖
 * @date 2021/10/14 20:07
 */
public class LineIterator<T extends Factory> implements Iterator {

    T lineFactory;

    /**
     * 构造器
     *
     * @param lineFactory :  生产线工厂对象
     * @author 孟繁霖
     * @date 2021-10-14 21:47
     */
    public LineIterator(T lineFactory) {
        this.lineFactory = lineFactory;
    }


    @Override
    public boolean hasNext() {
        return lineFactory.hasNextLine();
    }

    @Override
    public Object next() {
        return lineFactory.getNextLine();
    }

}
