package com.designpattern.chapter6.object;

public class Stereo {
  private int volume;
  private String cd;

  public void on() {
    System.out.println("Stereo is ON");
  }

  public void off() {
    this.volume = 0;
    this.cd = null;
    System.out.println("Stereo is OFF");
  }

  public void setCD(String cd) {
    this.cd = cd;
    System.out.println("Stereo is set for CD input: " + cd);
  }

  public void setVolume(int volume) {
    this.volume = volume;
    System.out.println("Stereo volume set to " + volume);
  }

  public int getVolume() {
    return volume;
  }

  public String getCD() {
    return cd;
  }
}
