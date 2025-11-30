package com.designpattern.chapter6.control;

import com.designpattern.chapter6.command.Command;
import com.designpattern.chapter6.command.NoCommand;

public class RemoteControl {
  Command[] onCommands;
  Command[] offCommands;
  Command lastCommand;

  public RemoteControl() {
    onCommands = new Command[7];
    offCommands = new Command[7];

    Command noCommand = new NoCommand();

    for (int i = 0; i < 7; i++) {
      onCommands[i] = noCommand;
      offCommands[i] = noCommand;
    }
    lastCommand = noCommand;
  }

  public void setCommand(int slot, Command onCommand, Command offCommand) {
    onCommands[slot] = onCommand;
    offCommands[slot] = offCommand;
  }

  public void onButtonWasPressed(int slot) {
    onCommands[slot].execute();
    lastCommand = onCommands[slot];
  }

  public void offButtonWasPressed(int slot) {
    offCommands[slot].execute();
    lastCommand = offCommands[slot];
  }

  public void undoButtonWasPressed() {
    lastCommand.undo();
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("\n----- Remote Control -----\n");
    for (int i = 0; i < onCommands.length; i++) {
      stringBuilder.append("[slot " + i + "] " + onCommands[i].getClass().getSimpleName() + "    "
          + offCommands[i].getClass().getSimpleName() + "\n");
    }
    stringBuilder.append("\n");
    stringBuilder.append("Last Command: " + lastCommand.getClass().getSimpleName() + "\n");
    return stringBuilder.toString();
  }
}
