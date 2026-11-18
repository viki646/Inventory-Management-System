import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    private static final String FILE_NAME = "items.txt";

    // Save items to file
    public static void saveItems(ArrayList<Item> items) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {

            for (Item i : items) {
                writer.println(i.id + "," + i.name + "," + i.price + "," + i.stock);
            }

        } catch (Exception e) {
            System.out.println("Error saving items: " + e.getMessage());
        }
    }

    // Load items from file
    public static ArrayList<Item> loadItems() {
        ArrayList<Item> items = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int price = Integer.parseInt(data[2]);
                int stock = Integer.parseInt(data[3]);

                items.add(new Item(id, name, price, stock));
            }

        } catch (FileNotFoundException e) {
            // File not present first time → ignore
        } catch (Exception e) {
            System.out.println("Error loading items: " + e.getMessage());
        }

        return items;
    }
}

