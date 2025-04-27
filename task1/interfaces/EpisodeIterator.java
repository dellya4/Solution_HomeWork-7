package interfaces;

import objects.Episode;

public interface EpisodeIterator {
    boolean hasNext();
    Episode next();
}
