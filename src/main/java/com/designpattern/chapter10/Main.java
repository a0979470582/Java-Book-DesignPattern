package com.designpattern.chapter10;

public class Main {
  public static void main(String[] args) {
    GumballMachine gumballMachine = new GumballMachine(5);

    // insert quarter 1
    gumballMachine.insertQuarter();
    gumballMachine.turnCrank();

    // insert quarter 2
    gumballMachine.insertQuarter();
    gumballMachine.ejectQuarter();
    gumballMachine.turnCrank();

    // insert quarter 3
    gumballMachine.insertQuarter();
    gumballMachine.turnCrank();

    // insert quarter 4
    gumballMachine.insertQuarter();
    gumballMachine.turnCrank();
    gumballMachine.ejectQuarter();
  }
}
