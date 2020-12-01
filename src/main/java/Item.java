/**
 * Represents an Item created in the production project.
 * An Item have a name, id and manufacturer.
 *
 * @author Ronald Quiroz
 */
@SuppressWarnings({"ALL", "unused"})
public interface Item {

  int getId();

  void setName(String name);

  String getName();

  void setManufacturer(String manufacturer);

  String getManufacturer();

}
