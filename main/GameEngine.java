package main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * GameEngine runs the character runnables from a fixed thread pool.
 */
public class GameEngine {
public static void main(String[] args) throws InterruptedException {
    System.out.println("Starting Threads of Magic - Skeleton Project");


    GameWorld world = new GameWorld();


// Event dispatcher
    EventDispatcher dispatcher = new EventDispatcher(world.getEventQueue());
    Thread dispatcherThread = new Thread(dispatcher, "EventDispatcher");
    dispatcherThread.start();


// Optional systems (API integrators)
Thread weatherThread = new Thread(new WeatherSystem(world), "WeatherSystem");
weatherThread.setDaemon(true);
weatherThread.start();


// Create characters
    ExecutorService characters = Executors.newFixedThreadPool(3);
    characters.submit(new Harry("Harry", world));
    characters.submit(new Hermione("Hermione", world));
    characters.submit(new Ron("Ron", world));


// Run the game for a short time then shut down (for skeleton demo)
    Thread.sleep(8000);


    System.out.println("Shutting down...");
    world.setGameOver(true);


    characters.shutdownNow();
    dispatcher.stop();
    dispatcherThread.interrupt();
    weatherThread.interrupt();
    }
}