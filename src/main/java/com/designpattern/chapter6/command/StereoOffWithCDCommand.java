package com.designpattern.chapter6.command;

import com.designpattern.chapter6.object.Stereo;

public class StereoOffWithCDCommand implements Command {
  private Stereo stereo;
  private int prevVolume;
  private String prevCD;

  public StereoOffWithCDCommand(Stereo stereo) {
    this.stereo = stereo;
  }

  @Override
  public void execute() {
    prevVolume = stereo.getVolume();
    prevCD = stereo.getCD();
    stereo.off();
  }

  @Override
  public void undo() {  
    stereo.on();
    stereo.setCD(prevCD);
    stereo.setVolume(prevVolume);
  }
}