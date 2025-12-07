package com.designpattern.chapter7;

import java.util.Enumeration;
import java.util.Iterator;

public class EnumerationIterator implements Iterator<Object> {
  Enumeration<?> enumeration;

  public EnumerationIterator(Enumeration<?> enumeration) {
    this.enumeration = enumeration;
  }

  @Override
  public boolean hasNext() {
    System.out.println("EnumerationIterator.hasNext() called");
    return enumeration.hasMoreElements();
  }

  @Override
  public Object next() {
    System.out.println("EnumerationIterator.next() called");
    return enumeration.nextElement();
  }

  @Override
  public void remove() {
    System.out.println("EnumerationIterator.remove() called");
    throw new UnsupportedOperationException("Remove operation is not supported.");
  }
}