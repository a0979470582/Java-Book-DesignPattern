package com.designpattern.chapter2.subject;

import com.designpattern.chapter2.observer.Observer;

public interface Subject {
  public void registerObserver(Observer observer);
  public void removeObserver(Observer observer);
  public void notifyObservers();
}
