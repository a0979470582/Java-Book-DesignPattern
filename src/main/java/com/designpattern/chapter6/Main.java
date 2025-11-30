package com.designpattern.chapter6;

import com.designpattern.chapter6.command.Command;
import com.designpattern.chapter6.command.LightOffCommand;
import com.designpattern.chapter6.command.LightOnCommand;
import com.designpattern.chapter6.command.MacroCommand;
import com.designpattern.chapter6.command.StereoOffWithCDCommand;
import com.designpattern.chapter6.command.StereoOnWithCDCommand;
import com.designpattern.chapter6.control.RemoteControl;
import com.designpattern.chapter6.object.Light;
import com.designpattern.chapter6.object.Stereo;

public class Main {
  public static void main(String[] args) {
    RemoteControl remoteControl = new RemoteControl();

    Light light = new Light();
    LightOnCommand lightOn = new LightOnCommand(light);
    LightOffCommand lightOff = new LightOffCommand(light);

    Stereo stereo = new Stereo();
    StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
    StereoOffWithCDCommand stereoOffWithCD = new StereoOffWithCDCommand(stereo);

    MacroCommand partyOn = new MacroCommand(new Command[] { lightOn, stereoOnWithCD });
    MacroCommand partyOff = new MacroCommand(new Command[] { lightOff, stereoOffWithCD });

    remoteControl.setCommand(0, lightOn, lightOff);
    remoteControl.setCommand(1, stereoOnWithCD, stereoOffWithCD);
    remoteControl.setCommand(2, partyOn, partyOff);

    // Print Remote Control
    System.out.println(remoteControl);

    // Test Light On/Off/Undo
    System.out.println("\n---- Testing Light On/Off/Undo ----");
    remoteControl.onButtonWasPressed(0);
    remoteControl.offButtonWasPressed(0);
    remoteControl.undoButtonWasPressed();

    System.out.println("\n---- Testing Stereo On/Off/Undo ----");
    // Test Stereo On/Off/Undo
    remoteControl.onButtonWasPressed(1);
    remoteControl.offButtonWasPressed(1);
    remoteControl.undoButtonWasPressed();

    System.out.println("\n---- Testing Party On/Off/Undo ----");
    // Test Party On/Off/Undo
    remoteControl.onButtonWasPressed(2);
    remoteControl.offButtonWasPressed(2);
    remoteControl.undoButtonWasPressed();

    // ----- Remote Control -----
    // [slot 0] LightOnCommand    LightOffCommand
    // [slot 1] StereoOnWithCDCommand    StereoOffWithCDCommand
    // [slot 2] MacroCommand    MacroCommand
    // [slot 3] NoCommand    NoCommand
    // [slot 4] NoCommand    NoCommand
    // [slot 5] NoCommand    NoCommand
    // [slot 6] NoCommand    NoCommand

    // Last Command: NoCommand


    // ---- Testing Light On/Off/Undo ----
    // Light is ON
    // Light is OFF
    // Light is ON

    // ---- Testing Stereo On/Off/Undo ----
    // Stereo is ON
    // Stereo is set for CD input: Awesome Mix Vol. 1
    // Stereo volume set to 11
    // Stereo is OFF
    // Stereo is ON
    // Stereo is set for CD input: Awesome Mix Vol. 1
    // Stereo volume set to 11

    // ---- Testing Party On/Off/Undo ----
    // Light is ON
    // Stereo is ON
    // Stereo is set for CD input: Awesome Mix Vol. 1
    // Stereo volume set to 11
    // Light is OFF
    // Stereo is OFF
    // Stereo is ON
    // Stereo is set for CD input: Awesome Mix Vol. 1
    // Stereo volume set to 11
    // Light is ON

  }
}