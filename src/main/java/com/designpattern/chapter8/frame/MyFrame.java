package com.designpattern.chapter8.frame;

import javax.swing.JFrame;
import java.awt.Graphics;

public class MyFrame extends JFrame {
  public MyFrame(String title) {
    setTitle(title);
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

  @Override
  public void paint(Graphics graphics) {
    super.paint(graphics);
    graphics.drawString("Hello, this is my custom frame!", 50, 100);
  }

  public static void main(String[] args) {
    new MyFrame("My Application Frame");
  }
}