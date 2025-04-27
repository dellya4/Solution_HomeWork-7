package objects;

public class Episode {
    private String title;
    private int runtimeMinutes;

    public Episode(String title, int runtimeMinutes) {
        this.title = title;
        this.runtimeMinutes = runtimeMinutes;
    }

    public String getTitle() {
        return title;
    }

    public int getRuntimeSec() {
        return runtimeMinutes;
    }

    public void play() {
        System.out.println("Playing episode: " + title);
    }
}
