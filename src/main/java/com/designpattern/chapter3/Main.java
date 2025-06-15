package com.designpattern.chapter3;

import com.designpattern.chapter3.beverage.Beverage;
import com.designpattern.chapter3.beverage.Espresso;
import com.designpattern.chapter3.beverage.HouseBlend;
import com.designpattern.chapter3.condiment.Mocha;
import com.designpattern.chapter3.condiment.Soy;
import com.designpattern.chapter3.condiment.Whip;

public class Main {
  public static void main(String[] args) {
    Beverage b1 = new Espresso();
    System.out.println(b1.getDescription() + " $" + b1.cost());
    // Espresso $1.99

    Beverage b2 = new HouseBlend();
    b2 = new Mocha(b2);
    b2 = new Mocha(b2);
    b2 = new Whip(b2);
    System.out.println(b2.getDescription() + " $" + b2.cost());
    // House Blend Coffee, Mocha, Mocha, Whip $1.3900000000000001

    Beverage b3 = new HouseBlend();
    b3 = new Soy(b3);
    b3 = new Mocha(b3);
    b3 = new Whip(b3);
    System.out.println(b3.getDescription() + " $" + b3.cost());
    // House Blend Coffee, Soy, Mocha, Whip $1.34

    Beverage b4 = new Espresso();
    b4.setSize(Beverage.Size.TALL);
    b4 = new Soy(b4);
    System.out.println(b4.getDescription() + " $" + b4.cost());
    // Espresso, Soy $2.09

    b4 = new Espresso();
    b4.setSize(Beverage.Size.GRANDE);
    b4 = new Soy(b4);
    System.out.println(b4.getDescription() + " $" + b4.cost());
    // Espresso, Soy $2.14

    b4 = new Espresso();
    b4.setSize(Beverage.Size.VENTI);
    b4 = new Soy(b4);
    System.out.println(b4.getDescription() + " $" + b4.cost());
    // Espresso, Soy $2.19

  }
}
