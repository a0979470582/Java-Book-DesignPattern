package com.designpattern.chapter11.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloService extends Remote {
  String sayHello() throws RemoteException;
}
