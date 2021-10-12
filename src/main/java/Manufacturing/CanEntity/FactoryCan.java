package Manufacturing.CanEntity;

import Manufacturing.CanEntity.Material.Material;
import Manufacturing.CanEntity.Size.Size;

import java.util.Date;

/**
 * 桥接模式（Bridge）
 * 实现罐头的属性：大小、口味、颜色
 * @author 汪明杰
 */
public abstract class FactoryCan extends Can{

    // 保质时间
    protected Date shelfTime;

    // 生产时间
    protected Date manufactureTime;

    // 最高储存温度
    protected int maxTemperature;

    //最低储存温度
    protected int minTemperature;

    public FactoryCan(Size s, Material c){
        System.out.println("# 使用桥接模式(Bridge)");
        System.out.printf("# 创建了一个");
        setSize(s);
        if(s.isLarge()){
            System.out.printf("大的");
        }
        else{
            System.out.printf("小的");
        }

        setMaterial(c);
        if (c.getType() == Material.MATERIAL.ALLOY){
            System.out.printf("铝制的");
        }
        else if (c.getType() == Material.MATERIAL.IRON){
            System.out.printf("铁制的");
        }
        else {
            System.out.printf("合金的");
        }

        System.out.println("的罐头");
    }

    // 是否过期
    public boolean isOverdue(){
        // TODO: 获取公有类的当前时间后，判断罐头是否过期

        return true;
    }

    // 判断储存温度是否合适
    public boolean isTemperatureAppropriate(){
        // TODO: 获取储存箱的温度，判断储存环境是否合适
        return true;
    }


}
