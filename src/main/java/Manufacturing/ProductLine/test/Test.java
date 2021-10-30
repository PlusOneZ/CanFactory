package Manufacturing.ProductLine.test;

import Manufacturing.CanEntity.Can;

import java.util.List;

/**
 * TODO:此处写Test类的描述
 *
 * @author 孟繁霖
 * @date 2021/10/30 20:07
 */
public class Test {
    public static void main(String[] args) {
       List<Can> canList = ProductDepartment.getInstance().produce("fruit","peach",7,"fine");
        System.out.println(canList);
    }
}
