package com.designpattern.chapter11.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Main {
  public static void main(String[] args) throws Exception {
    // Run RMI registry on localhost:1099
    LocateRegistry.createRegistry(1099);

    // Bind HelloService to the RMI registry
    Naming.bind("rmi://localhost/hello", new HelloServiceImpl());
    
    System.out.println("Service is running...");
    System.out.println("You can run the Client now. !!!!");
  }
}
