import java.util.ArrayList;


public class Cart {
    ArrayList<CartItems> items =new ArrayList<>();

    public void add(Product product,double quantity ){
        if (product.checkQuantity(quantity) && !product.isExpired()) {
            double newQuantity=product.getQuantity()-quantity;
            product.setQuantity(newQuantity);
            items.add(new CartItems(product,quantity));

        }
        else {
             System.out.println("Not enough quantity for: " + product.name);
        }
    }    
}



