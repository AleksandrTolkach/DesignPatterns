package by.toukach.decoratorpattern.beverage.decorator;

import by.toukach.decoratorpattern.beverage.Beverage;
import lombok.Data;

@Data
public abstract class CondimentDecorator extends Beverage {

  private Beverage beverage;

  @Override
  public abstract String getDescription();
}
