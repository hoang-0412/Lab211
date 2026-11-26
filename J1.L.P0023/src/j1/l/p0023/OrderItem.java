package j1.l.p0023;

public class OrderItem {

    Fruit f;
    int quantity;

    public OrderItem(Fruit f, int quantity) {
        this.f = f;
        this.quantity = quantity;
    }

    public Fruit getF() {
        return f;
    }

    public void setF(Fruit f) {
        this.f = f;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int Amount() {
        return this.quantity * this.f.getPrice();
    }

    @Override
    public String toString() {
        return String.format("%-15s | %-15d | %-15s | %-15s", this.f.getName(), this.quantity, this.f.getPrice() + "$", Amount() + "$");
    }
}
