package com.designpattern.chapter11.rmi;

import java.rmi.Naming;

public class Client {
  public static void main(String[] args) throws Exception {
    // Get Service Object from RMI registry
    HelloService service = (HelloService) Naming.lookup("rmi://localhost/hello");

    // Call remote method
    String response = service.sayHello();

    System.out.println("Response from HelloService: " + response);
  }
}
