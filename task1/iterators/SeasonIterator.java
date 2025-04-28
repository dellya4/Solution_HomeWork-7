package iterators;

import interfaces.EpisodeIterator;
import objects.Episode;
import objects.Season;

public class SeasonIterator implements EpisodeIterator { // Class SeasonIterator for getting classic order
    private Season season;
    private int index;

    public SeasonIterator(Season season){ // Constructor for SeasonIterator
        this.season = season;
        this.index = 0;
    }

    public boolean hasNext(){ // Function which check have or null next Episode
        return index < season.getEpisodes().size();
    }

    public Episode next() { // Function which return next Episode or null
        return season.getEpisodes().get(index++);
    }
}
