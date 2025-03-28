public class main {
        public static void main(String[] args) {
            Product.Customer.Order.ComputerStore store;
            store = new Product.Customer.Order.ComputerStore();


            Product product1 = new Product();
            product1.setId(1);
            product1.setName("Laptop Dell XPS 13");
            product1.setCategory("Laptop");
            product1.setPrice(4999.99);
            product1.setStockQuantity(10);

            Product product2 = new Product();
            product2.setId(2);
            product2.setName("Mouse Logitech MX Master 3");
            product2.setCategory("Mouse");
            product2.setPrice(349.99);
            product2.setStockQuantity(30);

            Product product3 = new Product();
            product3.setId(3);
            product3.setName("Monitor Samsung 27\"");
            product3.setCategory("Monitor");
            product3.setPrice(1299.99);
            product3.setStockQuantity(15);

            store.addProduct(product1);
            store.addProduct(product2);
            store.addProduct(product3);


            Product.Customer customer1 = new Product.Customer();
            customer1.setId(1);
            customer1.setFirstname("John");
            customer1.setLastname("Smith");
            customer1.setEmail("john.smith@example.com");
            customer1.setIsLoyalCustomer(true);

            Product.Customer customer2 = new Product.Customer();
            customer2.setId(2);
            customer2.setFirstname("Anna");
            customer2.setLastname("Brown");
            customer2.setEmail("anna.brown@example.com");
            customer2.setIsLoyalCustomer(false);

            store.addCustomer(customer1);
            store.addCustomer(customer2);

            Product[] orderProducts1 = {product1, product2};
            int[] orderQuantities1 = {1, 1};
            Product.Customer.Order order1 = store.createOrder(customer1, orderProducts1, orderQuantities1);
            order1.applyDiscount();
            store.updateStockAfterOrder(order1);

            System.out.println("Order details:");
            order1.displayDetails();
            System.out.println("\nStock levels after the order:");
            store.displayProductsInCategory("Laptop");
            store.displayProductsInCategory("Mouse");

            store.changeOrderStatus(order1.getId(), "Completed");
            System.out.println("\nOrder status after update:");
            order1.displayDetails();

            Product[] orderProducts2 = {product1, product2};
            int[] orderQuantities2 = {2, 1};
            Product.Customer.Order order2 = store.createOrder(customer2, orderProducts2, orderQuantities2);
            store.updateStockAfterOrder(order2);

            System.out.println("\nOrders of John Smith:");
            store.displayCustomerOrders(1);
        }
    }
