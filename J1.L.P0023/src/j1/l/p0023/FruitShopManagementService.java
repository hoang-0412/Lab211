package j1.l.p0023;

import java.util.ArrayList;
import java.util.HashMap;

public class FruitShopManagementService {

    private final Validation val = new Validation();
    private final HashMap<String, ArrayList<OrderItem>> order = new HashMap<>();
    private final static ArrayList<Fruit> fruits = new ArrayList<>();
    private final static ArrayList<OrderItem> orders = new ArrayList<>();

    public FruitShopManagementService() {
        fruits.add(new Fruit("F01", "Apple", 10, 100, "USA"));
        fruits.add(new Fruit("F02", "Banana", 5, 150, "Vietnam"));
        fruits.add(new Fruit("F03", "Orange", 8, 120, "Australia"));
        fruits.add(new Fruit("F04", "Mango", 12, 80, "Thailand"));
        fruits.add(new Fruit("F05", "Grape", 15, 90, "France"));
        fruits.add(new Fruit("F06", "Pineapple", 7, 70, "Philippines"));
        fruits.add(new Fruit("F07", "Watermelon", 6, 60, "Vietnam"));
        fruits.add(new Fruit("F08", "Strawberry", 20, 50, "Korea"));
        fruits.add(new Fruit("F09", "Peach", 18, 40, "Japan"));
        fruits.add(new Fruit("F10", "Cherry", 25, 30, "USA"));
    }

    public boolean checkFruitExist1(String id, String name, int price, int quantity, String origin) {
        for (Fruit fruit : fruits) {
            if (name.equalsIgnoreCase(fruit.getName())
                    && price == fruit.getPrice()
                    && quantity == fruit.getQuantity()
                    && origin.equals(fruit.getOrigin())) {
                return false;
            }
        }
        return true;
    }

    public Fruit checkFruitExist2(String name, int price, String origin) {
        for (Fruit fruit : fruits) {
            if (name.equalsIgnoreCase(fruit.getName())
                    && price == fruit.getPrice()
                    && origin.equalsIgnoreCase(fruit.getOrigin())) {
                return fruit;
            }
        }
        return null;
    }

    public boolean CreateFruit(String id, String name, int price, int quantity, String origin) {
        if (!checkFruitExist1(id, name, price, quantity, origin)) {
            System.out.println("This record was existed. Please enter again");
            return false;
        }

        Fruit existedFruit = checkFruitExist2(name, price, origin);
        if (existedFruit != null) {
            System.out.println("Fruit already exists in stock!");
            System.out.println("Current fruit information:");
            System.out.println(existedFruit);

            System.out.print("Do you want to add quantity for this fruit (Y/N)? ");
            if (val.checkInputYN()) {
                existedFruit.setQuantity(existedFruit.getQuantity() + quantity);
                System.out.println("Update quantity successfully!");
                return true;
            } else {
                System.out.println("Do not add quantity.");
                return false;
            }
        }

        fruits.add(new Fruit(id, name, price, quantity, origin));
        return true;
    }

    public void DisplayStock() {
        if (fruits.isEmpty()) {
            System.out.println("No products in the stock!");
            return;
        }

        System.out.printf("%-15s | %-15s | %-15s | %-15s | %-15s\n", "ID", "Name", "Price", "Quantity", "Origin");
        for (int i = 0; i < fruits.size(); i++) {
            System.out.println(fruits.get(i));
        }
    }

    public void DisplayShopping() {
        if (fruits.isEmpty()) {
            System.out.println("No products in the stock!");
            return;
        }

        System.out.printf("%-15s | %-15s | %-15s | %-15s\n", "++Item++", "++Fruit Name++", "++Origin++", "++Price++");
        for (int i = 0; i < fruits.size(); i++) {
            System.out.printf("%-15d | %-15s | %-15s | %-15s\n", i + 1, fruits.get(i).getName(), fruits.get(i).getOrigin(), fruits.get(i).getPrice() + "$");
        }
    }

    public void DisplayOrder(ArrayList<OrderItem> order) {
        int total = 0;
        if (order.isEmpty()) {
            System.out.println("You have not orderred any things yet!");
            return;
        }
        System.out.printf("%-15s | %-15s | %-15s | %-15s\n", "Product", "Quantity", "Price", "Amount");
        for (int i = 0; i < order.size(); i++) {
            System.out.println(order.get(i));
            total += order.get(i).Amount();
        }
        System.out.println("Total: " + total + "$");
    }

    public void Shopping() {
        while (true) {
            DisplayShopping();
            System.out.print("Choose the item you want to buy: ");
            int item = val.CheckChoice(1, fruits.size());
            Fruit fruitSelected = fruits.get(item - 1);
            System.out.println("You selected: " + fruitSelected.getName());
            for (Fruit fruit : fruits) {
                System.out.print("There are " + fruitSelected.getQuantity() + " " + fruitSelected.getName() + "(s) in the stock. Please input quantity: ");
                int quantity = val.InputInt();
                if (fruitSelected.getQuantity() >= quantity) {
                    OrderItem OI = new OrderItem(fruitSelected, quantity);
                    boolean found = false;
                    for (int i = 0; i < orders.size(); i++) {
                        if (orders.get(i).getF().getId().equalsIgnoreCase(fruitSelected.getId())
                                && orders.get(i).getF().getName().equalsIgnoreCase(fruitSelected.getName())) {
                            found = true;
                            orders.get(i).setQuantity(orders.get(i).getQuantity() + quantity);
                        }
                    }
                    if (!found) {
                        orders.add(OI);
                    }
                    fruits.get(item - 1).setQuantity(fruitSelected.getQuantity() - quantity);
                    System.out.println("Do you want to order now (Y/N)?");
                    System.out.println("Your choice: ");
                    if (val.checkInputYN()) {
                        DisplayOrder(orders);
                        System.out.print("Input your name: ");
                        String customer = val.InputString();
                        order.put(customer, orders);
                        System.out.println("Save order successfully!");
                        break;
                    } else {
                        return;
                    }
                } else {
                    System.out.println(fruitSelected.getName() + "is sold out, please choose another product !");
                }
            }
            break;
        }
    }

    public void viewOder(String name) {
        if (order.containsKey(name)) {
            DisplayOrder(order.get(name));
        } else {
            System.out.println("This customer hasn't ordered any things yet!");
        }
    }
}
