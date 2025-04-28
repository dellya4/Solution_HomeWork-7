package objects;

import interfaces.EpisodeCollection;
import interfaces.EpisodeIterator;
import iterators.ReverseSeasonIterator;
import iterators.SeasonIterator;
import iterators.ShuffleSeasonIterator;
import java.util.ArrayList;
import java.util.List;

public class Season implements EpisodeCollection { // Class EpisodeCollection which save Episode from 1 Season
    private List<Episode> episodes = new ArrayList<>();

    public Season() {} // Constructor for Season

    public void addEpisode(Episode e) { // Function which add Episodes to Array
        episodes.add(e);
    }

    public List<Episode> getEpisodes() { // Function which get Episodes from Array
        return episodes;
    }

    @Override
    public EpisodeIterator createIterator() { // Create Iterator for getting episodes by classing order
        return new SeasonIterator(this);
    }

    public EpisodeIterator createReverseIterator() { // Create Iterator for getting episodes by reverse order
        return new ReverseSeasonIterator(this);
    }

    public EpisodeIterator createShuffleIterator(long seed) { // Create Iterator for getting episodes by random order. Take seed (first element which will be in order)
        return new ShuffleSeasonIterator(this, seed);
    }
}
