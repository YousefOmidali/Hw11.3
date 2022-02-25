import java.sql.Date;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class main {
    public static void main(String[] args) {
        List<Order> orderList = new ArrayList<>();
        Customer customer1 = new Customer("Yousef");
        Customer customer2 = new Customer("Ali");
        Customer customer3 = new Customer("Mahdi");
        Customer customer4 = new Customer("Javad");
        Customer customer5 = new Customer("Farid");

        Category category1 = new Category(1, "Shoes", "Man shoe");
        Category category2 = new Category(2, "T-Shirt", "Man t-shirt");
        Category category3 = new Category(3, "hoodies", "lady hoodies");
        Category category4 = new Category(4, "book", "Book");

        Product product1 = new Product("melli Sneakers", 120000, category1);
        Product product2 = new Product("NY t-shirt", 100000, category2);
        Product product3 = new Product("NY hoodie", 200000, category3);
        Product product4 = new Product("java at home", 50000, category4);
        Product product5 = new Product("NY Sneakers", 127500, category1);

        Order order1 = new Order(customer1, product1, Date.valueOf("2022-02-15"));
        Order order2 = new Order(customer2, product2, Date.valueOf("2022-02-07"));
        Order order3 = new Order(customer3, product3, Date.valueOf("2022-01-29"));
        Order order4 = new Order(customer3, product4, Date.valueOf("2022-02-29"));
        Order order5 = new Order(customer4, product5, Date.valueOf("2022-02-01"));
        Order order6 = new Order(customer5, product5, Date.valueOf("2022-02-23"));

        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);
        orderList.add(order4);
        orderList.add(order5);
        orderList.add(order6);
        //--------------------------------------------------------------------------------------
        //a
        System.out.println("Orders with filter(only shoes):");
        orderList.stream()
                .filter(order -> order.getProduct().getCategory().getId() == 1)
                .forEach(a -> System.out.println(a));
        //--------------------------------------------------------------------------------------
        //b
        System.out.println("******************************************************************************************************************************************************************************************");
        Date startDate = Date.valueOf("2022-01-25");
        Date endDate = Date.valueOf("2022-02-25");
        System.out.println("orders between " + startDate + " and " + endDate + " : ");
        orderList.stream()
                .filter(order -> order.getOrderDate().after(startDate) && order.getOrderDate().before(endDate))
                .forEach(a -> System.out.println(a));

        //-------------------------------------------------------------------------------
        //c
        System.out.println("******************************************************************************************************************************************************************************************");
        System.out.println("cheapest product: ");
        System.out.println(orderList.stream()
                .min(Comparator.comparing(order -> order.getProduct().getPrice())));

        System.out.println("cheapest product of category: ");
        System.out.println(orderList.stream().filter(order -> order.getProduct().getCategory().getId() == 1)
                .min(Comparator.comparing(order -> order.getProduct().getPrice())));

        //------------------------------------------------------------------------------------
        //d
        System.out.println("******************************************************************************************************************************************************************************************");
        Date startDateOfAvg = Date.valueOf("2022-01-25");
        Date endDateOfAvg = Date.valueOf("2022-02-25");
        System.out.println("average of sales from " + startDateOfAvg + " to " + endDateOfAvg);
        System.out.println(orderList.stream()
                .filter(order -> order.getOrderDate().after(startDate) && order.getOrderDate().before(endDate))
                .mapToDouble(order -> order.getProduct().getPrice()).average() );

    }
}
