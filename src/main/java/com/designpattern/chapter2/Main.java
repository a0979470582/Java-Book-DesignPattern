package com.designpattern.chapter2;

import com.designpattern.chapter2.display.CurrentConditionsDisplay;
import com.designpattern.chapter2.subject.WeatherData;

public class Main {
  public static void main(String[] args) {
    WeatherData weatherData = new WeatherData();

    // call register in constructor
    CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);

    // CurrentConditionsDisplay will be triggered to display
    weatherData.setMeasurements(30.0f, 65.0f, 30.4f);
    weatherData.setMeasurements(28.0f, 70.0f, 29.2f);
    weatherData.setMeasurements(26.0f, 90.0f, 29.2f);
  }
}
