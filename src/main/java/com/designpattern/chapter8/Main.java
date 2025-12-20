package com.designpattern.chapter8;

import com.designpattern.chapter8.beverage.CaffeineBeverage;
import com.designpattern.chapter8.beverage.Coffee;
import com.designpattern.chapter8.beverage.Tea;
import com.designpattern.chapter8.frame.MyFrame;
import com.designpattern.chapter8.list.MyStringList;

public class Main {
  public static void main(String[] args) {
    CaffeineBeverage tea = new Tea();
    tea.prepareRecipe();

    CaffeineBeverage coffee = new Coffee();
    coffee.prepareRecipe();

    // will call our overridden method paint()
    // MyFrame.main(new String[]{}); 

    // will call our overridden methods size() and get()
    String[] data = {"A", "B", "C"};
    MyStringList myList = new MyStringList(data);
    System.out.println("subList: " + myList.subList(0, 2));
  }
}
