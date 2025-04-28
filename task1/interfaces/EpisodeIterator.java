package interfaces;

import objects.Episode;

public interface EpisodeIterator { // Interface for EpisodeIterator
    boolean hasNext(); // Function which check have or no next element
    Episode next(); // Get next Episode if it has
}
