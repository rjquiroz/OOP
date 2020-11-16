/**
 * Represents a MoviePlayer that can play, stop, go to the previous or next song.
 * Implements the interface MultimediaControl.
 * @author Ronald Quiroz
 */
public class MoviePlayer extends Product implements MultimediaControl {

  final Screen screen;
  final MonitorType monitorType;

  /**
   * Constructor to assign values to the fields of a moviePlayer and a Product.
   * @param name assign the name of the product.
   * @param manufacturer assign the name of the manufacturer of the Product.
   * @param screen assign the Screen to the MoviePlayer of type Product.
   * @param monitorType assign the type of monitor to the MoviePlayer of type Product.
   */
  public MoviePlayer(String name, String manufacturer, Screen screen, MonitorType monitorType) {
    super(name, manufacturer, ItemType.VISUAL);
    this.screen = screen;
    this.monitorType = monitorType;

  }

  /**
   * display a message of playing movie.
   */
  @Override
  public void play() {
    System.out.println("Playing movie");
  }

  /**
   * display a message of stopping movie.
   */
  @Override
  public void stop() {
    System.out.println("Stopping movie");

  }

  /**
   * display a message of going to previous movie.
   */
  @Override
  public void previous() {
    System.out.println("Previous movie");
  }

  /**
   * display a message of going to next movie.
   */
  @Override
  public void next() {
    System.out.println("Next movie");
  }

  /**
   * Prints out the description of every field and data of the MoviePlayer.
   * returns a String.
   */
  public String toString() {
    return super.toString() + "Screen: \nResolution: " + screen.resolution + "\nRefresh Rate: "
            + screen.refreshRate + "\nResponse Time: " + screen.responseTime + "\nMonitor Type: "
            + monitorType;
  }

}
