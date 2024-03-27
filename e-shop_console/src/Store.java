import java.util.ArrayList;

public class Store {

    private ArrayList<Product> products;
    private ArrayList<Customer> customers;

    Store(){
        System.out.printf("********************* %s %d *********************","Store",1);
    }
    Store(Product product,Customer customer){
        this.getProducts().add(product);
        this.getCustomers().add(customer);
    }
    Store(Product product){
        this.getProducts().add(product);
    }
    Store(ArrayList<Product> products){
        this.products=products;
    }
    Store(Customer customer){
        this.getCustomers().add(customer);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products.add(products);
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Customer customers) {
        this.customers.add(customers);
    }
}
