package Management.HumanResources;

import Management.BaseWorker;
import Manufacturing.CanEntity.Can;
import Manufacturing.CanEntity.CanState.CanState;
import Manufacturing.CanEntity.CanState.CannedCanState;
import Manufacturing.CanEntity.CanState.FilledCanState;
import Presentation.Protocol.IOManager;

/**
 * 实现一个封罐工人类，继承自BaseWorker,该工种的职责是将罐头进行封罐
 * @author 梁乔
 * @date 2021/10/11 22:25 
 */
public class CannedWorker extends BaseWorker {

    /**
    * 工种的主要职责函数，通过一系列操作改变罐头的状态
     * @param can : 传入的罐头实体
     * @return : Manufacturing.CanEntity.Can
    * @author 梁乔
    * @date 22:36 2021-10-11
    */
    @Override
    public Can completeWork(Can can) {

        //由于工人是通过操作机器来改变罐头状态的，而机器还未实现，
        //所以工人肯定是通过调用机器的某些接口改变了罐头的状态，具体细节日后商榷
        if(can.getCanState() instanceof FilledCanState){
            //可以进行后续操作
            CannedCanState ccs = new CannedCanState();
            CanState gcs = can.getCanState();
            gcs = ccs;
            IOManager.getInstance().print(
                    "工人"+this.WorkerId+"已经成功将罐头封罐！",
                    "工人"+this.WorkerId+"已經成功將罐頭封罐！",
                    "Worker"+this.WorkerId+"has sucessfully canned the can!"
            );
        }
        else{
            IOManager.getInstance().print(
                    "工人"+this.WorkerId+"封罐失败！封罐前的状态错误！",
                    "工人"+this.WorkerId+"封罐失敗！封罐前的狀態錯誤！",
                    "Worker"+this.WorkerId+"Can sealing failed! Status error before sealing!"
            );
        }
        return can;
    }

    /**
    * 封罐工人的构造函数，获取id，工种名称
     * @return : null
    * @author  梁乔
    * @date 22:51 2021-10-11
    */
    public CannedWorker(){
        BaseWorker.WorkerIdTag++;
        this.WorkerId = BaseWorker.WorkerIdTag;//获取唯一表示的id
        WorkTypeName = "CannedWokerType";
    }

    /**
    * 获取工种名称
     * @return : java.lang.String
    * @author 梁乔
    * @date 23:00 2021-10-11
    */
    public String getWorkTypeName(){
        return WorkTypeName;
    }
}