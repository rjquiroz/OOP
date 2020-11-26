/**
 * Just a class so we initialize so we can use the product abstract class.
 *
 * @author Ronald Quiroz
 */
@SuppressWarnings("ALL")
public class Widget extends Product {

  public Widget() {

  }

  /**
   * Constructor to assign values to the productionRecord.
   *
   * @param name         which will be the name of the product.
   * @param manufacturer which will be the manufacturer of the product.
   * @param type         which will be the type of product.
   */
  public Widget(String name, String manufacturer, ItemType type) {
    super(name, manufacturer, type);

  }

}
