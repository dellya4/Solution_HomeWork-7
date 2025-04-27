package iterators;

import interfaces.EpisodeIterator;
import objects.Episode;
import objects.Season;

import java.util.*;

public class ShuffleSeasonIterator implements EpisodeIterator {
    private List<Episode> shuffled;
    private int index;

    public ShuffleSeasonIterator(Season season, long seed) {
        shuffled = new ArrayList<>(season.getEpisodes());
        Collections.shuffle(shuffled, new Random(seed));
    }

    public boolean hasNext() {
        return index < shuffled.size();
    }

    public Episode next() {
        return shuffled.get(index++);
    }
}
