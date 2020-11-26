import java.util.Date;

/**
 * Represents a ProductionRecord that will be store in the database PRODUCTIONRECORD.
 * A ProductionRecord have an name and id of the product, productionNumber, serialNumber
 * and dateProduced.
 *
 * @author Ronald Quiroz
 */
@SuppressWarnings("ALL")
public class ProductionRecord extends Controller {
  String name = "";
  int productionNumber;
  int productID;
  String serialNumber = " ";
  Date dateProduced;
  //I made this diff. counts so I can keep count of how many products of each type are there.
  // so I can increment serial number properly.

  /**
   * Default constructor for ProductionRecord.
   */
  public ProductionRecord() {
    dateProduced = new Date();
  }

  /**
   * Just like the default constructor, but assigning the id of the product.
   *
   * @param productID which will be the id of the product.
   */
  public ProductionRecord(int productID) {
    this.productID = productID;
    productionNumber = 0;
    serialNumber = "0";
    dateProduced = new Date();
  }

  /**
   * Constructor to assign values to the fields of a ProductionRecord.
   *
   * @param productionNumber which is the number on the list of production.
   * @param productID        which is the id of the product.
   * @param serialNumber     which will be the unique serialNumber of each product produced.
   * @param dateProduced     which will be the date in which the product was produced.
   */
  public ProductionRecord(int productionNumber, int productID, String serialNumber,
                          Date dateProduced) {
    this.productionNumber = productionNumber;
    this.productID = productID;
    this.serialNumber = serialNumber;
    this.dateProduced = dateProduced;
  }

  /**
   * Constructor to assign values to the productionRecord.
   *
   * @param product   which will be the product that will be produced.
   * @param itemCount which will be count of how many products of this
   *                  type have been produced before.
   */
  public ProductionRecord(Product product, int itemCount) {
    productNum++;
    productionNumber = productNum;
    //String with zeros to fill in the serialNumber.
    String numberPart = "00000";
    dateProduced = new Date();
    name = product.name;
    productID = product.id;

    //if else statements to decide how many zeros goes before the actual count.
    if (String.valueOf(itemCount).length() == 1) {
      numberPart = "0000" + itemCount;
    } else if (String.valueOf(itemCount).length() == 2) {
      numberPart = "000" + itemCount;
    } else if (String.valueOf(itemCount).length() == 3) {
      numberPart = "00" + itemCount;
    } else if (String.valueOf(itemCount).length() == 4) {
      numberPart = "0" + itemCount;
    } else if (String.valueOf(itemCount).length() == 5) {
      numberPart = "" + itemCount;
    }

    //assign the proper serial number. using subString.
    serialNumber = product.manufacturer.substring(0, 3) + product.type.code + numberPart;
  }

  /**
   * gets access to the productionNumber.
   *
   * @return int productionNumber.
   */
  public int getProductionNumber() {
    return productionNumber;
  }

  /**
   * makes available to change the productionNumber of the product.
   *
   * @param productionNumber productionNumber.
   */
  public void setProductionNumber(int productionNumber) {
    this.productionNumber = productionNumber;
  }

  /**
   * gets access to the productID.
   *
   * @return int productID.
   */
  public int getProductionID() {
    return productID;
  }

  /**
   * makes available to change the productID.
   *
   * @param productID id of product.
   */
  public void setProductID(int productID) {
    this.productID = productID;
  }

  /**
   * gets access to the serialNumber of the product.
   *
   * @return String serialNumber.
   */
  public String getSerialNumber() {
    return serialNumber;
  }

  /**
   * makes available to change the serialNumber of the product.
   *
   * @param serialNumber serialNumber of product.
   */
  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  /**
   * gets access to the date in which the product was produced.
   *
   * @return dateProduced.
   */
  public Date getDateProduced() {
    return dateProduced;
  }

  /**
   * makes available to change the date in which the product was produced.
   *
   * @param dateProduced date which product was produced.
   */
  public void setDateProduced(Date dateProduced) {
    this.dateProduced = dateProduced;
  }

  /**
   * Goes over the list of products checking if the ID matches so it can replace the id
   * for the name when printing in tab3.
   * Prints out the description of every field and data of a ProductionRecord.
   *
   * @return String description.
   */
  public String toString() {
    for (Product product : productsDB) {
      if (productID == product.id) {
        name = product.name;
      }
    }
    return "Prod. Num: " + productionNumber + " Product Name: " + name + " Serial Num: "
            + serialNumber + " Date: " + dateProduced;
  }


}
