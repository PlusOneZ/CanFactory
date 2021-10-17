package
        Storage.InventoryConverter;

import Marketing.OrderEnity.OrderCanInformation;
import Storage.StockCan;

import java.util.ArrayList;
import java.util.function.Function;

/**
 * 此类为将仓库中维护的罐头信息转换为需要统计的订单罐头数据的转换器
 * 转换器模式
 *
 * @author 王立友
 * @date 2021/10/16 21:13
 */
public class CanToOrderConverter {

    Function<ArrayList<StockCan>, ArrayList<OrderCanInformation>> fromCanEntityFunction;

    public CanToOrderConverter() {
        /**
         * 将罐头实体转换为订单中的罐头的函数变量
         */
         fromCanEntityFunction = new FromCanEntityFunction();
    }

    public Function<ArrayList<StockCan>, ArrayList<OrderCanInformation>> getFromCanEntityFunction() {
        return fromCanEntityFunction;
    }

    static class FromCanEntityFunction implements Function<ArrayList<StockCan>, ArrayList<OrderCanInformation>> {

        /**
         * 转换函数
         *
         * @param stockCans :  存储的罐头列表
         * @return : java.util.ArrayList<Marketing.OrderEntity.OrderCanInformation>
         * @author "王立友"
         * @date 2021-10-16 22:13
         */
        @Override
        public ArrayList<OrderCanInformation> apply(ArrayList<StockCan> stockCans) {
            ArrayList<OrderCanInformation> orderCanInformations = new ArrayList<>();

            for (StockCan stockCan : stockCans) {
                String canName = stockCan.getCan().getCanName();
                String canType = stockCan.getCan().getClass().getTypeName();
                int count = stockCan.getCount();
                OrderCanInformation orderCanInformation = new OrderCanInformation(canType, canName, count);
                orderCanInformations.add(orderCanInformation);
            }

            return orderCanInformations;
        }

    }

}