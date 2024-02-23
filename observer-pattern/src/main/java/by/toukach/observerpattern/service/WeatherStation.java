package by.toukach.observerpattern.service;

import by.toukach.observerpattern.service.impl.CurrentConditionsDisplay;
import by.toukach.observerpattern.service.impl.ForecastDisplay;
import by.toukach.observerpattern.service.impl.StatisticDisplay;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WeatherStation implements ApplicationRunner {

  private final WeatherData weatherData;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    Observer currentDisplay = new CurrentConditionsDisplay(weatherData);
    Observer statisticDisplay = new StatisticDisplay(weatherData);
    Observer forecastDisplay = new ForecastDisplay(weatherData);

    weatherData.setMeasurements(80, 65, 30.4f);
    weatherData.setMeasurements(82, 70, 29.2f);
    weatherData.setMeasurements(78, 90, 29.2f);
  }
}
