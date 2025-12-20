package com.designpattern.chapter8.list;

import java.util.AbstractList;

public class MyStringList extends AbstractList<String> {
  private String[] list;

  public MyStringList(String[] list) {
    this.list = list;
  }

  @Override
  public int size() {
    System.out.println("size() called");
    return list.length;
  }

  @Override
  public String get(int index) {
    System.out.println("get(" + index + ") called");
    return list[index];
  }

  @Override
  public String set(int index, String element) {
    System.out.println("set(" + index + ", " + element + ") called");
    String old = list[index];
    list[index] = element;
    return old;
  }
}