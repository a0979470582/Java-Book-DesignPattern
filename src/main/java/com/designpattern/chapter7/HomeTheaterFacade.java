package com.designpattern.chapter7;

public class HomeTheaterFacade {
  Amplifier amplifier;
  Tuner tuner;
  DvdPlayer dvdPlayer;
  CdPlayer cdPlayer;
  Projector projector;
  TheaterLights theaterLights;

  public HomeTheaterFacade(Amplifier amplifier, Tuner tuner, DvdPlayer dvdPlayer,
      CdPlayer cdPlayer, Projector projector, TheaterLights theaterLights) {
    this.amplifier = amplifier;
    this.tuner = tuner;
    this.dvdPlayer = dvdPlayer;
    this.cdPlayer = cdPlayer;
    this.projector = projector;
    this.theaterLights = theaterLights;
  }

  public void watchMovie(String movie) {
    System.out.println("Get ready to watch a movie...");
    theaterLights.dim(10);
    projector.on();
    dvdPlayer.on();
    dvdPlayer.play(movie);
    amplifier.on();
    amplifier.setDvd(dvdPlayer);
    amplifier.setSurroundSound();
    amplifier.setVolume(5);
  }

  public void endMovie() {
    System.out.println("Shutting movie theater down...");
    theaterLights.on();
    projector.off();
    dvdPlayer.stop();
    dvdPlayer.eject();
    dvdPlayer.off();
    amplifier.off();
  }
}

class Amplifier {
  public void on() {
    System.out.println("Amplifier on");
  }

  public void off() {
    System.out.println("Amplifier off");
  }

  public void setDvd(DvdPlayer dvd) {
    System.out.println("Amplifier setting DVD player");
  }

  public void setSurroundSound() {
    System.out.println("Amplifier surround sound on (5 speakers, 1 subwoofer)");
  }

  public void setVolume(int level) {
    System.out.println("Amplifier setting volume to " + level);
  }
}

class Tuner {
  // Tuner methods
}

class DvdPlayer {
  public void on() {
    System.out.println("DVD Player on");
  }

  public void off() {
    System.out.println("DVD Player off");
  }

  public void play(String movie) {
    System.out.println("DVD Player playing \"" + movie + "\"");
  }

  public void stop() {
    System.out.println("DVD Player stopped");
  }

  public void eject() {
    System.out.println("DVD Player eject");
  }
}

class CdPlayer {
  // CD Player methods
}

class Projector {
  public void on() {
    System.out.println("Projector on");
  }

  public void off() {
    System.out.println("Projector off");
  }
}

class TheaterLights {
  public void dim(int level) {
    System.out.println("Theater Lights dimming to " + level + "%");
  }

  public void on() {
    System.out.println("Theater Lights on");
  }
}