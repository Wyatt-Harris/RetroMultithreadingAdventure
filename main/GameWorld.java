package main;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;


public class GameWorld {
private final List<Room> rooms = new ArrayList<>();
private final BlockingQueue<Event> eventQueue = new LinkedBlockingQueue<>();
private final AtomicBoolean gameOver = new AtomicBoolean(false);
private final AtomicReference<String> weather = new AtomicReference<>("Clear");


public GameWorld() {
// Build minimal world
Room hall = new Room("Great Hall");
Room library = new Room("Library");
Room dungeon = new Room("Dungeon");
rooms.add(hall);
rooms.add(library);
rooms.add(dungeon);


// place an example Horcrux in the library
HorcruxFragment hf = new HorcruxFragment("Fragment-1");
library.addItem(hf);
}


public List<Room> getRooms() { return Collections.unmodifiableList(rooms); }
public BlockingQueue<Event> getEventQueue() { return eventQueue; }
public boolean isGameOver() { return gameOver.get(); }
public void setGameOver(boolean v) { gameOver.set(v); }
public String getWeather() { return weather.get(); }
public void setWeather(String w) { weather.set(w); }
}