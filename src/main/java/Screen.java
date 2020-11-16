/**
 * Represents a Screen for moviePlayers.
 * It implements the interface ScreenSpec.
 * A Screen has a String resolution, int refreshRate, int responseTime as fields.
 * @author Ronald Quiroz
 */
public class Screen implements ScreenSpec {

  String resolution;
  int refreshRate;
  int responseTime;

  /**
   * Default constructor for ProductionRecord.
   */
  public Screen() {

  }

  /**
   * Constructor to assign values to the fields of a new Screen.
   * @param resolution for the resolution of a new Screen.
   * @param refreshRate an int for the refreshRate of the Screen
   * @param responseTime an int for the responseTime of the Screen.
   */
  public Screen(String resolution, int refreshRate, int responseTime) {
    this.resolution = resolution;
    this.refreshRate = refreshRate;
    this.responseTime = responseTime;
  }

  /**
   * gets access to the resolution of the Screen.
   * returns a String.
   */
  @Override
  public String getResolution() {
    return resolution;
  }

  /**
   * gets access to the refreshRate of the Screen.
   * returns an int.
   */
  @Override
  public int getRefreshRate() {
    return refreshRate;
  }

  /**
   * gets access to the responseTime of the Screen.
   * returns an int.
   */
  @Override
  public int getResponseTime() {
    return responseTime;
  }

  /**
   * Prints out the description of every field and data of the Screen.
   * returns a String.
   */
  public String toString() {
    return "Screen: \nResolution: " + resolution + "\nRefresh Rate: " + refreshRate
            + "\nResponse Time: " + responseTime;
  }
}
