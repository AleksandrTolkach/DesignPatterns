package by.toukach.observerpattern.service.impl;

import by.toukach.observerpattern.service.Display;
import by.toukach.observerpattern.service.Observer;
import by.toukach.observerpattern.service.WeatherData;

public class CurrentConditionsDisplay implements Observer, Display {

  private float temperature;
  private float humidity;
  private WeatherData weatherData;

  public CurrentConditionsDisplay(WeatherData weatherData) {
    this.weatherData = weatherData;
    weatherData.registerObserver(this);
  }

  @Override
  public void update() {
    this.temperature = weatherData.getTemp();
    this.humidity = weatherData.getHumidity();
    display();
  }

  @Override
  public void display() {
    System.out.printf("Current conditions: %s F degrees and %s humidity%n", temperature, humidity);
  }
}
