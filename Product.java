import java.util.ArrayList;
import java.util.List;

public class Product {
        private int id;
        private String name;
        private String category;
        private double price;
        private int stockQuantity;

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getCategory() { return category; }
        public void setCategory(String category) { this.category = category; }

        public double getPrice() { return price; }
        public void setPrice(double price) { this.price = price; }

        public int getStockQuantity() { return stockQuantity; }
        public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }

        public void displayInfo() {
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Category: " + category);
            System.out.println("Price: " + price);
            System.out.println("Stock Quantity: " + stockQuantity);
        }
        public static class Customer {
            private int id;
            private String firstname;
            private String lastname;
            private String email;
            private boolean isLoyalCustomer;

            public int getId() {return id; }
            public void setId(int id) { this.id = id; }

            public String getFirstname() {return firstname; }
            public void setFirstname(String firstname) { this.firstname = firstname; }

            public String getLastname() {return lastname; }
            public void setLastname(String lastname) { this.lastname = lastname; }

            public String getEmail() {return email; }
            public void setEmail(String email) { this.email = email; }

            public boolean getIsLoyalCustomer() {return isLoyalCustomer; }
            public void setIsLoyalCustomer(boolean isLoyalCustomer) { this.isLoyalCustomer = isLoyalCustomer; }

            public void displayInfo(){
                System.out.println("ID: " + id);
                System.out.println("Name: " + firstname + " " + lastname);
                System.out.println("Email: " + email);
                System.out.println("Loyal Customer: " + (isLoyalCustomer ? "Yes" : "No"));
            }
            public static class Order {
                private int id;
                private Customer customer;
                private Product[] products;
                private int[] quantities;
                private String orderDate;
                private String status;

                public int getId() {return id;}
                public void setId(int id) {this.id = id;}

                public Customer getCustomer() {return customer;}
                public void setCustomer(Customer customer) {this.customer = customer;}

                public Product[] getProducts() {return products;}
                public void setProducts(Product[] products) {this.products = products;}

                public int[] getQuantities() {return quantities;}
                public void setQuantities(int[] quantities) {this.quantities = quantities;}

                public String getOrderDate() {return orderDate;}
                public void setOrderDate(String orderDate) {this.orderDate = orderDate;}

                public String getStatus() {return status;}
                public void setStatus(String status) {this.status = status;}

                public double calculateTotalValue() {
                    double total = 0;
                    for (int i = 0; i < products.length; i++) {
                        total += products[i].getPrice() * quantities[i];
                    }
                    return total;
                }
                public void applyDiscount() {
                    if (customer.getIsLoyalCustomer()){
                        double total = calculateTotalValue();
                        double discount = total * 0.1;
                        System.out.println("Discount applied: " + discount);
                    }
                }

                public void displayDetails() {
                    System.out.println("Order ID: " + id);
                    System.out.println("Customer: " + customer.getFirstname() + " " + customer.getLastname());
                    System.out.println("Status: " + status);
                    System.out.println("Products in order: ");
                    for (int i = 0; i < products.length; i++) {
                        System.out.println(products[i].getName() + " - Quantity: " + quantities[i]);
                    }
                    System.out.println("Total: " + calculateTotalValue());
                }
                public static class ComputerStore {
                    private List<Product> products = new ArrayList<>();
                    private List<Customer> customers = new ArrayList<>();
                    private List<Order> orders = new ArrayList<>();

                    public void addProduct(Product product) {
                        products.add(product);
                    }

                    public void addCustomer(Customer customer) {
                        customers.add(customer);
                    }

                    public Order createOrder(Customer customer, Product[] product, int[] quantities) {
                        Order order = new Order();
                        order.setId(orders.size() + 1);
                        order.setCustomer(customer);
                        order.setProducts(product);
                        order.setQuantities(quantities);
                        order.setOrderDate("2025-03-27");
                        order.setStatus("New");
                        orders.add(order);
                        return order;
                    }
                    public void updateStockAfterOrder(Order order){
                        for (int i = 0; i < order.getProducts().length; i++) {
                            Product product = order.getProducts()[i];
                            int quantityOrdered = order.getQuantities()[i];
                            product.setStockQuantity(product.getStockQuantity() - quantityOrdered);
                        }
                    }
                    public void changeOrderStatus(int orderId, String newStatus){
                        for(Order order : orders){
                            if (order.getId() == orderId){
                                order.setStatus(newStatus);
                            }
                        }
                    }
                    public void displayProductsInCategory(String category){
                        System.out.println("Products in " + category + " category:");
                        for (Product product : products) {
                            if (product.getCategory().equalsIgnoreCase(category)) {
                                product.displayInfo();
                            }
                        }
                    }
                    public void displayCustomerOrders(int customerId){
                        System.out.println("Orders for customer with ID: " + customerId);
                        for (Order order : orders) {
                            if (order.getCustomer().getId() == customerId) {
                                order.displayDetails();
                            }
                        }
                    }
                    
                }
            }
        }
    }