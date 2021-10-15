package Manufacturing.Machine;

/**
 * 出产肉类罐头的机器，运用了工厂模式
 * @author 梁乔 2021/10/10
 **/
public class MeatCanMachine extends Machine {
    private Integer PackagedQualifiedCanNum = 0;

    @Override
    public void createPackedCan() {
        MeatCan mc = new MeatCan();
        //一系列生产线改变mc的状态
        addNewCan(mc);
        PackagedQualifiedCanNum++;
    }
}
