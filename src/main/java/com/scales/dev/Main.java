package com.scales.dev;

import com.scales.dev.screens.Title;
import com.scales.dev.window.Canvas;
import com.scales.dev.window.Frame;

public class Main {
  public static final Frame FRAME = new Frame("base");

  public static void main(String[] args) {
    Canvas titleScreen = new Title();
    FRAME.addCanvas(titleScreen);
    // centers the window
    FRAME.setLocationRelativeTo(null);
  }
}