# Solution_HomeWork-7

## Iterator Pattern

### Context:
The **Iterator** pattern is used in the series/seasons project to access `Episode` objects without exposing the internal storage structure.

### Why is `Iterator` better than just returning `List<Episode>`?

- **Data Encapsulation**  
  The `Season` class does not expose its internal `List<Episode>` directly. This protects the data from external interference and preserves internal consistency.

- **Traversal Flexibility**  
  Different iterators (`createIterator()`, `createReverseIterator()`, `createShuffleIterator(seed)`) allow for multiple traversal strategies without changing the internal structure.

- **Unified Interface**  
  The `printEpisodes(EpisodeIterator)` method can process any iterator type uniformly using the `hasNext()` and `next()` methods.

### Usage Examples:
```java
EpisodeIterator normal = season1.createIterator();           // normal order
EpisodeIterator reverse = season2.createReverseIterator();   // reverse order
EpisodeIterator shuffle = season3.createShuffleIterator(43); // shuffled order

printEpisodes(normal);
printEpisodes(reverse);
printEpisodes(shuffle);
```

---

## Mediator Pattern

### Context:
The **Mediator** pattern is used in the aircraft simulation project through the `ControlTower`, which coordinates all `Aircraft` actions.

### Why is Mediator better than direct communication between aircraft?

- **Reduced Coupling Between Objects**  
  Aircraft don't know about each other—they only interact with the control tower. This reduces dependencies and simplifies the system.

- **Centralized Logic**  
  All rules regarding takeoff, landing, and emergencies are handled in one place, making the system easier to maintain and extend.

- **Easier Scalability**  
  Adding new aircraft types or behaviors requires minimal changes to the rest of the codebase—mostly within the `ControlTower`.

### Downsides of Direct Communication:

- Complexity increases with more participants.
- Difficult to manage priorities (e.g., MAYDAY).
- No centralized control over execution flow.

### Example:
```java
helicopter.send("MAYDAY", tower);
```
The tower immediately grants the runway for emergency landing.
