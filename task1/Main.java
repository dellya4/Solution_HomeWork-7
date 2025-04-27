import interfaces.EpisodeIterator;
import objects.Episode;
import objects.Season;
import objects.Series;

public class Main {
    public static void main(String[] args) {
        Series series = new Series();

        Season season1 = new Season();
        season1.addEpisode(new Episode("S1E1. Wolf Moon", 43));
        season1.addEpisode(new Episode("S1E2. Second Chance at First Line", 45));
        season1.addEpisode(new Episode("S1E3. Pack Mentality", 42));
        series.addSeason(season1);

        Season season2 = new Season();
        season2.addEpisode(new Episode("S2E1. Magic Bullet", 40));
        season2.addEpisode(new Episode("S2E2. The Tell", 49));
        season2.addEpisode(new Episode("S2E3. Heart Monitor", 51));
        series.addSeason(season2);

        Season season3 = new Season();
        season3.addEpisode(new Episode("S3E1. Night School", 44));
        season3.addEpisode(new Episode("S3E2. Lunatic", 43));
        season3.addEpisode(new Episode("S3E3. Wolf's Bane", 52));
        series.addSeason(season3);

        System.out.println(" The standard order (Season 1):");
        EpisodeIterator normalIterator = season1.createIterator();
        printEpisodes(normalIterator);

        System.out.println("\n Reverse order (Season 2):");
        EpisodeIterator reverseIterator = season2.createReverseIterator();
        printEpisodes(reverseIterator);

        System.out.println("\n Shuffle order (Season 3, seed=44):");
        EpisodeIterator shuffleIterator = season3.createShuffleIterator(43);
        printEpisodes(shuffleIterator);

        System.out.println("\n Full Binge Mode (all seasons in a row):");
        EpisodeIterator bingeIterator = series.createIterator();
        printEpisodes(bingeIterator);
    }

    private static void printEpisodes(EpisodeIterator iterator) {
        while (iterator.hasNext()) {
            iterator.next().play();
        }
    }
}
