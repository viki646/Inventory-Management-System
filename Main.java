import java.util.Scanner;

public class Main {

    static ItemRepository ir = new ItemRepository();

    public static void main(String[] args) {

        int option;
        boolean isQuit = false;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("***************************");
            System.out.println("Inventory management system");
            System.out.println("***************************");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Display Items");
            System.out.println("4. Quit");
            System.out.print("Select your option: ");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    int id;
                    String name;
                    int price;
                    int stock;

                    System.out.print("Enter item id: ");
                    id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter item name: ");
                    name = sc.nextLine();

                    System.out.print("Enter item price: ");
                    price = sc.nextInt();

                    System.out.print("Enter item stock: ");
                    stock = sc.nextInt();

                    Item item = new Item(id, name, price, stock);
                    ir.addItem(item);
                    System.out.println("Item added successfully!");
                    break;

                case 2:
                    int removeId;
                    System.out.print("Enter item id you want to remove: ");
                    removeId = sc.nextInt();

                    if (!ir.isItemExists(removeId)) {
                        System.out.println("Item does not exist in the inventory");
                        break;   // DO NOT exit program
                    }

                    ir.removeItem(removeId);
                    System.out.println("Item removed successfully!");
                    break;

                case 3:
                    ir.displayItems();
                    break;

                case 4:
                    isQuit = true;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option!");
                    break;
            }
        } while (!isQuit);

        sc.close();
    }
}
