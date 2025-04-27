package iterators;

import interfaces.EpisodeIterator;
import objects.Episode;
import objects.Season;
import objects.Series;

import java.util.Iterator;

public class BingeIterator implements EpisodeIterator{

    private Iterator<Season> seasonIterator;
    private EpisodeIterator current;
    public BingeIterator(Series series) {
        this.seasonIterator = series.getSeasons().iterator();
        if (seasonIterator.hasNext()) {
            current = seasonIterator.next().createIterator();
        }
    }

    public boolean hasNext() {
        while ((current == null || !current.hasNext()) && seasonIterator.hasNext()) {
            current = seasonIterator.next().createIterator();
        }
        return current != null && current.hasNext();
    }

    public Episode next() {
        if (hasNext())  return current.next();
        else return null;
    }
}
