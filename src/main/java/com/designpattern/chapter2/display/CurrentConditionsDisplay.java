package com.designpattern.chapter2.display;

import com.designpattern.chapter2.observer.Observer;
import com.designpattern.chapter2.subject.WeatherData;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
  private WeatherData weatherData;
  private float temperature;
  private float humidity;
  private float pressure;

  public CurrentConditionsDisplay(WeatherData weatherData) {
    this.weatherData = weatherData;
    this.weatherData.registerObserver(this);
  }

  @Override
  public void display() {
    System.out.println("Current conditions: %sC, %s%%, %shPa".formatted(temperature, humidity, pressure));
  }

  @Override
  public void update() {
    this.temperature = weatherData.getTemperature();
    this.humidity = weatherData.getHumidity();
    this.pressure = weatherData.getPressure();
    display();
  }

}
