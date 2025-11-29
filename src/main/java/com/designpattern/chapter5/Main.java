package com.designpattern.chapter5;

public class Main {
  public static void main(String[] args) throws InterruptedException {
    // thread not safe
    testNotThreadSafe();
    // 0 same instance? false
    // 1 same instance? false
    // 2 same instance? false
    // 3 same instance? false
    // 4 same instance? true

    // thread safe
    testThreadSafe();
    // 0 same instance? true
    // 1 same instance? true
    // 2 same instance? true
    // 3 same instance? true
    // 4 same instance? true

    // The instance is created by JVM class loader mechanism
    // So we can't test it with multiple threads like above
    SingletonPrivateLoader counter1 = SingletonPrivateLoader.getInstance();
    SingletonPrivateLoader counter2 = SingletonPrivateLoader.getInstance();
    System.out.println("same instance? " + (counter1 == counter2));
    // same instance? true

    // The instance is created by JVM class loader mechanism
    // So we can't test it with multiple threads like above
    SingletonThreadSafe counter3 = SingletonThreadSafe.getInstance();
    SingletonThreadSafe counter4 = SingletonThreadSafe.getInstance();
    System.out.println("same instance? " + (counter3 == counter4));
    // same instance? true
  }

  private static void testNotThreadSafe() throws InterruptedException {
    for (int i = 0; i < 5; i++) {
      SingletonNotThreadSafe.clearInstance();

      SingletonNotThreadSafe[] counters = new SingletonNotThreadSafe[2];

      Thread t1 = new Thread(() -> counters[0] = SingletonNotThreadSafe.getInstance());
      Thread t2 = new Thread(() -> counters[1] = SingletonNotThreadSafe.getInstance());

      t1.start();
      t2.start();

      t1.join();
      t2.join();

      System.out.println(i + " same instance? " + (counters[0] == counters[1]));
    }
  }

  private static void testThreadSafe() throws InterruptedException {
    for (int i = 0; i < 5; i++) {
      SingletonThreadSafe.clearInstance();

      SingletonThreadSafe[] counters = new SingletonThreadSafe[2];

      Thread t1 = new Thread(() -> counters[0] = SingletonThreadSafe.getInstance());
      Thread t2 = new Thread(() -> counters[1] = SingletonThreadSafe.getInstance());

      t1.start();
      t2.start();

      t1.join();
      t2.join();

      System.out.println(i + " same instance? " + (counters[0] == counters[1]));
    }
  }
}
