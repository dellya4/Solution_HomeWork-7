package iterators;

import interfaces.EpisodeIterator;
import objects.Episode;
import objects.Season;

import java.util.*;

public class ShuffleSeasonIterator implements EpisodeIterator { // Class ShuffleSeasonIterator for getting random order
    private List<Episode> shuffled;
    private int index;

    public ShuffleSeasonIterator(Season season, long seed) { // Constructor for ShuffleSeasonIterator
        shuffled = new ArrayList<>(season.getEpisodes());
        Collections.shuffle(shuffled, new Random(seed));
    }

    public boolean hasNext() { // Function which check have or null next Episode
        return index < shuffled.size();
    }

    public Episode next() { // Function which return next Episode or null
        return shuffled.get(index++);
    }
}
