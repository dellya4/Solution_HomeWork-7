package objects;

import interfaces.EpisodeCollection;
import interfaces.EpisodeIterator;
import iterators.BingeIterator;

import java.util.ArrayList;
import java.util.List;

public class Series implements EpisodeCollection {
    private List<Season> seasons = new ArrayList<>();

    public void addSeason(Season s){
        seasons.add(s);
    }

    public List<Season> getSeasons(){
        return seasons;
    }

    @Override
    public EpisodeIterator createIterator() {
        return new BingeIterator(this);
    }

}
