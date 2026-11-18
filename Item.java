public class Item {
    public int id;
    public String name;
    public int price;
    public int stock;

    Item(int id, String name, int price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;

        if (stock < 0) {
            System.out.println("Invalid stock. Setting stock = 0");
            this.stock = 0;
        } else {
            this.stock = stock;
        }
    }

    public void displayInfo() {
        System.out.printf("Id: %d, Name: %s, Price: %d, Stock: %d\n",
                id, name, price, stock);
    }

    public boolean isAvailable() {
        return stock > 0;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            System.out.println("Invalid stock");
            return;
        }
        this.stock = stock;
    }
}
