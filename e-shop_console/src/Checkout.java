import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Checkout {

    private Map<Customer, ArrayList<HashMap<Product,Integer>>> chekedInfo = new HashMap<>();  // every information about checked out products

    public void setChekedInfo (Customer customer,ArrayList<HashMap<Product,Integer>> prod){
        this.chekedInfo.put(customer,prod);
    }

    public Map<Customer, ArrayList<HashMap<Product,Integer>>> getChekedInfo() {
        return chekedInfo;
    }

}
