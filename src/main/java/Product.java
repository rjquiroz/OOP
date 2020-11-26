/**
 * Represents a Product that will be created and added to the database.
 * Implements the interface Item.
 * A Product have an id, name, manufacturer, and type.
 *
 * @author Ronald Quiroz
 */
@SuppressWarnings("ALL")
public abstract class Product implements Item {
  int id;
  ItemType type;
  String manufacturer;
  String name;

  /**
   * Default constructor for Product.
   */
  public Product() {

  }

  /**
   * Constructor to assign values to the fields of a Product.
   *
   * @param name         assign the name of the product.
   * @param manufacturer assign the name of the manufacturer of the Product.
   * @param type         assign type to the Product from the enum.
   */
  public Product(String name, String manufacturer, ItemType type) {
    this.name = name;
    this.manufacturer = manufacturer;
    this.type = type;
  }

  /**
   * Constructor to assign values to the fields of a Product.
   *
   * @param id           assign id to the Product.
   * @param name         assign the name of the product.
   * @param manufacturer assign the name of the manufacturer of the Product.
   * @param type         assign type to the Product from the enum.
   */
  public Product(int id, String name, String manufacturer, ItemType type) {
    this.id = id;
    this.name = name;
    this.manufacturer = manufacturer;
    this.type = type;
  }

  /**
   * gets access to the id of the Product.
   *
   * @return int id of product.
   */
  public int getId() {
    return id;
  }

  /**
   * makes available to change the name of the Product.
   *
   * @param name name of product.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * gets access to the name of the Product.
   *
   * @return string name of product.
   */
  public String getName() {
    return name;
  }

  /**
   * makes available to change the manufacturer of the Product.
   *
   * @param manufacturer manufacturer of product.
   */
  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  /**
   * gets access to the manufacturer of the Product.
   *
   * @return a String manufacturer.
   */
  public String getManufacturer() {
    return manufacturer;
  }

  /**
   * makes available to change the type of the Product.
   *
   * @param type type of product.
   */
  public void setType(ItemType type) {
    this.type = type;
  }

  /**
   * gets access to the type of the Product.
   *
   * @return the ItemType of the product.
   */
  public ItemType getType() {
    return type;
  }

  /**
   * Prints out the description of every field and data of the Product.
   *
   * @return a String description.
   */
  public String toString() {
    return "Name: " + name + "\nManufacturer: " + manufacturer + "\nType: " + type;
  }


}
