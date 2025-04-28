package iterators;

import interfaces.EpisodeIterator;
import objects.Episode;
import objects.Season;
import objects.Series;
import java.util.Iterator;

public class BingeIterator implements EpisodeIterator{ // Class for BingeIterator for getting all season

    private Iterator<Season> seasonIterator;
    private EpisodeIterator current;
    public BingeIterator(Series series) { // Constructor for BingeIterator
        this.seasonIterator = series.getSeasons().iterator(); // Take seasonIterator from series
        if (seasonIterator.hasNext()) { // Put current EpisodeIterator from season
            current = seasonIterator.next().createIterator();
        }
    }

    public boolean hasNext() { // Function which check have or null next Episode
        while ((current == null || !current.hasNext()) && seasonIterator.hasNext()) {
            current = seasonIterator.next().createIterator();
        }
        return current != null && current.hasNext();
    }

    public Episode next() { // Function which return next Episode or null
        if (hasNext())  return current.next();
        else return null;
    }
}
