package objects;

import interfaces.EpisodeCollection;
import interfaces.EpisodeIterator;
import iterators.BingeIterator;
import java.util.ArrayList;
import java.util.List;

public class Series implements EpisodeCollection { // Class Series which save all Seasons
    private List<Season> seasons = new ArrayList<>();

    public Series() {} // Constructor for Series

    public void addSeason(Season s){ // Function which add Seasons to Array
        seasons.add(s);
    }

    public List<Season> getSeasons(){ // Function which get Seasons from Array
        return seasons;
    }

    @Override
    public EpisodeIterator createIterator() { // // Create Iterator for getting all episodes by classing order
        return new BingeIterator(this);
    }

}
