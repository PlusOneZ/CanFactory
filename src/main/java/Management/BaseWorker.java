package Management;

import Manufacturing.CanEntity.Can;

/**
 * 工种类，为抽象类，表示罐头生产线工作的基本工种
 * 该继承体系实现了原型模式。
 * @author 梁乔
 * @date 2021/10/11 22:01 
 */
public abstract class BaseWorker implements Cloneable{
    /**
     * 工种名称
     */
    protected String WorkTypeName;
    /**
     * 工种id标识，用于实现每增加一个工人，其Id递增且唯一
     */
    public static Integer WorkerIdTag = 0;
    /**
     * 工人的Id，唯一标识每一个工人对象
     */
    protected Integer WorkerId;

    /**
    * 考虑到罐头为流水线生产，每个工种只完成特定的一步的工作，
     * 因此每一个工人的职能称为完成工作。
     * @param can : 传入特定的Can类的子类
     * @return : Manufacturing.CanEntity.Can
    * @author 梁乔
    * @date 22:12 2021-10-11
    */
    public abstract Can completeWork(Can can);

    /**
    * 获取该工种工人的id
     * @return : java.lang.Integer
    * @author 梁乔
    * @date 22:10 2021-10-11
    */
    public Integer getId(){
        return WorkerId;
    }

    /**
    * 原型模式主要函数，使用克隆方法快速新建一个实例
     * @return : java.lang.Object
    * @author 梁乔
    * @date 22:21 2021-10-11
    */
    public Object clone(){
        Object clone = null;
        try{
            clone = super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return clone;
    }


}