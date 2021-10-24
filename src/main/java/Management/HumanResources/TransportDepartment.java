package Management.HumanResources;

import Management.HumanResources.Manager.TransportManager;
import Presentation.Protocol.OutputManager;
import Storage.TransportationCan;


/**
 * 运输部门
 *
 * @author 吴英豪
 * @since 2021/10/24 09:52
 */
public class TransportDepartment extends BaseDepartment {

    private TransportDepartment() {

        //TODO:这里需要修改一个运输部门的Type，为了防止Confilct 这里暂时还没有写
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
     */
    public void transportCans(TransportationCan transportationCan) {
        OutputManager.getInstance().print(
                "运输部正在准备运输罐头......",
                "運輸部正在準備運輸罐頭......",
                "The transportDepartment is preparing to transport the cans......"
        );
        this.transportManager.transport(transportationCan);
    }

    // 运输部经理
    private final TransportManager transportManager;
    //采购部门实体
    static private TransportDepartment instance;

}





