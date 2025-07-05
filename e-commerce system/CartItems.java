public class CartItems {
    Product product; 
    double orderedQuantity;
    public CartItems( Product product,double orderedQuantity){
        this.product=product;
        this.orderedQuantity=orderedQuantity;
    }
    
    public Product getProduct() {
        return product;
    }
    public double getOrderedQuantity() {
        return orderedQuantity;
    }
    
    

    
}