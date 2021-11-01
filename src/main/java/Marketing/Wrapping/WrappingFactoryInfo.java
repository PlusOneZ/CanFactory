package Marketing.Wrapping;


/**
 * @Author 王立友
 * 包装纸中表现得厂家基础属性信息
 * 由于基础信息不会发生变化，因此采用单例模式创建
 */
public class WrappingFactoryInfo {

    private String factoryName;
    private String factoryPhone;
    private String factoryAddress;
    private String factoryWebsite;
    private String factoryTip;

    private static final WrappingFactoryInfo instance = new WrappingFactoryInfo();

    private WrappingFactoryInfo(){
        this.factoryName = "罐头加工厂";
        this.factoryPhone = "400-8888888";
        this.factoryAddress = "上海市嘉定区";
        this.factoryWebsite = "www.tongji.edu.cn";
        this.factoryTip = "适合常温或冷藏食用，避免曝晒、高温或冰冻。";
    }

    public static WrappingFactoryInfo getInstance(){
        return instance;
    }

    public void setFactoryAddress(String factoryAddress) {
        this.factoryAddress = factoryAddress;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public void setFactoryPhone(String factoryPhone) {
        this.factoryPhone = factoryPhone;
    }

    public void setFactoryTip(String factoryTip) {
        this.factoryTip = factoryTip;
    }

    public void setFactoryWebsite(String factoryWebsite) {
        this.factoryWebsite = factoryWebsite;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public String getFactoryPhone() {
        return factoryPhone;
    }

    public String getFactoryAddress() {
        return factoryAddress;
    }

    public String getFactoryWebsite() {
        return factoryWebsite;
    }

    public String getFactoryTip() {
        return factoryTip;
    }
}