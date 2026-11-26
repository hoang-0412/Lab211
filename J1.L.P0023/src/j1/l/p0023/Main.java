package j1.l.p0023;

public class Main {

    private static Validation val = new Validation();
    private static FruitShopManagementService fsms = new FruitShopManagementService();

    public static void displayMenu() {
        System.out.println("FRUIT SHOP SYSTEM");
        System.out.println("1. Create Fruit");
        System.out.println("2. View orders");
        System.out.println("3. Shopping(for buyer)");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void authCreateFruit() {
        while (true) {
            System.out.print("Enter ID : ");
            String id = val.InputString();

            System.out.print("Enter name: ");
            String name = val.InputString();

            System.out.print("Enter price: ");
            int price = val.InputInt();

            System.out.print("Enter quantity: ");
            int quantity = val.InputInt();

            System.out.print("Enter origin: ");
            String origin = val.InputString();

            boolean isExisted = fsms.CreateFruit(id, name, price, quantity, origin);
            if (isExisted) {
                System.out.println("Do you want to continue(Y/N)?");
                if (!val.checkInputYN()) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = val.CheckChoice(1, 5);
            switch (choice) {
                case 1:
                    authCreateFruit();
                    fsms.DisplayStock();
                    break;

                case 2:
                    System.out.print("Customer: ");
                    String name = val.InputString();
                    fsms.viewOder(name);
                    break;

                case 3:
                    fsms.Shopping();
                    break;

                case 4:
                    return;
            }
        }
    }
}
