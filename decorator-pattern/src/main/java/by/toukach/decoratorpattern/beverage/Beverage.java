package by.toukach.decoratorpattern.beverage;

import lombok.Data;

@Data
public abstract class Beverage {

  private String description = "Unknown Beverage";

  public abstract double cost();
}
