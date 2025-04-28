package iterators;

import interfaces.EpisodeIterator;
import objects.Episode;
import objects.Season;

public class ReverseSeasonIterator implements EpisodeIterator { // Class ReverseSeason for getting reverse order
    private Season season;
    private int index;

    public ReverseSeasonIterator(Season season) { // Constructor for ReverseSeasonIterator
        this.season = season;
        this.index = season.getEpisodes().size()-1;
    }

    public boolean hasNext() { // Function which check have or null next Episode
        return index >= 0;
    }

    public Episode next() { // Function which return next Episode or null
        return season.getEpisodes().get(index--);
    }


}
