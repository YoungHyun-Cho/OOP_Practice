package kiosk.product;

public class Product {
    private int id;
    private String name;
    private Category category;
    private Size size;
    private int price;
    private int kcal;

    public Product(int id, String name, Category category, Size size, int price, int kcal) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.size = size;
        this.price = price;
        this.kcal = kcal;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public Size getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }

    public int getKcal() {
        return kcal;
    }
}
