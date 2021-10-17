package Manufacturing.ProductLine.Upstream;

import Manufacturing.ProductLine.ConcretePurchaseDepartment;
import Manufacturing.ProductLine.PurchaseDepartment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * TODO:上游工厂
 * 实现了Observer模式中的Subject
 *
 * @author 香宁雨
 * @since 2021/10/11 23:28
 */

public class ConcreteUpstreamFactory implements UpstreamFactory {
    private String ingredient;

    private Double weight;

    private List<PurchaseDepartment> observers = new ArrayList<PurchaseDepartment>();

    public String getIngredient() {
        return ingredient;
    }

    public Double getWeight() {
        return weight;
    }

    public void setZero() {
        weight = 0.0;
    }

    ConcreteUpstreamFactory() {
        Random r = new Random();
        Integer i = r.nextInt(ingredientType.length);
        this.ingredient = ingredientType[i];
        this.weight = r.nextDouble() * 10;
    }

    private String[] ingredientType = new String[]{"fruit", "vegetable", "meat"};

    @Override
    public void add(PurchaseDepartment observer) {
        observers.add(observer);
    }

    @Override
    public void remove(PurchaseDepartment observer) {
        observers.remove(observer);
    }


    @Override
    public void notifyObserver() {
        for (PurchaseDepartment obs : observers) {
            ((PurchaseDepartment) obs).getInfo(this);
        }
    }

    public static void main(String[] args) {
        UpstreamFactory uf = new ConcreteUpstreamFactory();
        PurchaseDepartment obs1 = new ConcretePurchaseDepartment();
        uf.add(obs1);
        uf.notifyObserver();
    }
}

