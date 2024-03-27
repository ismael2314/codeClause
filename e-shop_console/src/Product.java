public class Product {
    private String name;
    private String id;
    private int quantity;
    private double price;
    Product(){
        System.out.println("");

    }
    Product(String id,String name,double price,int quantity){
        this.setId(id);
        this.setPrice(price);
        this.setQuantity(quantity);
        this.setName(name);
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
