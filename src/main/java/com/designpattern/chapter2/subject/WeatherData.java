package com.designpattern.chapter2.subject;

import java.util.ArrayList;
import java.util.List;

import com.designpattern.chapter2.observer.Observer;

public class WeatherData implements Subject {
  private List<Observer> observers;
  private float temperature;
  private float humidity;
  private float pressure;

  public WeatherData() {
    this.observers = new ArrayList<Observer>();
  }

  @Override
  public void registerObserver(Observer observer) {
    this.observers.add(observer);
  }

  @Override
  public void removeObserver(Observer observer) {
    if (this.observers.contains(observer)) {
      this.observers.remove(observer);
    }
  }

  @Override
  public void notifyObservers() {
    for (Observer observer : this.observers) {
      observer.update();
    }
  }

  public void measurementsChanged() {
    notifyObservers();
  }

  public void setMeasurements(float temperature, float humidity, float pressure) {
    this.temperature = temperature;
    this.humidity = humidity;
    this.pressure = pressure;
    measurementsChanged();
  }

  public float getTemperature() {
    return this.temperature;
  }

  public float getHumidity() {
    return this.humidity;
  }

  public float getPressure() {
    return this.pressure;
  }
}
