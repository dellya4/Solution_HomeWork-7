import interfaces.EpisodeIterator;
import objects.Episode;
import objects.Season;
import objects.Series;

public class Main {
    public static void main(String[] args) {
        Series series = new Series(); // Create Series object

        Season season1 = new Season(); // Create Season1 object
        season1.addEpisode(new Episode("S1E1. Wolf Moon", 43));
        season1.addEpisode(new Episode("S1E2. Second Chance at First Line", 45));
        season1.addEpisode(new Episode("S1E3. Pack Mentality", 42));
        series.addSeason(season1); // Add season1 to series

        Season season2 = new Season(); // Create Season2 object
        season2.addEpisode(new Episode("S2E1. Magic Bullet", 40));
        season2.addEpisode(new Episode("S2E2. The Tell", 49));
        season2.addEpisode(new Episode("S2E3. Heart Monitor", 51));
        series.addSeason(season2); // Add season2 to series

        Season season3 = new Season(); // Create Season3 object
        season3.addEpisode(new Episode("S3E1. Night School", 44));
        season3.addEpisode(new Episode("S3E2. Lunatic", 43));
        season3.addEpisode(new Episode("S3E3. Wolf's Bane", 52));
        series.addSeason(season3); // Add season3 to series

        System.out.println(" The standard order (Season 1):");
        EpisodeIterator normalIterator = season1.createIterator(); // Create EpisodeIterator object with using CreateIterator function
        printEpisodes(normalIterator);

        System.out.println("\n Reverse order (Season 2):");
        EpisodeIterator reverseIterator = season2.createReverseIterator(); // Create ReverseIterator object with using CreateReverseIterator function
        printEpisodes(reverseIterator);

        System.out.println("\n Shuffle order (Season 3, seed=44):");
        EpisodeIterator shuffleIterator = season3.createShuffleIterator(43); // Create ShuffleIterator object with using ShuffleIterator function
        printEpisodes(shuffleIterator);

        System.out.println("\n Full Binge Mode (all seasons in a row):");
        EpisodeIterator bingeIterator = series.createIterator(); // Create BingeIterator object with using CreateIterator function
        printEpisodes(bingeIterator);
    }

    private static void printEpisodes(EpisodeIterator iterator) { // Function which get episodes by choosing iterator
        while (iterator.hasNext()) {
            iterator.next().play();
        }
    }
}
