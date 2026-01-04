package com.designpattern.chapter11.rmi;

import java.rmi.server.UnicastRemoteObject;

public class HelloServiceImpl extends UnicastRemoteObject implements HelloService {

  public HelloServiceImpl() throws java.rmi.RemoteException {
    super();
  }

  @Override
  public String sayHello() throws java.rmi.RemoteException {
    return "Hello, world!";
  }
  
}
