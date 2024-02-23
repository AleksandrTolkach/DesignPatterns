package by.toukach.observerpattern.service.impl;

import by.toukach.observerpattern.service.Display;
import by.toukach.observerpattern.service.Observer;
import by.toukach.observerpattern.service.WeatherData;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ForecastDisplay implements Observer, Display {

  private List<String> forecastList = List.of("Improving weather on the day!",
      "Watch out for cooler, rainy weather", "More the same");

  public ForecastDisplay(WeatherData weatherData) {
    weatherData.registerObserver(this);
  }

  @Override
  public void update() {
    display();
  }

  @Override
  public void display() {
    ThreadLocalRandom random = ThreadLocalRandom.current();
    int i = random.nextInt(0, forecastList.size() - 1);

    System.out.println(forecastList.get(i));
  }
}
