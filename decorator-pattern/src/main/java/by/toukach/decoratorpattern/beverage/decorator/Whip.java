package by.toukach.decoratorpattern.beverage.decorator;

import by.toukach.decoratorpattern.beverage.Beverage;

public class Whip extends CondimentDecorator {

  public Whip(Beverage beverage) {
    setBeverage(beverage);
  }

  @Override
  public double cost() {
    return getBeverage().cost() + .10;
  }

  @Override
  public String getDescription() {
    return getBeverage().getDescription() + ", Whip";
  }
}
