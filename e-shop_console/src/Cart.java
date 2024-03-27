import java.util.Date;

public class Cart {

    private String id;
    private Product product;
    private Customer customer;
    private int quantity;

    Cart(){

    }
    Cart(String id,Product product,Customer customer,int quantity){
        this.setId(id);
        this.setCustomer(customer);
        this.setProduct(product);
        this.setQuantity(quantity);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
        // Check out Method
    public void checkOut(){
        if(this.getProduct().getQuantity()> this.getQuantity()){
            double calculatePrice = this.getProduct().getPrice()*this.getQuantity();
            if (calculatePrice < this.getCustomer().getPockate()){
                int newQuantity = this.getProduct().getQuantity()-this.getQuantity();
                double newWallet = this.getCustomer().getPockate()-calculatePrice;

                this.getProduct().setQuantity(newQuantity);
                this.getCustomer().setPockate(newWallet);

                System.out.printf("\t************ Check out success full [%s] ************\n",this.getProduct().getName());
                System.out.printf("\t:Date: %s\n",new Date().toString());
                System.out.printf("\t*** Customer       : %s\n",this.getCustomer().getName());
                System.out.printf("\t*** Products Name  : %s\n",this.getProduct().getName());
                System.out.printf("\t*** ItemPrice      : %f\n",this.getProduct().getPrice());
                System.out.printf("\t*** Quantity       : %d\n",this.getQuantity());
                System.out.printf("\t*** TotalPrice     : %f\n",calculatePrice);
                System.out.printf("\t************************************************\n");
            }else{
                System.out.printf("\t********************************************************************************************\n");
                System.out.printf("\t\tYou don't have enough money to check out the products\nWallet : %f\nProduct price: %f\n"
                        ,this.getCustomer().getPockate(),calculatePrice);
                System.out.printf("\t\tProducts : %s%n",this.getProduct().getName());
                System.out.printf("\t\tProducts : %d%n",this.getQuantity());
                System.out.printf("\t********************************************************************************************\n");
            }
        }else{
            System.err.printf("\t[%s] Product quantity exceeded the stock limit",product.getName());
        }

    }
}
