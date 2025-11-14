package main;


import java.net.http.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;


public class WeatherSystem implements Runnable {
private final GameWorld world;
private final HttpClient client = HttpClient.newHttpClient();


public WeatherSystem(GameWorld world) { this.world = world; }


@Override
public void run() {
while (!Thread.currentThread().isInterrupted() && !world.isGameOver()) {
try {
String url = "https://api.open-meteo.com/v1/forecast?latitude=55.9533&longitude=-3.1883&current=temperature_2m,weather_code";
// For the skeleton we simulate changing weather randomly.
String[] cond = {"Clear", "Cloudy", "Rain", "Thunderstorm"};
String pick = cond[ThreadLocalRandom.current().nextInt(cond.length)];
world.setWeather(pick);
world.getEventQueue().offer(new Event("WeatherUpdate", e -> System.out.println("[Weather] " + pick)));
TimeUnit.SECONDS.sleep(5);
} catch (InterruptedException e) {
Thread.currentThread().interrupt();
break;
}
}
System.out.println("WeatherSystem exiting.");
}
}