package com.designpattern.chapter6.control;

import com.designpattern.chapter6.command.Command;

public class SimpleRemoteControl {
  private Command slot;

  public SimpleRemoteControl() {
  }

  public void setCommand(Command command) {
    this.slot = command;
  }

  public void onPressed() {
    slot.execute();
  }
}
