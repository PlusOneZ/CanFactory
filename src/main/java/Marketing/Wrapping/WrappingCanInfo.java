package Marketing.Wrapping;


import Manufacturing.Ingredient.Ingredient;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * TODO：罐头属性的添加，如生产日期，保质期
 * @Author 王立友
 * 包装封面中罐头的实体信息属性,如名称，质量，原料
 * TODO: 根据罐头的类别编号确定背景颜色(背景图url) 桥接模式
 */

public class WrappingCanInfo {

    /**
     * 罐头中文名字;
     */
    private String canName;

    /**
     * 罐头尺寸
     */
    private int size;
    /**
     * 罐头原料表
     */
    private List<Ingredient> ingredients;
    /**
     * 罐头保质期
     */
    private LocalDate shelfTime;
    /**
     * 罐头生产日期
     */
    private LocalDate manufactureTime;


    public String getCanName() {
        return canName;
    }

    /***************** setter and getter ******************/
    public void setCanName(String canName) {
        this.canName = canName;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public LocalDate getShelfTime() {
        return shelfTime;
    }

    public void setShelfTime(LocalDate shelfTime) {
        this.shelfTime = shelfTime;
    }

    public LocalDate getManufactureTime() {
        return manufactureTime;
    }

    public void setManufactureTime(LocalDate manufactureTime) {
        this.manufactureTime = manufactureTime;
    }
}
