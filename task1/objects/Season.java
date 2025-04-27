package objects;

import interfaces.EpisodeCollection;
import interfaces.EpisodeIterator;
import iterators.ReverseSeasonIterator;
import iterators.SeasonIterator;
import iterators.ShuffleSeasonIterator;

import java.util.ArrayList;
import java.util.List;

public class Season implements EpisodeCollection {
    private List<Episode> episodes = new ArrayList<>();

    public void addEpisode(Episode e) {
        episodes.add(e);
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    @Override
    public EpisodeIterator createIterator() {
        return new SeasonIterator(this);
    }

    public EpisodeIterator createReverseIterator() {
        return new ReverseSeasonIterator(this);
    }

    public EpisodeIterator createShuffleIterator(long seed) {
        return new ShuffleSeasonIterator(this, seed);
    }
}
