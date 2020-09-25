public abstract class Product implements Item {
    int id;
    String type;
    String manufacturer;
    String name;

    public Product() {

    }

    public Product(String name, String manufacturer, String type) {
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

    public String toString() {
        return "Name: " + name + "\nManufacturer: " + manufacturer + "\nType: " + type;
    }


}
