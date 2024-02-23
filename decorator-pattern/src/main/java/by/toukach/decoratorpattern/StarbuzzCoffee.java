package by.toukach.decoratorpattern;

import by.toukach.decoratorpattern.beverage.Beverage;
import by.toukach.decoratorpattern.beverage.DarkRoast;
import by.toukach.decoratorpattern.beverage.Espresso;
import by.toukach.decoratorpattern.beverage.HouseBlend;
import by.toukach.decoratorpattern.beverage.decorator.Mocha;
import by.toukach.decoratorpattern.beverage.decorator.Soy;
import by.toukach.decoratorpattern.beverage.decorator.Whip;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StarbuzzCoffee implements ApplicationRunner {

  private static final String LOG_TEMPLATE = "{} ${}";

  @Override
  public void run(ApplicationArguments args) throws Exception {
    Beverage beverage = new Espresso();
    log.info(LOG_TEMPLATE, beverage.getDescription(), beverage.cost());

    Beverage beverage2 = new DarkRoast();
    beverage2 = new Mocha(beverage2);
    beverage2 = new Mocha(beverage2);
    beverage2 = new Whip(beverage2);
    log.info(LOG_TEMPLATE, beverage2.getDescription(), beverage2.cost());

    Beverage beverage3 = new HouseBlend();
    beverage3 = new Soy(beverage3);
    beverage3 = new Mocha(beverage3);
    beverage3 = new Whip(beverage3);
    log.info(LOG_TEMPLATE, beverage3.getDescription(), beverage3.cost());
  }
}
