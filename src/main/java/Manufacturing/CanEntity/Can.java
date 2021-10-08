package Manufacturing.CanEntity;



public abstract class Can {
    public String CanName = new String();
    public float Price;
    public float Weight;
    Can(String Name,float Price,float weight ){
        this.CanName = Name;
        this.Price = Price;
        this.Weight = weight;
    }

}
