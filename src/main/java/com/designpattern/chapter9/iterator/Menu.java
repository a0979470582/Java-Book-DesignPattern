package com.designpattern.chapter9.iterator;

import java.util.Iterator;

public interface Menu {
    Iterator<MenuItem> createIterator();
}