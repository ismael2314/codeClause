
/**
 * Customer class
 * */
public class Customer {
    private String name;
    private String id;
    private double pockate;
    Customer(){}
    Customer(String id,String name,double pockate){
        this.setId(id);
        this.setName(name);
        this.setPockate(pockate);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public double getPockate() {
        return pockate;
    }
    public void setPockate(double pockate) {
        this.pockate = pockate;
    }
}
