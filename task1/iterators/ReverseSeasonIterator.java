package iterators;

import interfaces.EpisodeIterator;
import objects.Episode;
import objects.Season;

public class ReverseSeasonIterator implements EpisodeIterator {
    private Season season;
    private int index;

    public ReverseSeasonIterator(Season season) {
        this.season = season;
        this.index = season.getEpisodes().size()-1;
    }

    public boolean hasNext() {
        return index >= 0;
    }

    public Episode next() {
        return season.getEpisodes().get(index--);
    }


}
