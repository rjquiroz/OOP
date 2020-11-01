public abstract class Product implements Item {
    int id;
    ItemType type;
    String manufacturer;
    String name;

    public Product() {

    }

    public Product(String name, String manufacturer, ItemType type) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public ItemType getType() {
        return type;
    }

    public String toString() {
        return "Name: " + name + "\nManufacturer: " + manufacturer + "\nType: " + type;
    }


}
