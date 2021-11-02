package Manufacturing.CanEntity.ConcreteCan;

import Manufacturing.CanEntity.Can;
import Manufacturing.ProductLine.AbstractCanFactory.GlassCanFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 原型模式测试类
 *
 * @author 汪明杰
 * @date 2021/11/2 13:23
 */
public class PrototypeTest {
    public static void main(String[] args) {
        List<Can> cans = new ArrayList<>();

        for(int i=0;i<10;++i){
            cans.add(GlassCanFactory.getInstance().createBigCan("Peach"));
        }

    }
}
