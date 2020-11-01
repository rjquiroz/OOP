import java.util.Date;

public class ProductionRecord {
    String name = "";
    int productionNumber;
    int productID;
    String serialNumber = " ";
    Date dateProduced;
    //I made this diff. counts so I can keep count of how many products of each type are there.
    // so I can increment serial number properly.
    static int countAU = 0, countVI = 0, countAM = 0, countVM = 0;

    public ProductionRecord() {

    }

    public ProductionRecord(int productID) {
        this.productID = productID;
        productionNumber = 0;
        serialNumber = "0";
        dateProduced = new Date();
    }

    public ProductionRecord(int productionNumber, int productID, String serialNumber, Date dateProduced) {
        this.productionNumber = productionNumber;
        this.productID = productID;
        this.serialNumber = serialNumber;
        this.dateProduced = dateProduced;
    }

    public ProductionRecord(Product product, int itemCount) {
        //String with zeros to fill in the serialNumber.
        String numberPart = "00000";
        productionNumber = itemCount;
        dateProduced = new Date();
        name = product.name;
        productID = product.id;

        //switch to decide to which count I have to sum. depending the ItemType of the product.
        //it also decides how many 0 to include base on the digits of the count.
        switch (product.type.code) {
            case "AU":
                countAU++;
                if (String.valueOf(countAU).length() == 1)
                    numberPart = "0000" + countAU;
                else if (String.valueOf(countAU).length() == 2)
                    numberPart = "000" + countAU;
                else if (String.valueOf(countAU).length() == 3)
                    numberPart = "00" + countAU;
                else if (String.valueOf(countAU).length() == 4)
                    numberPart = "0" + countAU;
                else if (String.valueOf(countAU).length() == 5)
                    numberPart = "" + countAU;
                break;
            case "VI":
                countVI++;
                if (String.valueOf(countVI).length() == 1)
                    numberPart = "0000" + countVI;
                else if (String.valueOf(countVI).length() == 2)
                    numberPart = "000" + countVI;
                else if (String.valueOf(countVI).length() == 3)
                    numberPart = "00" + countVI;
                else if (String.valueOf(countVI).length() == 4)
                    numberPart = "0" + countVI;
                else if (String.valueOf(countVI).length() == 5)
                    numberPart = "" + countVI;
                break;
            case "AM":
                countAM++;
                if (String.valueOf(countAM).length() == 1)
                    numberPart = "0000" + countAM;
                else if (String.valueOf(countAM).length() == 2)
                    numberPart = "000" + countAM;
                else if (String.valueOf(countAM).length() == 3)
                    numberPart = "00" + countAM;
                else if (String.valueOf(countAM).length() == 4)
                    numberPart = "0" + countAM;
                else if (String.valueOf(countAM).length() == 5)
                    numberPart = "" + countAM;
                break;
            case "VM":
                countVM++;
                if (String.valueOf(countVM).length() == 1)
                    numberPart = "0000" + countVM;
                else if (String.valueOf(countVM).length() == 2)
                    numberPart = "000" + countVM;
                else if (String.valueOf(countVM).length() == 3)
                    numberPart = "00" + countVM;
                else if (String.valueOf(countVM).length() == 4)
                    numberPart = "0" + countVM;
                else if (String.valueOf(countVM).length() == 5)
                    numberPart = "" + countVM;
                break;
        }
//assign the proper serial number. using subString.
        serialNumber = product.manufacturer.substring(0, 3) + product.type.code + numberPart;
    }


    public int getProductionNumber() {
        return productionNumber;
    }

    public void setProductionNumber(int productionNumber) {
        this.productionNumber = productionNumber;
    }

    public int getProductionID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Date getDateProduced() {
        return dateProduced;
    }

    public void setDateProduced(Date dateProduced) {
        this.dateProduced = dateProduced;
    }

    //prints the fields.
    public String toString() {
        return "Prod. Num: " + productionNumber + " Product name: " + name + " Serial Num: " + serialNumber + " Date: " + dateProduced;
    }


}
