


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(""" 
                                                              __      __           .__                                           __           \s
                                                             /  \\    /  \\   ____   |  |     ____     ____     _____     ____   _/  |_    ____ \s
                                                             \\   \\/\\/   / _/ __ \\  |  |   _/ ___\\   /  _ \\   /     \\  _/ __ \\  \\   __\\  /  _ \\\s
                                                              \\        /  \\  ___/  |  |__ \\  \\___  (  <_> ) |  Y Y  \\ \\  ___/   |  |   (  <_> )
                                                               \\__/\\  /    \\___  > |____/  \\___  >  \\____/  |__|_|  /  \\___  >  |__|    \\____/\s
                                                                    \\/         \\/              \\/                 \\/       \\/                 \s
                                                                            ___________                  .__                                  \s
                                                                            \\_   _____/           ______ |  |__     ____   ______             \s
                                                                             |    __)_   ______  /  ___/ |  |  \\   /  _ \\  \\____ \\            \s
                                                                             |        \\ /_____/  \\___ \\  |   Y  \\ (  <_> ) |  |_> >           \s
                                                                            /_______  /         /____  > |___|  /  \\____/  |   __/            \s
                                                                                    \\/               \\/       \\/           |__|               \s
                               
                """);
        System.out.println(".help  .quit .about .list .clearCart .checkout .choose .balance .orders");
        System.setProperty("Data","");
        // ---------------------------------------------------------------------------------
        //
        //
        Customer customer = new Customer("cus-1","someone",3456.23);
        ArrayList<Cart> cart = new ArrayList<>();
        Checkout checkout = new Checkout();
        Store store = __init__();
        boolean quit = false;

        ArrayList<HashMap<Product,Integer>> productsArray = new ArrayList<>();

        while(!quit){

            Scanner scanner = new Scanner(System.in);
            String input= null;
            System.out.printf("%s > ","Main");
            input=scanner.next().toLowerCase();
            switch (input){
                case "q":
                case "quit":
                case ".quit":
                    quit=true;
                    break;
                case ".about":
                case "about":
                    about();
                    break;
                case ".help":
                case "help":
                    help();
                    break;
                case ".list":
                case "list":
                case "ls":
                    productList(store);                                      // ------------------
                    break;
                case "ch":
                case "choose":
                case ".choose":
                    productList(store);
                    System.out.println("******** You can select by product id or product name ********");
                    boolean chooseStop = false;
                    while(!chooseStop){
                        System.out.print("Add to cart | choose > ");
                        String products=scanner.next().toLowerCase();
                        for(Product product: store.getProducts()){
                            if(product.getName().compareTo(products)==0 || product.getId().compareTo(products)==0){
                                Cart addToCart = new Cart();
                                addToCart.setId("cart-1");
                                addToCart.setProduct(product);
                                addToCart.setCustomer(customer);
                                System.out.printf("How much of %s > ",product.getName());
                                addToCart.setQuantity(scanner.nextInt());
                                cart.add(addToCart);
                            }
                        }
                        if (products.compareTo("q")==0){
                            chooseStop=true;
                        }
                        switch (products){
                            case "cls":
                            case ".clear":
                            case "clear":
                            case "clearCart":
                            case ".clearCart":
                                cart.clear();
                                System.out.println("** Cart has been cleared");
                                break;
                        }
                    }
                    break;
                case "cls":
                case ".clear":
                case "clear":
                case "clearCart":
                case ".clearCart":
                    cart.clear();
                    System.out.println("** Cart has been cleared");
                    break;
                case "co":
                case ".checkout":
                case "checkout":
                    System.out.printf("[%d] products being checked out\n",cart.size());
                    HashMap<Product,Integer> hashMapProduct =  new HashMap<>();
                    for(Cart cart1:cart){
                        cart1.checkOut();
                        hashMapProduct.put(cart1.getProduct(),cart1.getQuantity());
                    }
                    productsArray.add(hashMapProduct);
                    checkout.setChekedInfo(customer,productsArray);
                    cart.clear();
                    System.out.println("** Cart has been fully checked out");
                    break;
                case "bl":
                case "balance":
                case ".balance":
                    System.out.printf("****************************************%n");
                    System.out.format("Customer name : %-10s %n",customer.getName().toUpperCase());
                    System.out.format("Balance : %-10.3f %n",customer.getPockate());
                    System.out.printf("****************************************%n");
                    break;
                case "orders":
                case ".orders":
                        if (checkout.getChekedInfo().size()>0){

                            checkout.getChekedInfo().forEach((cust,prod)->{
                                System.out.format("+-----------------+-----------------+-----------------+%n");
                                System.out.format("| %-15s | %-15s | %-15s |%n","Customer","Products","Quantity");
                                System.out.format("+-----------------+-----------------+-----------------+%n");
                                System.out.format("| %-15s | %-15s | %-15s |%n",cust.getName().toUpperCase(),"","");
                                System.out.format("+-----------------+-----------------+-----------------+%n");
                                for(HashMap hp:prod){
                                    hp.forEach((K,V)->{
                                        Product p = (Product) K;
                                        System.out.format("| %-15s | %-15s | %-15d |%n","",p.getName().toUpperCase(),V);
                                        System.out.format("+-----------------+-----------------+-----------------+%n");
                                    });
                                }

                            });
                        }else{
                            System.out.println("********** No orders yet ****************");
                        }
                    break;
                default:
                    System.out.printf("\nThe option [%s] doesn't exits\n",input);
                    break;
            }
        }
        System.gc();
        System.out.println("You have logged out");
    }
    public static Store __init__(){
        ArrayList<Product> products= new ArrayList<>();
        products.add(new Product("pd-1","t-shirt",12.2,100));
        products.add(new Product("pd-2","Mobile",32.2,100));
        products.add(new Product("pd-3","Book",17.2,100));
        products.add(new Product("pd-4","Camera",19.2,100));
        products.add(new Product("pd-5","Wall Photos",112.2,100));
        products.add(new Product("pd-6","Shoes",125.2,100));
        return new Store(products);
    }
    public static void help(){
        System.out.printf("\t code        \t\t Description\n");
        System.out.printf("\t --------------------------------------------------------------------------------------\n");
        System.out.printf("\t ch, choose   \t\t\t|> to choose products and add them to chart\n");
        System.out.printf("\t co, checkout  \t\t\t|> to check out or to pay for the items in cart\n");
        System.out.printf("\t clear,cls, clearCart  \t|> to clear items/products in cart\n");
        System.out.printf("\t ls, list       \t\t|> to  list products in store\n");
        System.out.printf("\t about,         \t\t|> to get information about the creator / developer of the software\n");
        System.out.printf("\t q,quit          \t\t|> to quit the software\n");
        System.out.printf("\t help             \t\t|> to display help\n");
    }
    public static void about(){
        System.out.println(""" 
                        ***************************************");
                        *    Developed by : Ismael yusuf
                        *    Software_Name: E-Shop JavaApp [Console]
                        *   Git hub      : @ismael2314
                        ***************************************""");
    }
    public static void productList(Store store){
        System.out.format("+-----------------------------------------------------+%n");
        System.out.format("| %-15s | %-15s | %-15s |%n","product_id","product_name","product_price");
        System.out.format("+-----------------------------------------------------+%n");
        for(Product product: store.getProducts()){
            System.out.format("| %-15s | %-15s | %-15.3f |%n",product.getId(),product.getName(),product.getPrice());
            System.out.format("+-----------------+-----------------+-----------------+%n");
        }
    }
}