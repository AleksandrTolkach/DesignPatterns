package by.toukach.decoratorpattern.beverage.decorator;

import by.toukach.decoratorpattern.beverage.Beverage;

public class Mocha extends CondimentDecorator {

  public Mocha(Beverage beverage) {
    setBeverage(beverage);
  }

  @Override
  public double cost() {
    return getBeverage().cost() + .20;
  }

  @Override
  public String getDescription() {
    return getBeverage().getDescription() + ", Mocha";
  }
}
