package iterators;

import interfaces.EpisodeIterator;
import objects.Episode;
import objects.Season;

public class SeasonIterator implements EpisodeIterator {
    private Season season;
    private int index;

    public SeasonIterator(Season season){
        this.season = season;
        this.index = 0;
    }

    public boolean hasNext(){
        return index < season.getEpisodes().size();
    }

    public Episode next() {
        return season.getEpisodes().get(index++);
    }
}
