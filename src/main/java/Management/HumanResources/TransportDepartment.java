package Management.HumanResources;

import Management.HumanResources.Manager.TransportManager;
import Marketing.OrderCenterEntity.OrderCenter;
import Marketing.OrderCenterEntity.OrderProcessingCenter;
import Marketing.OrderEnity.Order;
import Presentation.Protocol.OutputManager;

import java.util.List;

/**
 * 运输部门
 *
 * @author 吴英豪
 * @since 2021/10/24 09:52
 */
public class TransportDepartment extends BaseDepartment {

    private TransportDepartment() {

        this.type = DepartmentType.None;

        this.transportManager = new TransportManager();

        OutputManager.getInstance().print(
                "新建了一个运输部门",
                "新建了一個運輸部門",
                "A new transport department has been created"
        );
    }

    /**
     * 运输部门单例模式
     */
    public static TransportDepartment getInstance() {
        if (instance == null) {
            instance = new TransportDepartment();
        }
        return instance;
    }

    /**
     * 运输部门运输罐头
     *
     * @return 运输是否成功
     */
    public boolean transportCans(List<Order> orderList) {
        OutputManager.getInstance().print(
                "从订单中心获取订单......",
                "從訂單中心獲取訂單......",
                "From OrderProcessingCenter Getting Orders......"
        );
        return this.transportManager.transport(orderList);
    }

    // 运输部经理
    private final TransportManager transportManager;
    //采购部门实体
    static private TransportDepartment instance;


    /**
     * TODO: 可能需要单独提出来作为一个测试类
     * 运输罐头过程测试函数
     *
     * @author 吴英豪
     * @since 2021/10/24
     */
    public static void main(String[] args) {
        OutputManager.getInstance().setLanguage(OutputManager.Lang.zh_CN);

        if (TransportDepartment.getInstance().transportCans(OrderProcessingCenter.getPendingOrders())) {
            OutputManager.getInstance().print(
                    "运输成功!",
                    "運輸成功!",
                    "Transporting Success! "
            );
        } else {
            OutputManager.getInstance().print(
                    "运输失败!",
                    "運輸失敗!",
                    "Transporting Failed!"
            );
        }
    }
}





