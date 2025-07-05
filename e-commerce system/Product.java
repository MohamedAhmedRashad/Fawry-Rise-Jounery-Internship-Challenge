public class Product {
    String name;
    double price;
    double quantity;
    boolean expired;
    double weight;
    boolean shipping;
    public Product(String name, double price, double quantity, boolean expired, double weight, boolean shipping) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expired = expired;
        this.weight = weight;
        this.shipping = shipping;
    }

    public boolean checkQuantity(double quantity){
        return (quantity<=this.quantity);
    }
    
    public double getQuantity() {
        return quantity;
    }
    public double getPrice() {
        return price;
    }
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    public boolean isExpired() {
        return expired;
    }
    public boolean requireShipping() {
        return shipping;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Product [name=" + name + ", price=" + price + ", quantity=" + quantity + ", expired=" + expired
                + ", weight=" + weight + ", shipping=" + shipping + "]";
    }
    
}

