package by.toukach.observerpattern.service;

import by.toukach.observerpattern.service.Observer;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class WeatherData implements Subject {

  private Set<Observer> observerSet = new HashSet<>();
  private float temp = 0;
  private float humidity = 0;
  private float pressure = 0;

  @Override
  public void registerObserver(Observer observer) {
    observerSet.add(observer);
  }

  @Override
  public void removeObserver(Observer observer) {
    observerSet.remove(observer);
  }

  @Override
  public void notifyObservers() {
    observerSet.stream()
        .forEach(o -> o.update());
  }

  @Override
  public void measurementChanged() {
    notifyObservers();
  }

  public void setMeasurements(float temp, float humidity, float pressure) {
    this.temp = temp;
    this.humidity = humidity;
    this.pressure = pressure;
    measurementChanged();
  }

  public float getTemp() {
    return temp;
  }

  public float getHumidity() {
    return humidity;
  }

  public float getPressure() {
    return pressure;
  }
}
