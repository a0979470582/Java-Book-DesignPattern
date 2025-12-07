package com.designpattern.chapter7;

import java.util.Enumeration;
import java.util.Stack;

public class Main {
  public static void main(String[] args) {
    System.out.println("Test Turkey to Duck Adapter:");
    System.out.println("===========================================================");
    testTurkeyToDuckAdapter();
    System.out.println("===========================================================\n");


    System.out.println("Test Enumeration Iterator:");
    System.out.println("===========================================================");
    testEnumerationIterator();
    System.out.println("===========================================================\n");

    System.out.println("Test Home Theater Facade:");
    System.out.println("===========================================================");
    testHomeTheaterFacade();
    System.out.println("===========================================================\n");
  }

  private static void testTurkeyToDuckAdapter() {
    Duck duck = new TurkeyToDuckAdapter(new WildTurkey());
    duck.quack(); // Gobble gobble
    duck.fly(); // I'm flying a short distance
  }

  private static void testEnumerationIterator() {
    Stack<String> stack = new Stack<>();

    stack.push("Item 1");
    stack.push("Item 2");
    stack.push("Item 3");

    Enumeration<String> iterator = stack.elements();

    EnumerationIterator enumerationIterator = new EnumerationIterator(iterator);

    while (enumerationIterator.hasNext()) {
      System.out.println(enumerationIterator.next());
    }

    try {
      enumerationIterator.remove();
    } catch (UnsupportedOperationException e) {
      System.out.println("Remove operation is not supported.");
    }

    // EnumerationIterator.hasNext() called
    // EnumerationIterator.next() called
    // Item 1
    // EnumerationIterator.hasNext() called
    // EnumerationIterator.next() called
    // Item 2
    // EnumerationIterator.hasNext() called
    // EnumerationIterator.next() called
    // Item 3
    // EnumerationIterator.hasNext() called
    // EnumerationIterator.remove() called
    // Remove operation is not supported.
  }

  private static void testHomeTheaterFacade() {
    HomeTheaterFacade homeTheater = new HomeTheaterFacade(
        new Amplifier(),
        new Tuner(),
        new DvdPlayer(),
        new CdPlayer(),
        new Projector(),
        new TheaterLights());
    homeTheater.watchMovie("Raiders of the Lost Ark");
    homeTheater.endMovie();
  }
}
