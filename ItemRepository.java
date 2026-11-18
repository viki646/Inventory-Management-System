import java.util.ArrayList;

public class ItemRepository {

    private ArrayList<Item> items = new ArrayList<>();

    ItemRepository() {
        items = FileHandler.loadItems(); // load items when program starts
    }

    public void addItem(Item item) {
        items.add(item);
        FileHandler.saveItems(items);  // save after adding
    }

    public boolean isItemExists(int id){
        for (Item item : items) {
            if (item.id == id) {
                return true;
            }
        }
        return false;
    }

    public void removeItem(int id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).id == id) {
                items.remove(i);
                break;
            }
        }
        FileHandler.saveItems(items);  // save after deleting
    }

    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("No items in the inventory");
            return;
        }

        System.out.println("**********************");
        System.out.println("Items in the inventory");
        for (Item i : items) {
            i.displayInfo();
            System.out.println();
        }
        System.out.println("**********************");
    }
}
