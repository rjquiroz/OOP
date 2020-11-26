/**
 * Interface that represents the Screen specifications of a new Screen.
 *
 * @author Ronald Quiroz
 */
@SuppressWarnings("ALL")
public interface ScreenSpec {

  String getResolution();

  int getRefreshRate();

  int getResponseTime();

}
