package objects;

public class Episode { // Class Episode
    private String title;
    private int runtimeMinutes;

    public Episode(String title, int runtimeMinutes) { // Constructor for Episode
        this.title = title;
        this.runtimeMinutes = runtimeMinutes;
    }

    public String getTitle() { // Function which get Title from Episode
        return title;
    }

    public int getRuntimeMinutes() { // Function which get Runtime
        return runtimeMinutes;
    }

    public void play() {
        System.out.println("Playing episode: " + title);
    }
}
