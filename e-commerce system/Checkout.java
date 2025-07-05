public class Checkout {
    public void checkout(Customer customer, Cart cart) {
        double subtotal = 0;
        double totalWeight = 0;
        double shipping = 30;
        if (cart.items.isEmpty()){
            System.out.println("Cart is empty");
            return;
        }
        for (CartItems item : cart.items) {
            Product product = item.getProduct();
            double ordered = item.getOrderedQuantity();
            if (product.requireShipping()) {
                totalWeight += ordered * product.getWeight();
            }
            subtotal += ordered * product.getPrice();
        }

        double totalAmount = subtotal + shipping;

        if (customer.getBalance() >= totalAmount) {
            customer.setBalance(customer.getBalance() - totalAmount);

            System.out.println("** Shipment notice **");
            for (CartItems item : cart.items) {
                Product product = item.getProduct();
                if (product.requireShipping()) {
                    double ordered = item.getOrderedQuantity();
                    double itemTotalWeight = ordered * product.getWeight();
                    System.out.printf("%.0fx %-12s %.0fg\n", ordered, product.name, itemTotalWeight);
                }
            }
            System.out.println("Total package weight " + String.format("%.1f", totalWeight / 1000) + " kg");
            System.out.println();

            System.out.println("** Checkout receipt **");
            for (CartItems item : cart.items) {
                Product product = item.getProduct();
                double ordered = item.getOrderedQuantity();
                double itemTotalPrice = ordered * product.getPrice();
                System.out.printf("%.0fx %-12s %.2f\n", ordered, product.name, itemTotalPrice);
            }
            System.out.println("----------------------");
            System.out.printf("%-15s %.2f\n", "Subtotal", subtotal);
            System.out.printf("%-15s %.2f\n", "Shipping", shipping);
            System.out.printf("%-15s %.2f\n", "Amount", totalAmount);
        } else {
            System.out.println("Insufficient balance. Please add funds.");
        }
    }

    public static void main(String[] args) {
        // Create a customer with initial balance
        Customer customer = new Customer(2000.0);

        // Create products
        Product cheese = new Product("Cheese", 100.0, 10.0, true, 200.0, true);
        Product biscuits = new Product("Biscuits", 150.0, 5.0, false, 700.0, true);
        Product tv = new Product("TV", 500.0, 3.0, false, 5000.0, true);
        Product mobile = new Product("Mobile", 800.0, 2.0, false, 150.0, true);
        Product scratchCard = new Product("Mobile Scratch Card", 10.0, 100.0, false, 0.0, false);
        Product milk = new Product("Milk", 50.0, 8.0, true, 1000.0, true);
        Product giftCard = new Product("Gift Card", 25.0, 50.0, false, 0.0, false);

        // Create a cart
        Cart cart = new Cart();

        // Attempt to add products to the cart
        cart.add(cheese, 2.0);         // Should fail (expired)
        cart.add(biscuits, 1.0);       // Should succeed
        cart.add(tv, 1.0);             // Should succeed
        cart.add(mobile, 1.0);         // Should succeed
        cart.add(scratchCard, 2.0);    // Should succeed
        cart.add(milk, 1.0);           // Should fail (expired)
        cart.add(giftCard, 2.0);       // Should succeed

        // Display initial balance
        System.out.println("Initial balance: " + customer.getBalance());

        // Perform checkout
        Checkout checkout = new Checkout();
        checkout.checkout(customer, cart);

        // Display final balance
        System.out.println("Final balance: " + customer.getBalance());
    }
}