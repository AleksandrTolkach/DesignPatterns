package by.toukach.observerpattern.service;

public interface Subject {

  void registerObserver(Observer observer);
  void removeObserver(Observer observer);
  void notifyObservers();
  void measurementChanged();
}
