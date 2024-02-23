package by.toukach.observerpattern.service.impl;

import by.toukach.observerpattern.service.Display;
import by.toukach.observerpattern.service.Observer;
import by.toukach.observerpattern.service.WeatherData;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class StatisticDisplay implements Observer, Display {

  private Map<UUID, Float> tempStatistic = new HashMap<>();
  private double minTemp = 0.0D;
  private double maxTemp = 0.0D;
  private double avgTemp = 0.0D;
  private WeatherData weatherData;

  public StatisticDisplay(WeatherData weatherData) {
    this.weatherData = weatherData;
    weatherData.registerObserver(this);
  }

  @Override
  public void update() {
    tempStatistic.put(UUID.randomUUID(), weatherData.getTemp());

    minTemp = tempStatistic.values().stream()
        .mapToDouble(v -> v)
        .min()
        .orElse(0);

    maxTemp = tempStatistic.values().stream()
        .mapToDouble(v -> v)
        .max()
        .orElse(0);

    avgTemp = tempStatistic.values().stream()
        .mapToDouble(v -> v)
        .average()
        .orElse(0);

    display();
  }

  @Override
  public void display() {
    System.out.printf("Avg/Max/Min temperature = %s/%s/%s%n", avgTemp, maxTemp, minTemp);
  }
}
