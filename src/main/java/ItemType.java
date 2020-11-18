/**
 * Represents the type of the Item created.
 * there are 4 types: AUDIO, VISUAL, AUDIOMOBILE, VISUALMOBILE.
 *
 * @author Ronald Quiroz
 */
@SuppressWarnings("ALL")
public enum ItemType {
  AUDIO("AU"), VISUAL("VI"), AUDIOMOBILE("AM"), VISUALMOBILE("VM");

  public String code;

  ItemType(String code) {
    this.code = code;
  }

}
