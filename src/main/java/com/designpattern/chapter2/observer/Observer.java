package com.designpattern.chapter2.observer;

public interface Observer {
  /*
   * This method is called when the subject's state changes.
   * But it does not take any parameters. So this is a pull model, not a push
   * model, Normally, a push model is more used.
   * 
   * Push model:
   * public void update(float temperature, float humidity, float pressure);
   * 
   * Pull model:
   * public void update();
   */
  public void update();
}
