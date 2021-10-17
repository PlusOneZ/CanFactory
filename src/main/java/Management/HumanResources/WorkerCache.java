package Management.HumanResources;

import Management.BaseWorker;
import Manufacturing.CanEntity.Can;

import java.util.Hashtable;

/**


/**
 * 工种cache类，用于获取工种实例，并将其存储在哈希表中
 * @author 梁乔
 * @date 2021/10/11 22:52 
 */
public class WorkerCache {
    /**
     * 存储各工种名称对应关系的哈希标
     */
    private static Hashtable<String, BaseWorker> WorkerMap
            = new Hashtable<String,BaseWorker>();

    /**
    * 使用原型模式快速创建工人实体
     * @param workerTypeName : 要创建的工人实体的工种名称
     * @return : Management.BaseWorker
    * @author 梁乔
    * @date 22:56 2021-10-11
    */
    public static BaseWorker getWorker(String workerTypeName){
        BaseWorker cachedBaseWorker = WorkerMap.get(workerTypeName);
        return (BaseWorker) cachedBaseWorker.clone();
    }

    public static void loadWorkerTypeCache(){
        CannedWorker cw = new CannedWorker();
        WorkerMap.put(cw.getWorkTypeName(),cw);
    }

}