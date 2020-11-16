/**
 * class that extends MultimediaControl interface.
 * @author Ronald Quiroz
 */
public class AudioPlayer extends Product implements MultimediaControl {

  final String supportedAudioFormats;
  final String supportedPlaylistFormats;

  /**
   * Constructor to set every field of this and the super class.
   * @param name name of the product.
   * @param manufacturer name of the manufacturer of the product.
   * @param supportedAudioFormats the types of audio formats supported.
   * @param supportedPlaylistFormats types of playlist formats supported.
   */
  public AudioPlayer(String name, String manufacturer, String supportedAudioFormats,
                     String supportedPlaylistFormats) {
    super(name, manufacturer, ItemType.AUDIO);
    this.supportedAudioFormats = supportedAudioFormats;
    this.supportedPlaylistFormats = supportedPlaylistFormats;
  }


  @Override
  public void play() {
    System.out.println("Playing");
  }

  @Override
  public void stop() {
    System.out.println("Stopping");
  }

  @Override
  public void previous() {
    System.out.println("Previous");
  }

  @Override
  public void next() {
    System.out.println("Next");
  }

  public String toString() {
    return super.toString() + "\nSupported Audio Formats: " + supportedAudioFormats
            + "\nSupported Playlist Formats: " + supportedPlaylistFormats;
  }

}
