public class AudioPlayer extends Product implements MultimediaControl {

    String supportedAudioFormats;
    String SupportedPlaylistFormats;

    public AudioPlayer(String name, String manufacturer, String supportedAudioFormats, String SupportedPlaylistFormats) {
        super(name, manufacturer, ItemType.AUDIO);
        this.supportedAudioFormats = supportedAudioFormats;
        this.SupportedPlaylistFormats = SupportedPlaylistFormats;
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
        return super.toString() + "\nSupported Audio Formats: " + supportedAudioFormats + "\nSupported Playlist Formats: " + SupportedPlaylistFormats;
    }

}
