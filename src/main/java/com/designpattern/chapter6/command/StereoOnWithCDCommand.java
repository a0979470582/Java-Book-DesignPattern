package com.designpattern.chapter6.command;

import com.designpattern.chapter6.object.Stereo;

public class StereoOnWithCDCommand implements Command {
  private Stereo stereo;

  public StereoOnWithCDCommand(Stereo stereo) {
    this.stereo = stereo;
  }

  @Override
  public void execute() {
    stereo.on();
    stereo.setCD("Awesome Mix Vol. 1");
    stereo.setVolume(11);
  }

  @Override
  public void undo() {
    stereo.off();
  }
}