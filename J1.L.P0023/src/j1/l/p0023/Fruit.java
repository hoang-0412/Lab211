package j1.l.p0023;

public class Fruit {

    String id, name;
    int price, quantity;
    String origin;

    Fruit() {
    }

    public Fruit(String id, String name, int price, int quantity, String origin) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return String.format("%-15s | %-15s | %-15s | %-15d | %-15s", this.id, this.name, this.price + "$", this.quantity, this.origin);
    }
}
